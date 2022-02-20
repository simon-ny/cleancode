package clean.code.dependency.reservation;

public class ReservedCar {
    private String name;
    private int requestedUnits;
    private int availableUnits;

    public ReservedCar(String name, int requestedUnits, int availableUnits) {
        this.name = name;
        this.requestedUnits = requestedUnits;
        this.availableUnits = availableUnits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequestedUnits() {
        return requestedUnits;
    }

    public void setRequestedUnits(int requestedUnits) {
        this.requestedUnits = requestedUnits;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }
}
