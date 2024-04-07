package jabberpoint.controllers;

import jabberpoint.Presentation;
import jabberpoint.controllers.command.Command;
import jabberpoint.controllers.command.ExitPresentationCommand;
import jabberpoint.controllers.command.NextSlideCommand;
import jabberpoint.controllers.command.PreviousSlideCommand;

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

    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        Command command;
        switch (keyEvent.getKeyCode())
        {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                command = new NextSlideCommand(this.presentation);
                command.execute();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                command = new PreviousSlideCommand(this.presentation);
                command.execute();
                break;
            case 'q':
            case 'Q':
                command = new ExitPresentationCommand(this.presentation);
                command.execute();
                break; // Probably never reached!!
            default:
                break;
        }
    }
}
