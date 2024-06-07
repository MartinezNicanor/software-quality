package jabberpoint.slide.slideItemFactory;

import jabberpoint.slide.BitmapItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitmapItemCreatorTest
{
    @Test
    void createSlideItem_CreatesBitmapItemWithCorrectLevelAndImageName()
    {
        BitmapItemCreator factory = new BitmapItemCreator();
        BitmapItem bitmapItem = factory.createSlideItem(1, "Jabberpoint.gif");

        assertEquals(1, bitmapItem.getLevel());
        assertEquals("Jabberpoint.gif", bitmapItem.getText());
    }
}