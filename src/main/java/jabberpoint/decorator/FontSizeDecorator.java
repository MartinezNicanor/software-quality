package jabberpoint.decorator;

import jabberpoint.slide.Slide;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

// Decorator to change font size of slides
public class FontSizeDecorator extends SlideDecorator
{
    int fontSize;

    // Different font size options
    public static final int SMALL = 10;
    public static final int MEDIUM = 14;
    public static final int LARGE = 18;
    public static final int XLARGE = 22;
    public static final int XXLARGE = 26;

    public FontSizeDecorator(Slide decoratedSlide, int fontSize)
    {
        super(decoratedSlide);
        this.fontSize = fontSize;
    }

    public int getFontSize()
    {
        return fontSize;
    }

    // Change font size before drawing
    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        super.draw(g, area, view);
        if (g != null)
        {
            Font originalFont = g.getFont();
            g.setFont(originalFont.deriveFont((float) fontSize));
        } else
        {
            throw new IllegalArgumentException("Graphics object cannot be null");
        }
    }
}
