package jabberpoint.command;

import jabberpoint.Presentation;

// Abstract Command class to define structure of commands
public abstract class Command {
    // Reference to presentation instance
    public Presentation presentation;

    // Constructor
    public Command(Presentation presentation) {
        this.presentation = presentation;
    }

    // Abstract method to be implemented by subclasses
    public abstract void execute();
}