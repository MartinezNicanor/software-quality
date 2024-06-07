package jabberpoint.slide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

;

public class BitmapItemTest
{

    private BitmapItem bitmapItem;
    private Graphics graphicsMock;
    private ImageObserver imageObserverMock;
    private Style styleMock;

    @BeforeEach
    public void setUp()
    {
        bitmapItem = new BitmapItem(1, "../Jabberpoint.gif");
        bitmapItem.setBufferedImage(null);
        graphicsMock = mock(Graphics.class);
        imageObserverMock = mock(ImageObserver.class);
        styleMock = mock(Style.class);
    }

    @Test
    public void getLevel_ReturnsCorrectLevel()
    {
        assertEquals(1, bitmapItem.getLevel());
    }

    @Test
    public void toString_ReturnsExpectedStringRepresentation()
    {
        assertEquals("BitmapItem[1,../Jabberpoint.gif]", bitmapItem.toString());
    }

    @Test
    public void getBoundingBox_WithImage_ReturnsCorrectBoundingBox()
    {
        BufferedImage bufferedImageMock = mock(BufferedImage.class);
        bitmapItem.setBufferedImage(bufferedImageMock);

        when(bufferedImageMock.getWidth(imageObserverMock)).thenReturn(100);
        when(bufferedImageMock.getHeight(imageObserverMock)).thenReturn(100);

        Rectangle boundingBox = bitmapItem.getBoundingBox(graphicsMock, imageObserverMock, 1.0f, styleMock);

        assertEquals(new Rectangle(0, 0, 100, 100), boundingBox);
    }


    @Test
    public void draw_WithImage_DrawsImageCorrectly()
    {
        BufferedImage bufferedImageMock = mock(BufferedImage.class);
        bitmapItem.setBufferedImage(bufferedImageMock);

        bitmapItem.draw(0, 0, 1.0f, graphicsMock, styleMock, imageObserverMock);

        verify(graphicsMock).drawImage(
                eq(bufferedImageMock), anyInt(), anyInt(), anyInt(), anyInt(), eq(imageObserverMock));
    }


    @Test
    public void draw_WithNullStyle_DoesNotThrowException()
    {
        BufferedImage bufferedImageMock = mock(BufferedImage.class);
        bitmapItem.setBufferedImage(bufferedImageMock);

        bitmapItem.draw(0, 0, 1.0f, graphicsMock, null, imageObserverMock);

    }
}