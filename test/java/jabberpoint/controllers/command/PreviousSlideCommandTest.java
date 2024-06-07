package jabberpoint.controllers.command;

import jabberpoint.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PreviousSlideCommandTest
{
    Presentation presentation;
    Command previousSlideCommand;

    @BeforeEach
    void setup()
    {
        presentation = new Presentation();
        previousSlideCommand = new PreviousSlideCommand(presentation);
    }

    @Test
    void PreviousSlideCommand_decreaseSlideNumberTwice_AssertEqualsTrue()
    {
        presentation.setSlideNumber(2);

        previousSlideCommand.execute();
        previousSlideCommand.execute();

        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void PreviousSlideCommand_oneSlidePageNumberStaysAt0_AssertEqualsTrue()
    {
        presentation.setSlideNumber(0);

        previousSlideCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void PreviousSlideCommand_emptyPresentationStaysAtMinus1_AssertEqualsTrue()
    {
        presentation.clear();

        previousSlideCommand.execute();

        assertEquals(-1, presentation.getSlideNumber());
    }
}