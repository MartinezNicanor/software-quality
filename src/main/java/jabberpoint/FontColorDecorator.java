package jabberpoint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

// Decorator to change font color of slides
public class FontColorDecorator extends SlideDecorator
{
    Color color;

    // Different font color options
    public static final Color BLACK = Color.BLACK;
    public static final Color RED = Color.RED;
    public static final Color BLUE = Color.BLUE;
    public static final Color GREEN = Color.GREEN;
    public static final Color ORANGE = Color.ORANGE;

    public FontColorDecorator(Slide decoratedSlide, Color color)
    {
        super(decoratedSlide);
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    // Set font color before drawing
    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        super.draw(g, area, view);
        g.setColor(color);
    }
}
