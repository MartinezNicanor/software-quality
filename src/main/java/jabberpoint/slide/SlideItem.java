package jabberpoint.slide;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * <p>The abstract class for an item on a slide<p>
 * <p>All SlideItems have drawingfunctionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public interface SlideItem
{
    // Give the bounding box
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

    // Draw the item
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);

    int getLevel();
}
