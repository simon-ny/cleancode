package clean.code.dependency.reservation;

import java.util.Map;

public class ReservationRequest {
    Map<String, Integer> countedCars;

    public ReservationRequest() {
    }

    public ReservationRequest(Map<String, Integer> countedCars) {
        this.countedCars = countedCars;
    }

    public Map<String, Integer> getCountedCars() {
        return countedCars;
    }

    public void setCountedCars(Map<String, Integer> countedCars) {
        this.countedCars = countedCars;
    }
}
