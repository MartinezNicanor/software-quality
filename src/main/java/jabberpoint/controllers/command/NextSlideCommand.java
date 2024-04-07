package jabberpoint.controllers.command;

import jabberpoint.Presentation;

// Command class to handle moving to next slide
public class NextSlideCommand extends Command
{
    // Constructor
    public NextSlideCommand(Presentation presentation)
    {
        // Call superclass constructor to initialize presentation
        super(presentation);
    }

    // Method to execute command
    @Override
    public void execute()
    {
        // Call nextSlide method of presentation
        this.presentation.nextSlide();
    }
}
