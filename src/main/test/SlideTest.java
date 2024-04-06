import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;
import java.util.Vector;

import org.junit.Test;

public class SlideTest {

    // Test method to verify scale calculation when width is larger
    @Test
    public void testGetScale_WidthLarger() {
        Slide slide = new Slide();
        Rectangle area = new Rectangle(800, 600); // Larger area
        float scale = slide.getScale(area);
        assertEquals(0.5f, scale, 0.01); // Expected scale
    }

    // Test method to verify scale calculation when height is larger
    @Test
    public void testGetScale_HeightLarger() {
        Slide slide = new Slide();
        Rectangle area = new Rectangle(600, 800); // Larger area
        float scale = slide.getScale(area);
        assertEquals(0.5f, scale, 0.01); // Expected scale
    }

    // Test method to verify scale calculation when width and height have the same ratio
    @Test
    public void testGetScale_SameRatio() {
        Slide slide = new Slide();
        Rectangle area = new Rectangle(1200, 800); // Same ratio
        float scale = slide.getScale(area);
        assertEquals(1.0f, scale, 0.01); // Expected scale
    }

    // Test method to verify getting slide items
    @Test
    public void testGetSlideItem() {
        Slide slide = new Slide();
        SlideItem item1 = new TextItem(0, "Item 1");
        SlideItem item2 = new TextItem(1, "Item 2");
        slide.append(item1);
        slide.append(item2);

        Vector<SlideItem> items = slide.getSlideItems();
        assertEquals(2, items.size()); // Check size of items vector

        assertEquals(item1, slide.getSlideItem(0)); // Check first item
        assertEquals(item2, slide.getSlideItem(1)); // Check second item
    }
}