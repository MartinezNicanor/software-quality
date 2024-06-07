package jabberpoint.accessor;

import jabberpoint.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoPresentationTest
{
    private Presentation presentation;
    private DemoPresentation demoPresentation;

    @BeforeEach
    void setup()
    {
        presentation = new Presentation();
        demoPresentation = new DemoPresentation();
    }

    @Test
    void testLoadFile_EmptyFileName_NoIOExceptionThrown()
    {
        assertDoesNotThrow(() ->
        {
            demoPresentation.loadFile(presentation, "");
            assertEquals(3, presentation.getSize());
        });
    }

    @Test
    void testSaveFile_EmptyFileName_ThrowsIllegalStateException()
    {
        assertThrows(IllegalStateException.class, () ->
        {
            demoPresentation.saveFile(presentation, "");
        });
    }
}