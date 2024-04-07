package jabberpoint.controllers.command;

import jabberpoint.Presentation;

import javax.swing.*;

public class GoToSlideCommand extends Command
{
    public GoToSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        String pageNumberStr = JOptionPane.showInputDialog((Object) "Page number?");
        int pageNumber = Integer.parseInt(pageNumberStr);
        presentation.setSlideNumber(pageNumber - 1);
    }
}
