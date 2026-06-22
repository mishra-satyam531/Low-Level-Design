package cabBooking.strategy;

import java.util.List;

import cabBooking.models.Driver;
import cabBooking.models.Location;

public interface RideMatchingStrategy {
     Driver findDriver(
            Location source,
            List<Driver> drivers);
}