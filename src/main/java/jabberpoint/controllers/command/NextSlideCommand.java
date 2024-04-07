package jabberpoint.controllers.command;

import jabberpoint.Presentation;

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
