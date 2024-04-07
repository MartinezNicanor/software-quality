package jabberpoint.controllers.command;

import jabberpoint.controllers.AboutBox;
import jabberpoint.Presentation;

import java.awt.*;

// Command class to handle displaying About Box
public class AboutBoxCommand extends Command
{
    // Reference to frame where About Box will be displayed
    private Frame frame;

    // Constructor
    public AboutBoxCommand(Presentation presentation, Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    // Executes About Box command
    @Override
    public void execute()
    {
        // Shows About Box using static method from AboutBox class
        AboutBox.show(frame);
    }
}
