package jabberpoint.controllers.command;

import jabberpoint.Presentation;
import jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NextSlideCommandTest
{
    Presentation presentation;
    Command nextSlideCommand;

    @BeforeEach
    void setup()
    {
        presentation = new Presentation();
        nextSlideCommand = new NextSlideCommand(presentation);
    }

    @Test
    void nextSlideCommand_increaseSlideNumberTwice_SlideNumberEquals1()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());

        nextSlideCommand.execute();
        nextSlideCommand.execute();

        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void nextSlideCommand_oneSlide_PageNumberStaysAt0()
    {
        presentation.append(new Slide());

        nextSlideCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void nextSlideCommand_lastSlide_PageNumberStaysAtLastSlide()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());

        nextSlideCommand.execute();
        nextSlideCommand.execute();
        nextSlideCommand.execute();

        assertEquals(2, presentation.getSlideNumber());

        nextSlideCommand.execute();

        assertEquals(2, presentation.getSlideNumber());
    }
}