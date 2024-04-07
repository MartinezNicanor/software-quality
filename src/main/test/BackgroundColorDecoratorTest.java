import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import jabberpoint.BackgroundColorDecorator;
import jabberpoint.Slide;
import org.junit.Test;

public class BackgroundColorDecoratorTest {

    // Mock Slide class for testing
    private static class MockSlide extends Slide
    {
        private boolean drawCalled = false;

        @Override
        public void draw(Graphics g, Rectangle area, ImageObserver view) {
            drawCalled = true;
        }

        public boolean isDrawCalled() {
            return drawCalled;
        }
    }

    @Test
    public void testDrawWithBackgroundColor() {
        // Create mock slide
        MockSlide mockSlide = new MockSlide();

        // Choose background color
        Color backgroundColor = BackgroundColorDecorator.LIGHT_GRAY;

        // Create BackgroundColorDecorator instance with the mock slide
        BackgroundColorDecorator backgroundColorDecorator = new BackgroundColorDecorator(mockSlide, backgroundColor);

        // Mock Rectangle and ImageObserver objects
        Rectangle mockRectangle = new Rectangle(100, 100);
        ImageObserver mockImageObserver = (img, infoflags, x, y, width, height) -> false;

        // call draw method on BackgroundColorDecorator
        backgroundColorDecorator.draw(null, mockRectangle, mockImageObserver);

        // Verify that draw was called
        assertTrue(mockSlide.isDrawCalled());
    }
}