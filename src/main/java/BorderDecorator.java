import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

// Decorator to add border to slides
public class BorderDecorator extends SlideDecorator {
    private Color color;

    // Different border color options
    public static final Color BLACK = Color.BLACK;
    public static final Color RED = Color.RED;
    public static final Color BLUE = Color.BLUE;
    public static final Color GREEN = Color.GREEN;
    public static final Color ORANGE = Color.ORANGE;

    public BorderDecorator(Slide decoratedSlide, Color color) {
        super(decoratedSlide);
        this.color = color;
    }

    // Draw border on top of decorated slide
    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        super.draw(g, area, view);
        g.setColor(color);
        g.drawRect(area.x, area.y, area.width, area.height);
    }
}