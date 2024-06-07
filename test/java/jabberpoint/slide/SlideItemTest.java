package jabberpoint.slide;

import jabberpoint.slide.slideItemFactory.BitmapItemCreator;
import jabberpoint.slide.slideItemFactory.SlideItemCreator;
import jabberpoint.slide.slideItemFactory.TextItemCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlideItemTest
{
    private Slide slide = new Slide();
    private SlideItemCreator textItemCreator = new TextItemCreator();
    private SlideItemCreator bitmapItemCreator = new BitmapItemCreator();

    // TextItem tests
    @Test
    void createTextItem_CreatesThreeTextItems()
    {
        slide.addSlideItem(textItemCreator.createSlideItem(1, "Im a text item"));
        slide.addSlideItem(textItemCreator.createSlideItem(2, "Im the second text item"));
        slide.addSlideItem(textItemCreator.createSlideItem(4, "Im another text item"));

        assertEquals(slide.getSlideItems().size(), 3);
    }

    // BitmapItem tests
    @Test
    void createBitmapItem_CreatesThreeBitmapItems()
    {
        slide.addSlideItem(bitmapItemCreator.createSlideItem(1, "logo-woordmerk_ou.gif"));
        slide.addSlideItem(bitmapItemCreator.createSlideItem(2, "serclogo_fc.jpg"));
        slide.addSlideItem(bitmapItemCreator.createSlideItem(4, "./JabberPoint.gif"));

        assertEquals(slide.getSlideItems().size(), 3);
    }

    @Test
    void throwErrorIfImageDoesNotExist_CreateBitmapItemWithInvalidImage_ThrowsException()
    {
        assertThrows(RuntimeException.class, () -> slide.addBitmapItem(2, "random.img"));
    }
}
