package jabberpoint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

// Decorator to add background color to slides
public class BackgroundColorDecorator extends SlideDecorator
{
    Color color;

    // Different background color options
    public static final Color WHITE = Color.WHITE;
    public static final Color LIGHT_GRAY = Color.LIGHT_GRAY;
    public static final Color YELLOW = Color.YELLOW;
    public static final Color CYAN = Color.CYAN;
    public static final Color PINK = Color.PINK;

    public BackgroundColorDecorator(Slide decoratedSlide, Color color)
    {
        super(decoratedSlide);
        this.color = color;
    }

    public Color getColor()
    {
        return color;
    }

    // Draws background color on top of decorated slide
    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        super.draw(g, area, view);
        if (g != null)
        {
            g.setColor(color);
            g.fillRect(area.x, area.y, area.width, area.height);
        }
    }
}
