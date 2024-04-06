package jabberpoint.command.keyController;

import jabberpoint.Presentation;
import jabberpoint.command.Command;

public class ExitCommand extends Command
{
    public ExitCommand(Presentation presentation)
    {
        super(presentation);
    }

    @Override
    public void execute()
    {
        this.presentation.exit(0);
    }
}
