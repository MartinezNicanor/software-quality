package jabberpoint.proxy;

import jabberpoint.slide.BitmapItem;
import jabberpoint.slide.SlideItem;
import jabberpoint.slide.Style;

import java.awt.*;
import java.awt.image.ImageObserver;

public class BitmapItemProxy implements SlideItem
{
    private String imageName; // The name of the image file
    private int level;
    protected BitmapItem realBitmapItem; // The real BitmapItem object

    // Constructor
    public BitmapItemProxy(int level, String name)
    {
        this.level = level;
        this.imageName = name;
    }



    // Get bounding box
    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle)
    {
        if (realBitmapItem == null)
        {
            // Placeholder logic: return a placeholder rectangle
            return new Rectangle(0, 0, 100, 100); // Example placeholder size
        } else
        {
            // Delegate call to the real BitmapItem object
            return realBitmapItem.getBoundingBox(g, observer, scale, myStyle);
        }
    }

    // Draws image
    @Override
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer)
    {
        if (realBitmapItem == null)
        {
            // Draw placeholder rectangle
            g.drawRect(x, y, 100, 100); // Example placeholder rectangle
        } else
        {
            // Delegate the call to real BitmapItem object
            realBitmapItem.draw(x, y, scale, g, myStyle, observer);
        }
    }

    @Override
    public String getText()
    {
        return imageName;
    }

    @Override
    public int getLevel()
    {
        return this.level;
    }

    // Returns string representation of BitmapItemProxy
    @Override
    public String toString()
    {
        if (realBitmapItem == null)
        {
            // If the real BitmapItem object is not loaded yet
            return "BitmapItemProxy[" + getLevel() + "," + imageName + "]";
        } else
        {
            // If the real BitmapItem object is loaded
            return realBitmapItem.toString();
        }
    }

    // Loads real BitmapItem object.
    public void loadImage()
    {
        try
        {
            // Attempt to load image using real BitmapItem object
            realBitmapItem = new BitmapItem(getLevel(), imageName);
        } catch (Exception e)
        {
            // Handle error when loading image
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging purposes
        }
    }
}
