package jabberpoint.controllers.command;

import jabberpoint.Presentation;

public abstract class Command
{
    public Presentation presentation;

    public Command(Presentation presentation)
    {
        this.presentation = presentation;
    }

    public abstract void execute();
}
