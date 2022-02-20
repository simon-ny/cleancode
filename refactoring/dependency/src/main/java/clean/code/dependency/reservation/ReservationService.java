package clean.code.dependency.reservation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    public ReservationResponse checkAvailability(ReservationRequest reservationRequest) {
        ReservationResponse reservationResponse = new ReservationResponse();
        List<ReservedCar> reservedCars = new ArrayList<>();

        for (String car : reservationRequest.getCountedCars().keySet()) {
            reservedCars.add(
                    new ReservedCar(
                            car,
                            reservationRequest.getCountedCars().get(car),
                            BobbyCars.byName(car).availableUnits)
            );
        }

        reservationResponse.setReservedCars(reservedCars);

        return reservationResponse;
    }

}
