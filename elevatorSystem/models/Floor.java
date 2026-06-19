package models;

import enums.Direction;
import managers.ElevatorManager;

public class Floor {
    private int floorNumber;
    private Button upButton;
    private Button downButton;

    private ElevatorManager manager;

    public Floor(int floorNumber, ElevatorManager manager) {
        this.floorNumber = floorNumber;
        this.manager = manager;
        this.upButton = new Button(Direction.UP);
        this.downButton = new Button(Direction.DOWN);
    }

    // A passenger physically presses the UP button
    public void pressUpButton() {
        System.out.println("\n[EVENT] Passenger on Floor " + floorNumber + " presses UP.");
        upButton.press();
        manager.requestElevator(floorNumber, Direction.UP);
    }

    // A passenger physically presses the DOWN button
    public void pressDownButton() {
        System.out.println("\n[EVENT] Passenger on Floor " + floorNumber + " presses DOWN.");
        downButton.press();
        manager.requestElevator(floorNumber, Direction.DOWN);
    }
}
