package parkingLot.strategy;

import parkingLot.models.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}
