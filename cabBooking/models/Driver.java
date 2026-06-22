package cabBooking.models;

import cabBooking.enums.DriverStatus;

public class Driver {
    private String id;
    private String name;
    private Location currentLocation;
    private DriverStatus status;
    private Cab cab;

    public Driver(String id, String name, Location currentLocation, DriverStatus status, Cab cab) {

        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.status = status;
        this.cab = cab;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public Cab getCab() {
        return cab;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", status=" + status +
                ", cab=" + cab +
                '}';
    }
}