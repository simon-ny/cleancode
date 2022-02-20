package clean.code.bobbycar.web.dto;

import java.util.List;

public class RentalOptions {
    private List<Driver> drivers;


    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
