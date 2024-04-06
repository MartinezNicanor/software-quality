import static org.junit.Assert.assertTrue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import org.junit.Test;

public class FontSizeDecoratorTest {

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
    public void testDrawWithFontSize() {
        // Create mock slide
        MockSlide mockSlide = new MockSlide();

        // Create FontSizeDecorator instance with mock slide
        FontSizeDecorator fontSizeDecorator = new FontSizeDecorator(mockSlide, FontSizeDecorator.MEDIUM);

        // Mock Rectangle and ImageObserver objects
        Rectangle mockRectangle = new Rectangle(100, 100);
        ImageObserver mockImageObserver = (img, infoflags, x, y, width, height) -> false;

        // call draw method on FontSizeDecorator
        fontSizeDecorator.draw(null, mockRectangle, mockImageObserver);

        // Verify draw was called
        assertTrue(mockSlide.isDrawCalled());
    }
}