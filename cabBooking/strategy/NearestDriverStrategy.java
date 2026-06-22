package cabBooking.strategy;

import java.util.List;

import cabBooking.enums.DriverStatus;
import cabBooking.models.Driver;
import cabBooking.models.Location;

public class NearestDriverStrategy implements RideMatchingStrategy {

    @Override
    public Driver findDriver(Location source, List<Driver> drivers) {

        Driver nearestDriver = null;

        double minDistance = Double.MAX_VALUE;

        for (Driver driver : drivers) {

            if (driver.getStatus()
                    != DriverStatus.AVAILABLE) {
                continue;
            }

            double distance = calculateDistance( source, driver.getCurrentLocation());

            if (distance < minDistance) {

                minDistance = distance;
                nearestDriver = driver;
            }
        }

        return nearestDriver;
    }

    private double calculateDistance(Location loc1, Location loc2) {

        double latDiff = loc1.getLatitude() - loc2.getLatitude();

        double longDiff = loc1.getLongitude()  - loc2.getLongitude();

        return Math.sqrt(latDiff * latDiff + longDiff * longDiff);
    }
}