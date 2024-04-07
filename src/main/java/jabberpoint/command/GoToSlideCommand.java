package jabberpoint.command;

import jabberpoint.Presentation;
import javax.swing.*;

// Command class to handle going to a specific slide
public class GoToSlideCommand extends Command {
    // Constructor
    public GoToSlideCommand(Presentation presentation) {
        // Calls superclass constructor to initialize presentation reference
        super(presentation);
    }

    // Executes the command
    @Override
    public void execute() {
        // Show a dialog to get slide number from the user
        String pageNumberStr = JOptionPane.showInputDialog((Object) "Page number?");

        // Convert input string to an integer representing slide number
        int pageNumber = Integer.parseInt(pageNumberStr);

        // Set slide number in presentation (subtracting 1)
        presentation.setSlideNumber(pageNumber - 1);
    }
}