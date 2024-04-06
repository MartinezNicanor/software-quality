package jabberpoint.command.menuController;

import jabberpoint.Presentation;
import jabberpoint.command.Command;
import jabberpoint.command.keyController.ExitCommand;
import jabberpoint.command.keyController.NextSlideCommand;
import jabberpoint.command.keyController.PreviousSlideCommand;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private Frame frame; // the frame, only used as parent for the Dialogs
	private Presentation presentation; // Commands are given to the presentation
	private MenuItem menuItem;
	private Menu fileMenu = new Menu("File");
	private Menu viewMenu = new Menu("View");
	private Menu helpMenu = new Menu("Help");

	public MenuController(Frame frame, Presentation presentation) {
		this.frame = frame;
		this.presentation = presentation;

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

	public void openPresentation() {
		fileMenu.add(this.menuItem = mkMenuItem("Open"));
		this.menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command command = new OpenCommand(presentation, frame);
				command.execute();
			}
		});
	}

	public void newPresentation() {
		fileMenu.add(this.menuItem = mkMenuItem("New"));
		this.menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Command command = new NewCommand(presentation, frame);
				command.execute();
			}
		});
	}

	public void savePresentation() {
		fileMenu.add(this.menuItem = mkMenuItem("Save"));
		this.menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Command command = new SaveCommand(presentation, frame);
				command.execute();
			}
		});
	}

	public void exitPresentation() {
		fileMenu.add(this.menuItem = mkMenuItem("Exit"));
		this.menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Command command = new ExitCommand(presentation);
				command.execute();
			}
		});
	}

	public void nextSlide() {
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

	public void previousSlide() {
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

	public void goToSlide() {
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

	public void openAboutBox() {
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
	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name, new MenuShortcut(name.charAt(0)));
	}
}
