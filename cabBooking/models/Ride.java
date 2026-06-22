package cabBooking.models;

import cabBooking.enums.RideStatus;

public class Ride {
    private String id;

    private User user;

    private Driver driver;

    private Location source;

    private Location destination;

    private RideStatus status;

    private double fare;

    public Ride(String id,
                User user,
                Location source,
                Location destination) {

        this.id = id;
        this.user = user;
        this.source = source;
        this.destination = destination;

        this.status = RideStatus.REQUESTED;
        this.fare = 0.0;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", driver=" + driver +
                ", source=" + source +
                ", destination=" + destination +
                ", status=" + status +
                ", fare=" + fare +
                '}';
    }
}