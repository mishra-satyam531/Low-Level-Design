package parkingLot.managers;

import java.util.List;

import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;

public class EntranceGate {
    private List<ParkingFloor> floors;

    public EntranceGate(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Ticket processEntry(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.parkVehicle(vehicle);
            if (spot != null) {
                System.out.println(vehicle.getType() + " parked on Floor " + floor.getFloorNumber() + ", Spot " + spot.getSpotId());
                return new Ticket(vehicle, spot);
            }
        }
        System.out.println("Lot Full. No spots available for " + vehicle.getType());
        return null;
    }
}
