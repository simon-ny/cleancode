package clean.code.dependency.reservation;

import java.util.List;

public class ReservationResponse {
    private List<ReservedCar> reservedCars;

    public List<ReservedCar> getReservedCars() {
        return reservedCars;
    }

    public void setReservedCars(List<ReservedCar> reservedCars) {
        this.reservedCars = reservedCars;
    }
}
