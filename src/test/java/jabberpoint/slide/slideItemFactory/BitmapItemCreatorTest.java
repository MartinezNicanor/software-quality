package jabberpoint.slide.slideItemFactory;

import jabberpoint.slide.BitmapItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitmapItemCreatorTest
{
    @Test
    void createSlideItem_CreatesBitmapItemWithCorrectLevelAndImageName() {
        BitmapItemCreator factory = new BitmapItemCreator();
        BitmapItem bitmapItem = factory.createSlideItem(1, "jabberpoint.gif");

        assertEquals(1, bitmapItem.getLevel());
        assertEquals("jabberpoint.gif", bitmapItem.getImageName());
    }
}