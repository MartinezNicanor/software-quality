package jabberpoint.proxy;

import jabberpoint.slide.BitmapItem;
import jabberpoint.slide.Style;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class BitmapItemProxyTest
{

    private BitmapItemProxy bitmapItemProxy;
    private BitmapItem realBitmapItemMock;
    private Graphics graphicsMock;
    private ImageObserver imageObserverMock;
    private Style styleMock;

    @BeforeEach
    public void setUp()
    {
        bitmapItemProxy = new BitmapItemProxy(1, "Jabberpoint.gif");
        realBitmapItemMock = mock(BitmapItem.class);
        graphicsMock = mock(Graphics.class);
        imageObserverMock = mock(ImageObserver.class);
        styleMock = mock(Style.class);
    }

    @Test
    public void getBoundingBox_Placeholder_ReturnsCorrectBoundingBox()
    {
        Rectangle placeholder = bitmapItemProxy.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);
        assertEquals(new Rectangle(0, 0, 100, 100), placeholder);
    }

    @Test
    public void getBoundingBox_RealItem_ReturnsBoundingBoxFromRealItem()
    {
        bitmapItemProxy.loadImage();
        bitmapItemProxy.realBitmapItem = realBitmapItemMock;
        Rectangle expectedRect = new Rectangle(0, 0, 200, 200);
        when(realBitmapItemMock.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock)).thenReturn(expectedRect);

        Rectangle actualRect = bitmapItemProxy.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);
        assertEquals(expectedRect, actualRect);
    }

    @Test
    public void draw_Placeholder_DrawsPlaceholderCorrectly()
    {
        bitmapItemProxy.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
        verify(graphicsMock).drawRect(0, 0, 100, 100);
    }

    @Test
    public void draw_RealItem_DrawsRealItemCorrectly()
    {
        bitmapItemProxy.loadImage();
        bitmapItemProxy.realBitmapItem = realBitmapItemMock;

        bitmapItemProxy.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
        verify(realBitmapItemMock).draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);
    }

    @Test
    public void getLevel_ReturnsCorrectLevel()
    {
        assertEquals(1, bitmapItemProxy.getLevel());
    }

    @Test
    public void toString_Placeholder_ReturnsCorrectStringRepresentation()
    {
        assertEquals("BitmapItemProxy[1,Jabberpoint.gif]", bitmapItemProxy.toString());
    }

    @Test
    public void toString_RealItem_ReturnsStringRepresentationFromRealItem()
    {
        bitmapItemProxy.loadImage();
        bitmapItemProxy.realBitmapItem = realBitmapItemMock;
        when(realBitmapItemMock.toString()).thenReturn("BitmapItem[1,Jabberpoint.gif]");

        assertEquals("BitmapItem[1,Jabberpoint.gif]", bitmapItemProxy.toString());
    }
}