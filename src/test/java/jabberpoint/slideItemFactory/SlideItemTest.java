package jabberpoint.slideItemFactory;

import jabberpoint.Slide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideItemTest
{
    private Slide slide = new Slide();
    private SlideItemCreator textItemCreator = new TextItemCreator();
    private SlideItemCreator bitmapItemCreator = new BitmapItemCreator();

    // TextItem tests
    @Test
    void createTextItem_textItemCreates3Items_assertEqualsTrue()
    {
        slide.addSlideItem(textItemCreator.createSlideItem(1, "Im a text item"));
        slide.addSlideItem(textItemCreator.createSlideItem(2, "Im the second text item"));
        slide.addSlideItem(textItemCreator.createSlideItem(4, "Im another text item"));

        assertEquals(slide.getSlideItems().size(), 3);
    }

    // BitmapItem tests
    @Test
    void createBitmapItem_bitmapItemCreates3Items_assertEqualsTrue()
    {
        slide.addSlideItem(bitmapItemCreator.createSlideItem(1, "logo-woordmerk_ou.gif"));
        slide.addSlideItem(bitmapItemCreator.createSlideItem(2, "serclogo_fc.jpg"));
        slide.addSlideItem(bitmapItemCreator.createSlideItem(4, "JabberPoint.gif"));

        assertEquals(slide.getSlideItems().size(), 3);
    }

    @Test
    void throwErrorIfImageDoesNotExist_createBitmapItemWithRandomString_throwsException()
    {
        assertThrows(RuntimeException.class, () -> slide.addBitmapItem(2, "random.img"));
    }
}
