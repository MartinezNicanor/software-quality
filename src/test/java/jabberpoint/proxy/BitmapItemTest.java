package jabberpoint.proxy;

import jabberpoint.BitmapItem;
import jabberpoint.Style;
import org.junit.Test;

import java.awt.*;
import java.awt.image.ImageObserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class BitmapItemTest
{

    @Test
    public void testGetImageName_WhenConstructedWithName_ShouldReturnSameName()
    {
        // Arrange
        String imageName = "test_image.png";
        BitmapItem bitmapItem = new BitmapItem(1, imageName);

        // act
        String result = bitmapItem.getImageName();

        // Assert
        assertEquals(imageName, result);
    }

    @Test
    public void testGetImageName_WhenConstructedWithNullName_ShouldReturnNull()
    {
        // Arrange
        BitmapItem bitmapItem = new BitmapItem(1, null);

        // act
        String result = bitmapItem.getImageName();

        // Assert
        assertNull(result);
    }

    @Test
    public void testToString_WhenConstructedWithName_ShouldReturnExpectedString()
    {
        // Arrange
        int level = 1;
        String imageName = "test_image.png";
        BitmapItem bitmapItem = new BitmapItem(level, imageName);
        String expected = "BitmapItem[" + level + "," + imageName + "]";

        // act
        String result = bitmapItem.toString();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_WhenConstructedWithNullName_ShouldReturnExpectedString()
    {
        // Arrange
        int level = 1;
        BitmapItem bitmapItem = new BitmapItem(level, null);
        String expected = "BitmapItem[" + level + ",null]";

        // act
        String result = bitmapItem.toString();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testGetBoundingBox_WhenStyleIsNull_ShouldReturnEmptyRectangle()
    {
        // Arrange
        BitmapItem bitmapItem = new BitmapItem(1, "JabberPoint.gif");
        Graphics g = createGraphicsMock();
        ImageObserver observer = createImageObserverMock();
        float scale = 1.0f;
        Style myStyle = null;

        // act
        Rectangle result = bitmapItem.getBoundingBox(g, observer, scale, myStyle);

        // Assert
        assertEquals(new Rectangle(0, 0, 0, 0), result);
    }

    // Mock methods to simulate dependencies
    private Graphics createGraphicsMock()
    {
        return null;
    }

    private ImageObserver createImageObserverMock()
    {
        return null;
    }
}