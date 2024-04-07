package jabberpoint;

import jabberpoint.command.Command;
import jabberpoint.command.ExitPresentationCommand;
import jabberpoint.command.NextSlideCommand;
import jabberpoint.command.PreviousSlideCommand;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/**
 * <p>This is the KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter
{
    private Presentation presentation; // Commands are given to the presentation

    // Constructor
    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
    }

    // Method to handle key presses
    public void keyPressed(KeyEvent keyEvent)
    {
        Command command;

        // Switch statement to determine action based on key pressed
        switch (keyEvent.getKeyCode())
        {
            // Next slide actions
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                command = new NextSlideCommand(this.presentation);
                command.execute();
                break;

            // Previous slide actions
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                command = new PreviousSlideCommand(this.presentation);
                command.execute();
                break;

            // Exit presentation action
            case 'q':
            case 'Q':
                command = new ExitPresentationCommand(this.presentation);
                command.execute();
                break; // Probably never reached!!

            // No action for other keys
            default:
                break;
        }
    }
}