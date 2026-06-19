package managers;

import java.util.ArrayList;
import java.util.List;

import enums.Direction;
import models.Elevator;
import strategies.DispatchStrategy;

public class ElevatorManager {
    private List<Elevator> fleet;
    private DispatchStrategy currentStrategy;

    public ElevatorManager(int numberOfElevators, DispatchStrategy initialStrategy) {
        this.fleet = new ArrayList<>();
        for (int i = 1; i <= numberOfElevators; i++) {
            fleet.add(new Elevator(i));
        }
        this.currentStrategy = initialStrategy;
    }

    // Allows the SystemScheduler to change strategies on the fly
    public void setStrategy(DispatchStrategy newStrategy) {
        this.currentStrategy = newStrategy;
    }

    // Triggered when an outside floor button is pressed
    public void requestElevator(int targetFloor, Direction direction) {
        Elevator bestElevator = currentStrategy.pickElevator(fleet, targetFloor, direction);
        
        if (bestElevator != null) {
            bestElevator.assignElevator(targetFloor, direction);
        } else {
            System.out.println("All elevators are currently out of service.");
        }
    }
    
    public List<Elevator> getFleet() { return fleet; }
}
