package jabberpoint.controllers.command;

import jabberpoint.Presentation;

import java.awt.*;

// Command class to handle creating a new presentation
public class NewPresentationCommand extends Command
{
    // Reference to frame associated with presentation
    private final Frame frame;

    // Constructor
    public NewPresentationCommand(Presentation presentation, Frame frame)
    {
        // Call superclass constructor to initialize presentation reference
        super(presentation);
        // Initialize frame reference
        this.frame = frame;
    }

    // Method to execute command
    @Override
    public void execute()
    {
        // Clear presentation
        this.presentation.clear();
        // Repaint frame to reflect changes
        this.frame.repaint();
    }
}