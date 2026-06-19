package parkingLot.strategy;

import java.time.Duration;
import java.time.LocalDateTime;

import parkingLot.models.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        // Calculate hours spent in the lot
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        
        // Always charge for at least 1 hour
        long billableHours = Math.max(1, hours); 

        // Apply rate based on vehicle type
        switch (ticket.getVehicle().getType()) {
            case MOTORCYCLE: return billableHours * 1.0; // $1/hr
            case CAR: return billableHours * 2.0;        // $2/hr
            case TRUCK: return billableHours * 4.0;      // $4/hr
            default: return 0;
        }
    }
}
