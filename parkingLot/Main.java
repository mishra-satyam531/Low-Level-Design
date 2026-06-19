package parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import parkingLot.enums.SpotSize;
import parkingLot.managers.EntranceGate;
import parkingLot.managers.ExitGate;
import parkingLot.models.Car;
import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.strategy.HourlyPricingStrategy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Initializing Parking Lot System...");

        // 1. Build the physical floor first
        ParkingFloor floor1 = new ParkingFloor(1);

        // 2. Add the spots, passing the 'floor1' reference into each spot's constructor
        floor1.addSpot(new ParkingSpot(101, SpotSize.SMALL, floor1));
        floor1.addSpot(new ParkingSpot(102, SpotSize.MEDIUM, floor1));
        floor1.addSpot(new ParkingSpot(103, SpotSize.LARGE, floor1));

        List<ParkingFloor> allFloors = new ArrayList<>();
        allFloors.add(floor1);

        // 3. Setup the Gates and Strategies
        EntranceGate entrance = new EntranceGate(allFloors);
        
        ExitGate exit = new ExitGate(new HourlyPricingStrategy());

        // 4. SIMULATION: A Car arrives
        Vehicle myCar = new Car("ABC-123");
        Ticket ticket = entrance.processEntry(myCar);

        // Simulate time passing
        System.out.println("Time passes...");
        Thread.sleep(2000); 

        // 5. SIMULATION: The Car leaves
        if (ticket != null) {
            exit.processExit(ticket);
        }

        System.out.println("..................................................................................");

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            final int carId = i; // Needed for the thread lambda
            
            executor.submit(() -> {
                Vehicle testCar = new Car("CAR-" + carId);
                
                ParkingSpot spot = floor1.parkVehicle(testCar);
                
                if (spot != null) {
                    System.out.println("Car " + carId + " parked at spot " + spot.getSpotId() + " by " + Thread.currentThread().getName());
                } else {
                    System.out.println("Car " + carId + " rejected. Lot Full.");
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        System.out.println("Test Complete.");
    }
}
