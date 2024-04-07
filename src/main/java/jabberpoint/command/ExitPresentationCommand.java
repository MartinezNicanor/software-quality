package jabberpoint.command;

import jabberpoint.Presentation;

public class ExitPresentationCommand extends Command {
    public ExitPresentationCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        this.presentation.exit(0);
    }
}
