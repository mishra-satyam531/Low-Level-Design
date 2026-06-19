package strategies;

import java.util.List;

import enums.Direction;
import models.Elevator;

public interface DispatchStrategy {
    Elevator pickElevator(List<Elevator> fleet, int targetFloor, Direction direction);
}
