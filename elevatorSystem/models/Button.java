package models;

import enums.Direction;

public class Button {
    private Direction direction;
    private boolean isPressed;

    public Button(Direction direction) {
        this.direction = direction;
        this.isPressed = false;
    }

    // Handles the physical state and visual feedback
    public void press() {
        this.isPressed = true;
        System.out.println("   -> [" + direction + " Button]");
    }

    public void reset() {
        this.isPressed = false;
        System.out.println("   -> [" + direction + " Button]");
    }
}
