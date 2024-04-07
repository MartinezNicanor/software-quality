package jabberpoint.slideItemFactory;

import jabberpoint.Slide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextItemCreatorTest
{
    private Slide slide = new Slide();
    private SlideItemCreator textItemCreator = new TextItemCreator();

    @Test
    void createSlideItem()
    {
        slide.addSlideItem(textItemCreator.createSlideItem(1, "Im a text item"));
        slide.addSlideItem(textItemCreator.createSlideItem(2, "Im the second text item"));
        slide.addSlideItem(textItemCreator.createSlideItem(4, "Im another text item"));

        assertEquals(slide.getSlideItems().size(), 3);
    }
}
