package strategies;

import java.util.List;

import enums.Direction;
import enums.State;
import models.Elevator;

public class StandardStrategy implements DispatchStrategy {

    @Override
    public Elevator pickElevator(List<Elevator> fleet, int targetFloor, Direction direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : fleet) {
            // 1. Ignore broken elevators
            if (elevator.getState() == State.UNAVAILABLE) {
                continue;
            }

            int distance = Math.abs(elevator.getCurrentFloor() - targetFloor);

            // 2. Check if the elevator is moving towards the passenger or is simply idle
            boolean isMovingTowards = (elevator.getDirection() == Direction.UP
                    && elevator.getCurrentFloor() <= targetFloor) ||
                    (elevator.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= targetFloor);

            boolean isIdle = elevator.getDirection() == Direction.IDLE;

            // 3. Find the closest eligible car
            if (isMovingTowards || isIdle) {
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        // Fallback: If all active elevators are moving the wrong way,
        // a real system would queue the request globally. For this scope, we return the
        // first available.
        if (bestElevator == null) {
            for (Elevator elevator : fleet) {
                if (elevator.getState() != State.UNAVAILABLE) {
                    return elevator;
                }
            }
        }

        return bestElevator;
    }
}
