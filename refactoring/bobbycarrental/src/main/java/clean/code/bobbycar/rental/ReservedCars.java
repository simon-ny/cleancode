package clean.code.bobbycar.rental;

public class ReservedCars {
    private String name;
    private int requestedUnits;
    private int availableUnits;

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
