package jabberpoint.controllers;

import jabberpoint.Presentation;
import jabberpoint.controllers.command.Command;
import jabberpoint.controllers.command.ExitPresentationCommand;
import jabberpoint.controllers.command.NextSlideCommand;
import jabberpoint.controllers.command.PreviousSlideCommand;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>This is the KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter
{
    private Presentation presentation; // Commands are given to the presentation

    private final Map<Integer, Command> commandMap;

    public KeyController(Presentation presentation)
    {
        this.presentation = presentation;
        this.commandMap = new HashMap<>();
        commandMap.put(KeyEvent.VK_PAGE_DOWN, new NextSlideCommand(presentation));
        commandMap.put(KeyEvent.VK_DOWN, new NextSlideCommand(presentation));
        commandMap.put(KeyEvent.VK_ENTER, new NextSlideCommand(presentation));
        commandMap.put((int) '+', new NextSlideCommand(presentation));
        commandMap.put(KeyEvent.VK_PAGE_UP, new PreviousSlideCommand(presentation));
        commandMap.put(KeyEvent.VK_UP, new PreviousSlideCommand(presentation));
        commandMap.put((int) '-', new PreviousSlideCommand(presentation));
        commandMap.put((int) 'q', new ExitPresentationCommand(presentation));
        commandMap.put((int) 'Q', new ExitPresentationCommand(presentation));
    }

    public void keyPressed(KeyEvent keyEvent)
    {
        Command command = commandMap.get(keyEvent.getKeyCode());

        if (command != null)
        {
            command.execute();
        }
    }
}
