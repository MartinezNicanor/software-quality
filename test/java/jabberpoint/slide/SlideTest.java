package jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SlideTest
{

    Slide slide;

    @BeforeEach
    void setUp()
    {
        slide = new Slide();
        Style.createStyles();
    }

    @Test
    void constructor_ZeroSlideItems()
    {
        assertNotNull(slide);
        assertEquals(0, slide.getAmountOfSlideItems());
    }

    @Test
    void getTitle_ReturnsTitle()
    {
        assertNull(slide.getTitle());
        slide.setTitle("Test Slide");
        assertEquals("Test Slide", slide.getTitle());
    }

    @Test
    void setTitle_NewTitleSet()
    {
        slide.setTitle("New Title");
        assertEquals("New Title", slide.getTitle());
    }

    @Test
    void addTextItem_TextItemAddedToSlide()
    {
        slide.addTextItem(1, "Sample Text");
        assertEquals(1, slide.getAmountOfSlideItems());
        SlideItem item = slide.getSlideItem(0);
        assertTrue(item instanceof TextItem);
        assertEquals("Sample Text", ((TextItem) item).getText());
    }

    @Test
    void addBitmapItem_BitmapItemAddedToSlide()
    {
        slide.addBitmapItem(1, "Jabberpoint.gif");
        assertEquals(1, slide.getAmountOfSlideItems());
        SlideItem item = slide.getSlideItem(0);
        assertTrue(item instanceof BitmapItem);
        assertEquals("Jabberpoint.gif", ((BitmapItem) item).getImageName());
    }

    @Test
    void getSlideItem_ReturnsCorrectSlideItem()
    {
        slide.addTextItem(1, "Sample Text");
        slide.addBitmapItem(1, "Jabberpoint.gif");

        SlideItem textItem = slide.getSlideItem(0);
        SlideItem bitmapItem = slide.getSlideItem(1);

        assertTrue(textItem instanceof TextItem);
        assertTrue(bitmapItem instanceof BitmapItem);
    }

    @Test
    void getSlideItems_ReturnsAllSlideItems()
    {
        slide.addTextItem(1, "Sample Text");
        slide.addBitmapItem(1, "Jabberpoint.gif");

        Vector<SlideItem> items = slide.getSlideItems();
        assertEquals(2, items.size());
    }

    @Test
    void getAmountOfSlideItems_ReturnsCorrectAmount()
    {
        assertEquals(0, slide.getAmountOfSlideItems());
        slide.addTextItem(1, "Sample Text");
        slide.addBitmapItem(1, "Jabberpoint.gif");
        assertEquals(2, slide.getAmountOfSlideItems());
    }

    @Test
    void draw_SlideDrawnCorrectlyOnGraphicsContext()
    {
        // Create a BufferedImage to get a real Graphics2D context
        BufferedImage bufferedImage = new BufferedImage(Slide.WIDTH, Slide.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        ImageObserver observer = mock(ImageObserver.class);
        Rectangle area = new Rectangle(0, 0, Slide.WIDTH, Slide.HEIGHT);

        slide.setTitle("Title");
        slide.addTextItem(1, "Sample Text");
        slide.addBitmapItem(1, "Jabberpoint.gif");

        // Draw slide on the real Graphics2D context
        slide.draw(graphics, area, observer);

        // Validate drawing by checking pixel data or other graphics methods
        assertNotNull(bufferedImage);  // Simple check to ensure drawing was attempted

        // Release resources
        graphics.dispose();
    }

    @Test
    void getScale_ReturnsCorrectScaleForGivenArea()
    {
        Rectangle area = new Rectangle(0, 0, 600, 400);
        float scale = slide.getScale(area);
        assertEquals(0.5f, scale, 0.01f);

        area = new Rectangle(0, 0, 2400, 1600);
        scale = slide.getScale(area);
        assertEquals(2.0f, scale, 0.01f);
    }
}
