import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BitmapItemTest {

    @Test
    public void testGetImageName_WhenConstructedWithName_ShouldReturnSameName() {
        // arrange
        String imageName = "test_image.png";
        BitmapItem bitmapItem = new BitmapItem(1, imageName);

        // Act
        String result = bitmapItem.getImageName();

        // Assert
        assertEquals(imageName, result);
    }

    @Test
    public void testGetImageName_WhenConstructedWithNullName_ShouldReturnNull() {
        // arrange
        BitmapItem bitmapItem = new BitmapItem(1, null);

        // Act
        String result = bitmapItem.getImageName();

        // Assert
        assertNull(result);
    }

    @Test
    public void testToString_WhenConstructedWithName_ShouldReturnExpectedString() {
        // arrange
        int level = 1;
        String imageName = "test_image.png";
        BitmapItem bitmapItem = new BitmapItem(level, imageName);
        String expected = "BitmapItem[" + level + "," + imageName + "]";

        // Act
        String result = bitmapItem.toString();

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testToString_WhenConstructedWithNullName_ShouldReturnExpectedString() {
        // arrange
        int level = 1;
        BitmapItem bitmapItem = new BitmapItem(level, null);
        String expected = "BitmapItem[" + level + ",null]";

        // Act
        String result = bitmapItem.toString();

        // Assert
        assertEquals(expected, result);
    }
}