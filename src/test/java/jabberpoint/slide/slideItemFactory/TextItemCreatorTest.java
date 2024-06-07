package jabberpoint.slide.slideItemFactory;

import jabberpoint.slide.TextItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextItemCreatorTest
{
    @Test
    void createSlideItem_CreatesTextItemWithCorrectLevelAndText() {
        TextItemCreator factory = new TextItemCreator();
        TextItem textItem = factory.createSlideItem(1, "Funny text");

        assertEquals(1, textItem.getLevel());
        assertEquals("Funny text", textItem.getText());
    }
}