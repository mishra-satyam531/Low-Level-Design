package models;

import java.util.Collections;
import java.util.PriorityQueue;

import enums.Direction;
import enums.State;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private State state;

    // Min-Priority Queue for UP requests (Lowest floor first)
    private PriorityQueue<Integer> upQueue;

    // Max-Priority Queue for DOWN requests (Highest floor first)
    private PriorityQueue<Integer> downQueue;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0; // Assuming ground floor start
        this.direction = Direction.IDLE;
        this.state = State.STOPPED;

        // Default PriorityQueue in Java is Min-Heap
        this.upQueue = new PriorityQueue<>();

        // Pass Collections.reverseOrder() to create a Max-Heap
        this.downQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    // 'synchronized' prevents the race condition if two managers try to assign a
    // floor at the exact same millisecond.
    public synchronized void assignElevator(int targetFloor, Direction requestedDirection) {
        if (this.state == State.UNAVAILABLE) {
            System.out.println("Elevator " + id + " is out of service.");
            return;
        }

        if (requestedDirection == Direction.UP) {
            upQueue.offer(targetFloor);
        } else {
            downQueue.offer(targetFloor);
        }

        System.out.println("Assigned floor " + targetFloor + " to Elevator " + id);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return this.id;
    }
}
