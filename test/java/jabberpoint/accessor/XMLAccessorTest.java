package jabberpoint.accessor;

import jabberpoint.Presentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class XMLAccessorTest
{
    private Presentation presentation;
    private XMLAccessor xmlAccessor;

    @BeforeEach
    void setup()
    {
        this.presentation = new Presentation();
        this.xmlAccessor = new XMLAccessor();
    }

    @Test
    void testLoadFile_validFileName_DoesNotThrowException()
    {
        assertDoesNotThrow(() ->
        {
            xmlAccessor.loadFile(presentation, "test.xml");
            assertEquals(5, presentation.getSize());
        });
    }

    @Test
    void testSaveFile_LoadedFileAndSavedFileHaveTheSameSize() throws IOException
    {
        xmlAccessor.loadFile(presentation, "test.xml");
        xmlAccessor.saveFile(presentation, "dump.xml");

        Presentation presentation2 = new Presentation();
        XMLAccessor xmlAccessor2 = new XMLAccessor();
        xmlAccessor2.loadFile(presentation2, "dump.xml");
        assertEquals(presentation.getSize(), presentation2.getSize());
    }
}