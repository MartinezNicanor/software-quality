package jabberpoint.controllers.command;

import jabberpoint.Presentation;
import jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class NewPresentationCommandTest
{
    Presentation presentation;
    Frame frame;
    Command newPresentationCommand;

    @BeforeEach
    void setup() {
        presentation = new Presentation();
        frame = new Frame();
        newPresentationCommand = new NewPresentationCommand(presentation, frame);
    }

    @Test
    void exitPresentation_presentationSizeFrom2To0_SizeEquals0() {
        presentation.append(new Slide());
        presentation.append(new Slide());

        assertEquals(2, presentation.getSize());
        newPresentationCommand.execute();

        assertEquals(0, presentation.getSize());
    }

    @Test
    void exitPresentation_emptyPresentation_SizeEquals0() {
        newPresentationCommand.execute();

        assertEquals(0, presentation.getSize());
    }
}