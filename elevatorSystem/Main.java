import managers.ElevatorManager;
import models.Elevator;
import models.Floor;
import models.InsidePanel;
import strategies.StandardStrategy;

public class Main {
    public static void main(String[] args) {
        ElevatorManager manager = new ElevatorManager(3, new StandardStrategy());
        Floor floor5 = new Floor(5, manager);

        // 1. THE CALL: Passenger on Floor 5 presses the physical UP button in the hallway
        floor5.pressUpButton(); 

        // System dispatches Elevator 1 (ID: 1). 
        // Fast-forwarding to when it arrives at Floor 5 and doors open...
        Elevator arrivedElevator = manager.getFleet().get(0); 

        // 2. THE DESTINATION: Passenger steps inside and uses that specific elevator's panel
        InsidePanel panel = new InsidePanel(arrivedElevator);
        panel.pressButton(10);
    }
}
