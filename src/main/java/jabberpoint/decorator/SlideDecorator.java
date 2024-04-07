package jabberpoint.decorator;

import jabberpoint.slide.Slide;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

// Base decorator class for slides
public abstract class SlideDecorator extends Slide
{
    protected Slide decoratedSlide;

    public SlideDecorator(Slide decoratedSlide)
    {
        this.decoratedSlide = decoratedSlide;
    }

    // Delegate draw method to decorated slide
    @Override
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        decoratedSlide.draw(g, area, view);
    }
}
