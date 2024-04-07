package jabberpoint.decorator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import jabberpoint.*;
import org.junit.Test;

public class SlideDecoratorTest {

    // Mock Slide class for testing
    private static class MockSlide extends Slide
    {
        @Override
        public void draw(Graphics g, Rectangle area, ImageObserver view) {
        }
    }

    // Test for FontSizeDecorator
    @Test
    public void testFontSizeDecorator() {
        Slide slide = new MockSlide();
        FontSizeDecorator fontSizeDecorator = new FontSizeDecorator(slide, FontSizeDecorator.MEDIUM);

        assertNotNull(fontSizeDecorator); // Check if FontSizeDecorator instance is not null
        assertEquals(FontSizeDecorator.MEDIUM, fontSizeDecorator.getFontSize()); // Check if font size is set correctly
    }

    // Test for BorderDecorator
    @Test
    public void testBorderDecorator() {
        Slide slide = new MockSlide();
        BorderDecorator borderDecorator = new BorderDecorator(slide, BorderDecorator.BLACK);

        assertNotNull(borderDecorator); // Check if BorderDecorator instance is not null
        assertEquals(BorderDecorator.BLACK, borderDecorator.getColor()); // Check if border color is set correctly
    }

    // Test for FontColorDecorator
    @Test
    public void testFontColorDecorator() {
        Slide slide = new MockSlide();
        FontColorDecorator fontColorDecorator = new FontColorDecorator(slide, FontColorDecorator.RED);

        assertNotNull(fontColorDecorator); // Check if FontColorDecorator instance is not null
        assertEquals(FontColorDecorator.RED, fontColorDecorator.getColor()); // Check if font color is set correctly
    }

    // Test for BackgroundColorDecorator
    @Test
    public void testBackgroundColorDecorator() {
        Slide slide = new MockSlide();
        BackgroundColorDecorator backgroundColorDecorator = new BackgroundColorDecorator(slide,
                BackgroundColorDecorator.YELLOW);

        assertNotNull(backgroundColorDecorator); // Check if BackgroundColorDecorator is not null
        assertEquals(BackgroundColorDecorator.YELLOW, backgroundColorDecorator.getColor()); // check if its set
    }
}