package jabberpoint.command.keyController;

import jabberpoint.Presentation;
import jabberpoint.command.Command;

public class NextSlideCommand extends Command
{
    public NextSlideCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.presentation.nextSlide();
    }
}
