package cabBooking.strategy;

import cabBooking.models.Ride;

public interface FareStrategy {

    double calculateFare(Ride ride);
}