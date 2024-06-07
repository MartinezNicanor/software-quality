package jabberpoint.decorator;

import jabberpoint.slide.Slide;
import jabberpoint.slide.SlideItem;
import jabberpoint.slide.Style;
import jabberpoint.slide.TextItem;
import jabberpoint.slide.slideItemFactory.SlideItemCreator;
import jabberpoint.slide.slideItemFactory.TextItemCreator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SlideTest {

    private Slide slide;
    private Graphics graphicsMock;
    private ImageObserver imageObserverMock;

    @Before
    public void setUp() {
        slide = new Slide();
        graphicsMock = mock(Graphics.class);
        imageObserverMock = mock(ImageObserver.class);

        // No need for Style.initializeStyles() here since it's handled in the Style class itself
    }

    @Test
    public void testSetTitle() {
        slide.setTitle("Test Title");
        assertEquals("Test Title", slide.getTitle());
    }

    @Test
    public void testAddSlideItem() {
        TextItemCreator textItemCreatorMock = Mockito.mock(TextItemCreator.class);
        TextItem textItemMock = Mockito.mock(TextItem.class); // Mock a TextItem

        Mockito.when(textItemCreatorMock.createSlideItem(1, "Text")).thenReturn(textItemMock);

        slide.textItemCreator = textItemCreatorMock;
        slide.addTextItem(1, "Text");

        Vector<SlideItem> slideItems = slide.getSlideItems();
        assertEquals(1, slideItems.size());
        assertEquals(textItemMock, slideItems.elementAt(0));
    }


    @Test
    public void testGetSlideItem() {
        SlideItem slideItem = Mockito.mock(SlideItem.class);
        slide.addSlideItem(slideItem);
        assertEquals(slideItem, slide.getSlideItem(0));
    }

    @Test
    public void testGetAmountOfSlideItems() {
        assertEquals(0, slide.getAmountOfSlideItems());
        slide.addTextItem(1, "Text");
        assertEquals(1, slide.getAmountOfSlideItems());
    }

    @Test
    public void testDraw() {
        // Mocking slide items for drawing
        TextItem textItemMock = Mockito.mock(TextItem.class); // Use TextItem.class instead of SlideItem.class
        SlideItem bitmapItemMock = Mockito.mock(SlideItem.class);

        // Mocking graphics object for drawing
        Graphics2D graphicsMock = Mockito.mock(Graphics2D.class);

        Mockito.when(textItemMock.getBoundingBox(Mockito.any(Graphics2D.class), Mockito.any(ImageObserver.class), Mockito.anyFloat(), Mockito.any(Style.class)))
                .thenReturn(new Rectangle(0, 0, 200, 50));
        Mockito.when(bitmapItemMock.getBoundingBox(Mockito.any(Graphics2D.class), Mockito.any(ImageObserver.class), Mockito.anyFloat(), Mockito.any(Style.class)))
                .thenReturn(new Rectangle(0, 0, 100, 100));

        slide.addSlideItem(textItemMock);
        slide.addSlideItem(bitmapItemMock);

        Rectangle area = new Rectangle(0, 0, 300, 300);
        slide.draw(graphicsMock, area, imageObserverMock);

        // Verify that draw methods of slide items are called
        Mockito.verify(textItemMock).draw(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyFloat(), Mockito.eq(graphicsMock), Mockito.any(Style.class), Mockito.eq(imageObserverMock));
        Mockito.verify(bitmapItemMock).draw(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyFloat(), Mockito.eq(graphicsMock), Mockito.any(Style.class), Mockito.eq(imageObserverMock));
    }



    @Test
    public void testGetScale() {
        Rectangle area = new Rectangle(0, 0, 600, 400);
        assertEquals(0.5f, slide.getScale(area), 0.01);
    }
}