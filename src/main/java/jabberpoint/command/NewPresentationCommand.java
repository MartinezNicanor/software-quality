package jabberpoint.command;

import jabberpoint.Presentation;

import java.awt.*;

public class NewPresentationCommand extends Command
{
    private Frame frame;

    public NewPresentationCommand(Presentation presentation, Frame frame)
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
