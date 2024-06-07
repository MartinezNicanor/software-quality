package jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedString;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TextItemTest
{
    TextItem textItem;
    TextItem emptyTextItem;
    Graphics graphics;
    ImageObserver imageObserver;
    Style style;

    @BeforeEach
    void setUp()
    {
        graphics = Mockito.mock(Graphics2D.class);
        imageObserver = Mockito.mock(ImageObserver.class);
        textItem = new TextItem(1, "Test Text");
        emptyTextItem = new TextItem();
        style = new Style(1, Color.BLACK, 10, 20);
    }

    @Test
    void getText_ReturnsCorrectText()
    {
        assertEquals("Test Text", textItem.getText());
        assertNull(emptyTextItem.getText());
    }

    @Test
    void getLevel_ReturnsCorrectLevel()
    {
        assertEquals(1, textItem.getLevel());
        assertEquals(0, emptyTextItem.getLevel()); // Default level should be 0
    }

    @Test
    void getAttributedString_ReturnsNonNullAttributedString()
    {
        float scale = 1.0f;
        AttributedString attrStr = textItem.getAttributedString(style, scale);
        assertNotNull(attrStr);
    }

    @Test
    void drawWithEmptyText_GraphicsNotCalledWhenTextIsEmpty()
    {
        float scale = 1.0f;
        emptyTextItem.draw(10, 10, scale, graphics, style, imageObserver);

        // Graphics should not be called when there's no text
        verify(graphics, never()).setColor(any(Color.class));
        verify(graphics, never()).drawString(anyString(), anyInt(), anyInt());
    }

    @Test
    void toString_ReturnsExpectedStringRepresentation()
    {
        assertEquals("TextItem[1,Test Text]", textItem.toString());
        assertEquals("TextItem[0,null]", emptyTextItem.toString());
    }
}
