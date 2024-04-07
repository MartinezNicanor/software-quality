package jabberpoint.controllers.command;

import jabberpoint.Presentation;

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
