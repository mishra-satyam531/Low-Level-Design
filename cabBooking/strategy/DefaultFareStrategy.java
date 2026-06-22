package cabBooking.strategy;

import cabBooking.enums.CabType;
import cabBooking.models.Ride;
import cabBooking.models.Location;

public class DefaultFareStrategy implements FareStrategy {

    @Override
    public double calculateFare(Ride ride) {

        Location source = ride.getSource();

        Location destination = ride.getDestination();

        double distance = calculateDistance(source, destination);

        CabType cabType = ride.getDriver().getCab().getCabType();

        double ratePerKm = getRate(cabType);

        return distance * ratePerKm;
    }

    private double calculateDistance(Location source, Location destination) {

        double latDiff = source.getLatitude() - destination.getLatitude();

        double longDiff = source.getLongitude() - destination.getLongitude();

        return Math.sqrt(latDiff * latDiff + longDiff * longDiff);
    }

    private double getRate(CabType cabType) {

        switch (cabType) {

            case MINI:
                return 10;

            case SEDAN:
                return 15;

            case SUV:
                return 20;

            default:
                throw new IllegalArgumentException(
                        "Unsupported cab type");
        }
    }
}