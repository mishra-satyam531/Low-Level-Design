package cabBooking.service;

import java.util.ArrayList;
import java.util.List;

import cabBooking.enums.DriverStatus;
import cabBooking.models.Driver;

public class DriverService {
    private List<Driver> drivers;

    public DriverService() {
        this.drivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }

    public void updateDriverStatus(Driver driver, DriverStatus status) {
        driver.setStatus(status);
    }

}