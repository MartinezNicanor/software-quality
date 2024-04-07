package jabberpoint;

import jabberpoint.command.*;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar
{

    private Frame frame;
    private Presentation presentation;
    private MenuItem menuItem;
    private Menu fileMenu = new Menu("File");
    private Menu viewMenu = new Menu("View");
    private Menu helpMenu = new Menu("Help");

    // Constructor
    public MenuController(Frame frame, Presentation presentation)
    {
        this.frame = frame;
        this.presentation = presentation;

        // Initialize menu items
        openPresentation();
        newPresentation();
        savePresentation();
        fileMenu.addSeparator();
        exitPresentation();
        add(fileMenu);
        nextSlide();
        previousSlide();
        goToSlide();
        add(viewMenu);
        openAboutBox();
        setHelpMenu(helpMenu); // needed for portability (Motif, etc.).
    }

    // Method to create and add "Open" menu item
    public void openPresentation()
    {
        fileMenu.add(this.menuItem = mkMenuItem("Open"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new OpenPresentationCommand(presentation, frame);
                command.execute();
            }
        });
    }

    // Method to create and add "New" menu item
    public void newPresentation()
    {
        fileMenu.add(this.menuItem = mkMenuItem("New"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new NewPresentationCommand(presentation, frame);
                command.execute();
            }
        });
    }

    // Method to create and add "Save" menu item
    public void savePresentation()
    {
        fileMenu.add(this.menuItem = mkMenuItem("Save"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new SavePresentationCommand(presentation, frame);
                command.execute();
            }
        });
    }

    // Method to create and add "Exit" menu item
    public void exitPresentation()
    {
        fileMenu.add(this.menuItem = mkMenuItem("Exit"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new ExitPresentationCommand(presentation);
                command.execute();
            }
        });
    }

    // Method to create and add "Next" menu item
    public void nextSlide()
    {
        viewMenu.add(this.menuItem = mkMenuItem("Next"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new NextSlideCommand(presentation);
                command.execute();
            }
        });
    }

    // Method to create and add "Previous" menu item
    public void previousSlide()
    {
        viewMenu.add(this.menuItem = mkMenuItem("Prev"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new PreviousSlideCommand(presentation);
                command.execute();
            }
        });
    }

    // Method to create and add "Go To" menu item
    public void goToSlide()
    {
        viewMenu.add(this.menuItem = mkMenuItem("Go To"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new GoToSlideCommand(presentation);
                command.execute();
            }
        });
    }

    // Method to create and add "About" menu item
    public void openAboutBox()
    {
        helpMenu.add(this.menuItem = mkMenuItem("About"));
        this.menuItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Command command = new AboutBoxCommand(presentation, frame);
                command.execute();
            }
        });
    }

    // create a menu item
    public MenuItem mkMenuItem(String name)
    {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}