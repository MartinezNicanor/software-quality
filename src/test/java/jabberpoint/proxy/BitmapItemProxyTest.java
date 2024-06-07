package jabberpoint.proxy;

import jabberpoint.slide.BitmapItem;
import jabberpoint.slide.Style;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BitmapItemProxyTest {

    private BitmapItemProxy bitmapItemProxy;
    private BitmapItem realBitmapItemMock;
    private Graphics graphicsMock;
    private ImageObserver imageObserverMock;
    private Style styleMock;

    @Before
    public void setUp() {
        bitmapItemProxy = new BitmapItemProxy(1, "testImage.jpg");
        realBitmapItemMock = mock(BitmapItem.class);
        graphicsMock = mock(Graphics.class);
        imageObserverMock = mock(ImageObserver.class);
        styleMock = mock(Style.class);
    }

    @Test
    public void testGetBoundingBox_Placeholder() {
        Rectangle placeholder = bitmapItemProxy.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);
        assertEquals(new Rectangle(0, 0, 100, 100), placeholder);
    }

    @Test
    public void testGetBoundingBox_RealItem() {
        bitmapItemProxy.loadImage();
        bitmapItemProxy.realBitmapItem = realBitmapItemMock;
        Rectangle expectedRect = new Rectangle(0, 0, 200, 200);
        when(realBitmapItemMock.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock)).thenReturn(expectedRect);

        Rectangle actualRect = bitmapItemProxy.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);
        assertEquals(expectedRect, actualRect);
    }

    @Test
    public void testDraw_Placeholder() {
        bitmapItemProxy.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
        verify(graphicsMock).drawRect(0, 0, 100, 100);
    }

    @Test
    public void testDraw_RealItem() {
        bitmapItemProxy.loadImage();
        bitmapItemProxy.realBitmapItem = realBitmapItemMock;

        bitmapItemProxy.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
        verify(realBitmapItemMock).draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
    }

    @Test
    public void testGetLevel() {
        assertEquals(1, bitmapItemProxy.getLevel());
    }

    @Test
    public void testToString_Placeholder() {
        assertEquals("BitmapItemProxy[1,testImage.jpg]", bitmapItemProxy.toString());
    }

    @Test
    public void testToString_RealItem() {
        bitmapItemProxy.loadImage();
        bitmapItemProxy.realBitmapItem = realBitmapItemMock;
        when(realBitmapItemMock.toString()).thenReturn("BitmapItem[1,testImage.jpg]");

        assertEquals("BitmapItem[1,testImage.jpg]", bitmapItemProxy.toString());
    }

    @Test
    public void testLoadImage() {
        bitmapItemProxy.loadImage();
        assertNotNull(bitmapItemProxy.realBitmapItem);
    }
}