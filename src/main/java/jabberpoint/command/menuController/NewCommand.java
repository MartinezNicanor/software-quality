package jabberpoint.command.menuController;

import jabberpoint.Presentation;
import jabberpoint.command.Command;

import java.awt.*;

public class NewCommand extends Command
{
    private Frame frame;

    public NewCommand(Presentation presentation, Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute()
    {
        this.presentation.clear();
        this.frame.repaint();
    }
}
