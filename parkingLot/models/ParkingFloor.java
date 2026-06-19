package parkingLot.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import parkingLot.enums.SpotSize;

public class ParkingFloor {
    private int floorNumber;
    private Map<SpotSize, Set<ParkingSpot>> availableSpots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.availableSpots = new HashMap<>();
        this.availableSpots.put(SpotSize.SMALL, new HashSet<>());
        this.availableSpots.put(SpotSize.MEDIUM, new HashSet<>());
        this.availableSpots.put(SpotSize.LARGE, new HashSet<>());
    }

    // Helper to add spots when the lot is built
    public void addSpot(ParkingSpot spot) {
        availableSpots.get(spot.getSize()).add(spot);
    }

    // The core allocation logic
    public synchronized ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = null;

        switch (vehicle.getType()) {
            case MOTORCYCLE:
                spot = findAndRemoveSpot(SpotSize.SMALL);
                if (spot == null) spot = findAndRemoveSpot(SpotSize.MEDIUM);
                if (spot == null) spot = findAndRemoveSpot(SpotSize.LARGE);
                break;
            case CAR:
                spot = findAndRemoveSpot(SpotSize.MEDIUM);
                if (spot == null) spot = findAndRemoveSpot(SpotSize.LARGE); 
                break;
            case TRUCK:
                spot = findAndRemoveSpot(SpotSize.LARGE);
                break;
        }

        if (spot != null) {
            spot.park(vehicle);
        }
        return spot;
    }

    // Helper method to grab a spot from the specific bin and remove it from 'available'
    private ParkingSpot findAndRemoveSpot(SpotSize size) {
        Set<ParkingSpot> spots = availableSpots.get(size);
        if (!spots.isEmpty()) {
            ParkingSpot spot = spots.iterator().next(); // Grab the first one
            spots.remove(spot); // It's no longer available
            return spot;
        }
        return null;
    }
    
    // Method to free a spot when a vehicle leaves
    public void freeSpot(ParkingSpot spot) {
        spot.removeVehicle();
        availableSpots.get(spot.getSize()).add(spot);
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
