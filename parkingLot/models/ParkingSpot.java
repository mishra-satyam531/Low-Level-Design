package parkingLot.models;

import parkingLot.enums.SpotSize;

public class ParkingSpot {
    private int spotId;
    private SpotSize size;
    private boolean isAvailable;
    private ParkingFloor floor;
    private Vehicle currentVehicle;
    public ParkingSpot(int spotId, SpotSize size, ParkingFloor floor) {
        this.spotId = spotId;
        this.size = size;
        this.floor = floor;
        this.isAvailable = true;
    }

    // Actions
    public void park(Vehicle v) {
        this.currentVehicle = v;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.currentVehicle = null;
        this.isAvailable = true;
    }

    public boolean isAvailable() { return isAvailable; }
    public SpotSize getSize() { return size; }
    public ParkingFloor getFloor() { return floor; }
    public int getSpotId() { return spotId; }
}
