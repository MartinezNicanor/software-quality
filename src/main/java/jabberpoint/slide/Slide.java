package jabberpoint.slide;

import jabberpoint.slide.slideItemFactory.BitmapItemCreator;
import jabberpoint.slide.slideItemFactory.SlideItemCreator;
import jabberpoint.slide.slideItemFactory.TextItemCreator;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>A slide. This class has a drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide
{
    public final static int WIDTH = 1200;
    public final static int HEIGHT = 800;
    protected String title; // title is saved separately
    protected Vector<SlideItem> slideItems; // slide items are saved in a Vector
    private final SlideItemCreator textItemCreator = new TextItemCreator();
    private final SlideItemCreator bitmapItemCreator = new BitmapItemCreator();


    public Slide()
    {
        slideItems = new Vector<SlideItem>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    public void addSlideItem(SlideItem slideItem)
    {
        this.slideItems.addElement(slideItem);
    }

    public void addTextItem(int level, String message)
    {
        addSlideItem(textItemCreator.createSlideItem(level, message));
    }

    public void addBitmapItem(int level, String message)
    {
        addSlideItem(bitmapItemCreator.createSlideItem(level, message));
    }

    public SlideItem getSlideItem(int number)
    {
        return (SlideItem) slideItems.elementAt(number);
    }

    public Vector<SlideItem> getSlideItems()
    {
        return this.slideItems;
    }

    // give the size of the Slide
    public int getAmountOfSlideItems()
    {
        return this.slideItems.size();
    }

    // draw the slide
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        float scale = getScale(area);
        int y = area.y;
        // Title is handled separately
        SlideItem slideItem = textItemCreator.createSlideItem(0, getTitle());
        Style style = Style.getStyle(slideItem.getLevel());
        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;

        for (int number = 0; number < getAmountOfSlideItems(); number++)
        {
            slideItem = getSlideItems().elementAt(number);
            style = Style.getStyle(slideItem.getLevel());
            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    // Give the scale for drawing
    public float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}
