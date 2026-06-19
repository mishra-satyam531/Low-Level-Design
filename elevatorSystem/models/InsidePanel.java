package models;

import enums.Direction;

public class InsidePanel {
    private Elevator elevator;

    public InsidePanel(Elevator elevator) {
        this.elevator = elevator;
    }

    // The passenger presses a specific floor number
    public void pressButton(int targetFloor) {
        System.out.println("\n[EVENT] Passenger inside Elevator " + elevator.getId() + " presses Floor " + targetFloor);

        // The panel calculates the direction based on where the elevator currently is
        Direction dir = (targetFloor > elevator.getCurrentFloor()) ? Direction.UP : Direction.DOWN;

        // Sends the request directly to the elevator's internal queue
        elevator.assignElevator(targetFloor, dir);
    }
}
