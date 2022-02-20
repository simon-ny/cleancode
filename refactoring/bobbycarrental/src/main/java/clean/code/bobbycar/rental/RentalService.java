package clean.code.bobbycar.rental;

import clean.code.bobbycar.exception.TooManyDriversException;
import clean.code.bobbycar.web.dto.Driver;
import clean.code.bobbycar.web.dto.RentalOptions;
import clean.code.bobbycar.web.dto.RentalResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    public static final String VERIFY_SERVICE_URL = "http://localhost:8081/api/v1/verify/";
    public static final String RESERVATION_SERVICE_URL = "http://localhost:8081/api/v1/reservation";
    public static final int MAX_DRIVERS = 10;

    public RentalResult rent(RentalOptions rentalOptions) {

        verifyNumberOfDrivers(rentalOptions);

        List<Driver> validDrivers  = verifyDriversAge(rentalOptions);

        List<String> reservationMessages = makeReservation(validDrivers);

        return new RentalResult(validDrivers, reservationMessages);
    }

    private void verifyNumberOfDrivers(RentalOptions rentalOptions) {
        if (rentalOptions.getDrivers().size() > MAX_DRIVERS) {
            throw new TooManyDriversException();
        }
    }

    private List<String> makeReservation(List<Driver> validDrivers) {
        RestTemplate restTemplate = new RestTemplate();

        ReservationRequest reservationRequest = new ReservationRequest(
                validDrivers
                .stream()
                .collect(Collectors.groupingBy(Driver::getCar, Collectors.counting())));

        ReservationResponse reservationResponse = restTemplate.postForObject(RESERVATION_SERVICE_URL, reservationRequest, ReservationResponse.class);

        List<String> reservationMessages = new ArrayList<>();
        for (ReservedCars reservedCar : reservationResponse.getReservedCars()) {
            for (int i = 0; i < reservedCar.getAvailableUnits(); i++) {
                reservationMessages.add(reservedCar.getName() + " car reserved");
            }
            for (int i = 0; i < reservedCar.getRequestedUnits() - reservedCar.getAvailableUnits(); i++) {
                reservationMessages.add(reservedCar.getName() + " car out of stock");
            }
        }
        return reservationMessages;
    }

    private List<Driver> verifyDriversAge(RentalOptions rentalOptions) {
        RestTemplate restTemplate = new RestTemplate();

        String driversAge = rentalOptions
                .getDrivers()
                .stream()
                .map(Driver::getAge)
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        VerificationResponse verificationResponse = restTemplate
                .getForObject(VERIFY_SERVICE_URL + "?age=" + driversAge, VerificationResponse.class);

        List<Driver> validDrivers = new ArrayList<>();

        for (VerifiedDriver verifiedDriver : verificationResponse.getVerifiedDrivers()) {
            for (Driver driver : rentalOptions.getDrivers()) {
                if (verifiedDriver.getAge() == driver.getAge()) {
                    validDrivers.add(driver);
                    break;
                }
            }
        }

        return validDrivers;
    }
}
