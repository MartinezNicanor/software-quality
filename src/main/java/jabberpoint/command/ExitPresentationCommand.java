package jabberpoint.command;

import jabberpoint.Presentation;

// Command class to handle exiting presentation
public class ExitPresentationCommand extends Command
{
    // Constructor
    public ExitPresentationCommand(Presentation presentation)
    {
        // calls superclass constructor
        super(presentation);
    }

    // Method to execute command
    @Override
    public void execute()
    {
        // Calls exit method of presentation instance, with exit code 0
        this.presentation.exit(0);
    }
}
