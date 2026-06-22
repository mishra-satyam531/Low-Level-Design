package cabBooking;

import cabBooking.enums.CabType;
import cabBooking.enums.DriverStatus;
import cabBooking.models.Cab;
import cabBooking.models.Driver;
import cabBooking.models.Location;
import cabBooking.models.Ride;
import cabBooking.models.User;
import cabBooking.service.DriverService;
import cabBooking.service.RideService;
import cabBooking.strategy.DefaultFareStrategy;
import cabBooking.strategy.FareStrategy;
import cabBooking.strategy.NearestDriverStrategy;
import cabBooking.strategy.RideMatchingStrategy;

public class Main {

    public static void main(String[] args) {

        DriverService driverService =
                new DriverService();

        Driver driver1 =
                new Driver(
                        "D1",
                        "Rahul",
                        new Location(10, 20),
                        DriverStatus.AVAILABLE,
                        new Cab(
                                "DL01AB1234",
                                CabType.MINI));

        Driver driver2 =
                new Driver(
                        "D2",
                        "Amit",
                        new Location(15, 25),
                        DriverStatus.AVAILABLE,
                        new Cab(
                                "DL02XY5678",
                                CabType.SEDAN));

        driverService.addDriver(driver1);
        driverService.addDriver(driver2);

        User user =
                new User(
                        "U1",
                        "Satyam");

        RideMatchingStrategy matchingStrategy = new NearestDriverStrategy();

        FareStrategy fareStrategy = new DefaultFareStrategy();

        RideService rideService =
                new RideService(
                        driverService,
                        matchingStrategy,
                        fareStrategy);

        Ride ride =
                rideService.requestRide(
                        "R1",
                        user,
                        new Location(11, 21),
                        new Location(20, 30));

        System.out.println(
                "Driver Assigned : "
                        + ride.getDriver().getName());

        rideService.startRide(
                ride.getId());

        System.out.println(
                "Ride Status : "
                        + ride.getStatus());

        rideService.completeRide(
                ride.getId());

        Ride completedRide =
                rideService.getRide(
                        ride.getId());

        System.out.println(
                "Ride Status : "
                        + completedRide.getStatus());

        System.out.println(
                "Fare : "
                        + completedRide.getFare());
    }
}