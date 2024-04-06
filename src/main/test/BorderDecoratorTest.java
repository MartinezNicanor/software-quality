import static org.junit.Assert.assertTrue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import org.junit.Test;

public class BorderDecoratorTest {

    // Mock Slide class for testing
    private static class MockSlide extends Slide {
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
    public void testDrawWithBorderColor() {
        // Create mock slide
        MockSlide mockSlide = new MockSlide();

        // Choose border color
        Color borderColor = BorderDecorator.RED;

        // Create BorderDecorator instance with the mock slide
        BorderDecorator borderDecorator = new BorderDecorator(mockSlide, borderColor);

        // Mock Rectangle and ImageObserver objects
        Rectangle mockRectangle = new Rectangle(100, 100);
        ImageObserver mockImageObserver = (img, infoflags, x, y, width, height) -> false;

        // call draw method on BorderDecorator
        borderDecorator.draw(null, mockRectangle, mockImageObserver);

        // Verify that draw was called
        assertTrue(mockSlide.isDrawCalled());
    }
}