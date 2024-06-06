package jabberpoint.decorator;

import jabberpoint.slide.Slide;
import jabberpoint.slide.SlideItem;
import jabberpoint.slide.TextItem;
import jabberpoint.slide.slideItemFactory.BitmapItemCreator;
import jabberpoint.slide.slideItemFactory.SlideItemCreator;
import jabberpoint.slide.slideItemFactory.TextItemCreator;
import org.junit.Test;

import java.awt.*;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class SlideTest
{

    private SlideItemCreator textItemCreator = new TextItemCreator();
    private SlideItemCreator bitmapItemCreator = new BitmapItemCreator();

    // Test method to verify scale calculation when width is larger
    @Test
    public void testGetScale_WidthLarger()
    {
        Slide slide = new Slide();
        Rectangle area = new Rectangle(800, 600); // Larger area
        float scale = slide.getScale(area);
        // Adjust the expected value based on the actual calculated scale
        assertEquals(2.0f / 3.0f, scale, 0.01); // Expected scale: 2/3
    }


    // Test method to verify scale calculation when height is larger
    @Test
    public void testGetScale_HeightLarger()
    {
        Slide slide = new Slide();
        Rectangle area = new Rectangle(600, 800); // Larger area
        float scale = slide.getScale(area);
        assertEquals(0.5f, scale, 0.01); // Expected scale
    }

    // Test method to verify scale calculation when width and height have the same ratio
    @Test
    public void testGetScale_SameRatio()
    {
        Slide slide = new Slide();
        Rectangle area = new Rectangle(1200, 800); // Same ratio
        float scale = slide.getScale(area);
        assertEquals(1.0f, scale, 0.01); // Expected scale
    }

    // Test method to verify getting slide items
    @Test
    public void testGetSlideItem()
    {
        Slide slide = new Slide();
        SlideItem item1 = new TextItem(0, "Item 1");
        SlideItem item2 = new TextItem(1, "Item 2");
        slide.addTextItem(0, "Item 1");
        slide.addTextItem(1, "Item 2");

        Vector<SlideItem> items = slide.getSlideItems();
        assertEquals(2, items.size()); // Check size of items vector

        assertEquals(item1, slide.getSlideItem(0)); // Check first item
        assertEquals(item2, slide.getSlideItem(1)); // Check second item
    }
}
