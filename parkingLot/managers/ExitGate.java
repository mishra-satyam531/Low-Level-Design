package parkingLot.managers;

import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Ticket;
import parkingLot.strategy.PricingStrategy;

public class ExitGate {
    private PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    public void processExit(Ticket ticket) {
        double fee = pricingStrategy.calculateFee(ticket);
        System.out.println("Processing fee: $" + fee);

        ParkingSpot assignedSpot = ticket.getParkingSpot();
        ParkingFloor correctFloor = assignedSpot.getFloor();
        
        correctFloor.freeSpot(assignedSpot);
        
        System.out.println("Vehicle left. Spot " + assignedSpot.getSpotId() + " on Floor " + correctFloor.getFloorNumber() + " is now free.");
    }
}
