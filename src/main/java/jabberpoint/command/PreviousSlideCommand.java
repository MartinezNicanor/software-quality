package jabberpoint.command;

import jabberpoint.Presentation;
import jabberpoint.command.Command;

public class PreviousSlideCommand extends Command
{
    public PreviousSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.presentation.prevSlide();
    }
}
