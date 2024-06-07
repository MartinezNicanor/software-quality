package jabberpoint.controllers.command;

import jabberpoint.Presentation;
import jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class OpenPresentationCommandTest
{
    Presentation presentation;
    Frame frame;
    Command openPresentationCommand;

    @BeforeEach
    void setup()
    {
        presentation = new Presentation();
        frame = new Frame();
        openPresentationCommand = new OpenPresentationCommand(presentation, frame);
    }

    @Test
    void openPresentation_ChangePresentationSize_AssertEqualsTrue()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());

        assertEquals(2, presentation.getSize());

        openPresentationCommand.execute();
        assertEquals(5, presentation.getSize());
    }

    @Test
    void openPresentation_SetSlideNumberTo0_AssertEqualsTrue()
    {
        presentation.setSlideNumber(5);

        openPresentationCommand.execute();
        assertEquals(0, presentation.getSlideNumber());
    }
}