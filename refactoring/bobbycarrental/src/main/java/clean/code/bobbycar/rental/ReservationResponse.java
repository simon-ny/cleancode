package clean.code.bobbycar.rental;

import java.util.List;

public class ReservationResponse {
    private List<ReservedCars> reservedCars;

    public List<ReservedCars> getReservedCars() {
        return reservedCars;
    }

    public void setReservedCars(List<ReservedCars> reservedCars) {
        this.reservedCars = reservedCars;
    }
}
