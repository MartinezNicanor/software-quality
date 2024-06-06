package jabberpoint.controllers.command;

import jabberpoint.Presentation;
import jabberpoint.controllers.AboutBox;

import java.awt.*;

public class AboutBoxCommand extends Command
{
    private Frame frame;

    public AboutBoxCommand(Presentation presentation, Frame frame)
    {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute()
    {
        AboutBox.show(frame);
    }
}
