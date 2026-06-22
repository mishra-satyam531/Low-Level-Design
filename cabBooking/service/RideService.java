package cabBooking.service;

import java.util.HashMap;
import java.util.Map;

import cabBooking.enums.DriverStatus;
import cabBooking.enums.RideStatus;
import cabBooking.models.Driver;
import cabBooking.models.Location;
import cabBooking.models.Ride;
import cabBooking.models.User;
import cabBooking.strategy.FareStrategy;
import cabBooking.strategy.RideMatchingStrategy;

public class RideService {

    private Map<String, Ride> rides;

    private DriverService driverService;

    private RideMatchingStrategy rideMatchingStrategy;

    private FareStrategy fareStrategy;

    public RideService(
            DriverService driverService,
            RideMatchingStrategy rideMatchingStrategy,
            FareStrategy fareStrategy) {

        this.driverService = driverService;
        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareStrategy = fareStrategy;

        this.rides = new HashMap<>();
    }

    public Ride requestRide(
            String rideId,
            User user,
            Location source,
            Location destination) {

        Driver driver =
                rideMatchingStrategy.findDriver(
                        source,
                        driverService.getAllDrivers());

        if(driver == null) {
            throw new RuntimeException(
                    "No driver available");
        }

        Ride ride =
                new Ride(
                        rideId,
                        user,
                        source,
                        destination);

        ride.setDriver(driver);
        ride.setStatus(RideStatus.ASSIGNED);

        driver.setStatus(
                DriverStatus.ON_RIDE);

        rides.put(
                ride.getId(),
                ride);

        return ride;
    }

    public void startRide(String rideId) {

        Ride ride = rides.get(rideId);

        if(ride == null) {
            throw new RuntimeException(
                    "Ride not found");
        }

        ride.setStatus(RideStatus.STARTED);
    }

    public void completeRide(String rideId) {

        Ride ride = rides.get(rideId);

        if(ride == null) {
            throw new RuntimeException(
                    "Ride not found");
        }

        double fare =
        fareStrategy.calculateFare(ride);

        fare = Math.round(fare * 100.0) / 100.0;

        ride.setFare(fare);

        ride.setStatus(RideStatus.COMPLETED);

        ride.getDriver()
                .setStatus(
                        DriverStatus.AVAILABLE);
    }

    public Ride getRide(String rideId) {

        return rides.get(rideId);
    }
}