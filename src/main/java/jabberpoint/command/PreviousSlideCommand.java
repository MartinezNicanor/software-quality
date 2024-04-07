package jabberpoint.command;

import jabberpoint.Presentation;

// Command class to handle moving to previous slide
public class PreviousSlideCommand extends Command
{
    // Constructor
    public PreviousSlideCommand(Presentation presentation)
    {
        // Calls superclass constructor to initialize presentation reference
        super(presentation);
    }

    // Executes command
    @Override
    public void execute()
    {
        // Call prevSlide method of presentation instance to move to previous slide
        this.presentation.prevSlide();
    }
}
