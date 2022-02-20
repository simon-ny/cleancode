package clean.code.bobbycar.rental;

import java.util.Map;

public class ReservationRequest {
    Map<String, Long> countedCars;

    public ReservationRequest(Map<String, Long> countedCars) {
        this.countedCars = countedCars;
    }

    public Map<String, Long> getCountedCars() {
        return countedCars;
    }

    public void setCountedCars(Map<String, Long> countedCars) {
        this.countedCars = countedCars;
    }
}
