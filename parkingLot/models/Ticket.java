package parkingLot.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString(); // Generates a unique string
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now(); // Stamps the exact moment of entry
    }

    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getParkingSpot() { return parkingSpot; }
    public LocalDateTime getEntryTime() { return entryTime; }
}
