package clean.code.bobbycar.web.dto;

import java.util.List;

public class RentalResult {
    List<Driver> drivers;
    private List<String> reservationMessages;

    public RentalResult() {
    }

    public RentalResult(List<Driver> drivers, List<String> reservationMessages) {
        this.drivers = drivers;
        this.reservationMessages = reservationMessages;
    }

    public List<String> getReservationMessages() {
        return reservationMessages;
    }

    public void setReservationMessages(List<String> reservationMessages) {
        this.reservationMessages = reservationMessages;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
