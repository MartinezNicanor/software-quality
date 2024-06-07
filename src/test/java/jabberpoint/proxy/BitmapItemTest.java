package jabberpoint.proxy;

import jabberpoint.slide.BitmapItem;
import jabberpoint.slide.Style;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BitmapItemTest {

    private BitmapItem bitmapItem;
    private Graphics graphicsMock;
    private ImageObserver imageObserverMock;
    private Style styleMock;

    @Before
    public void setUp() {
        bitmapItem = new BitmapItem(1, "jabberpoint.gif");
        bitmapItem.bufferedImage = null;
        graphicsMock = mock(Graphics.class);
        imageObserverMock = mock(ImageObserver.class);
        styleMock = mock(Style.class);
    }


    @Test
    public void testGetBoundingBox_NoImageLoaded() {
        Rectangle boundingBox = bitmapItem.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);
        assertEquals(new Rectangle(), boundingBox);
    }

    @Test
    public void testDraw_NoImageLoaded() {
        bitmapItem.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
        // No interaction with graphicsMock expected, so no verification needed.
    }

    @Test
    public void testGetLevel() {
        assertEquals(1, bitmapItem.getLevel());
    }

    @Test
    public void testToString() {
        assertEquals("BitmapItem[1,jabberpoint.gif]", bitmapItem.toString());
    }

    @Test
    public void testGetBoundingBox_WithImage() {
        BufferedImage bufferedImageMock = mock(BufferedImage.class);
        bitmapItem.bufferedImage = bufferedImageMock;

        when(bufferedImageMock.getWidth(imageObserverMock)).thenReturn(100);
        when(bufferedImageMock.getHeight(imageObserverMock)).thenReturn(100);

        Rectangle boundingBox = bitmapItem.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);

        assertEquals(new Rectangle(0, 0, 100, 100), boundingBox);
    }


    @Test
    public void testDraw_WithImage() {
        BufferedImage bufferedImageMock = mock(BufferedImage.class);
        bitmapItem.bufferedImage = bufferedImageMock;

        bitmapItem.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);

        verify(graphicsMock).drawImage(
                eq(bufferedImageMock), anyInt(), anyInt(), anyInt(), anyInt(), eq(imageObserverMock));
    }


    @Test
    public void testDraw_WithNullStyle() {
        BufferedImage bufferedImageMock = mock(BufferedImage.class);
        bitmapItem.bufferedImage = bufferedImageMock;

        bitmapItem.draw(0, 0, 1.0f, graphicsMock, null, imageObserverMock);

    }
}