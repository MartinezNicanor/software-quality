import org.junit.Test;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class BitmapItemProxyTest {

    @Test
    public void testGetBoundingBox_WhenRealBitmapItemIsNotNull_ShouldDelegateToRealBitmapItem() {
        // Arrange
        BitmapItemProxy proxy = new BitmapItemProxy(1, "test_image.png");
        BitmapItem realBitmapItem = new BitmapItem(1, "test_image.png");
        setPrivateField(proxy, "realBitmapItem", realBitmapItem); // Set the realBitmapItem using reflection
        Graphics g = createGraphicsMock();
        ImageObserver observer = createImageObserverMock();
        float scale = 1.0f;
        Style myStyle = createStyleMock();

        // Act
        Rectangle result = proxy.getBoundingBox(g, observer, scale, myStyle);

        // Assert
        Rectangle expected = realBitmapItem.getBoundingBox(g, observer, scale, myStyle);
        assertEquals(expected, result);
    }

    // mock methods to simulate dependencies
    private Graphics createGraphicsMock() {
        return null;
    }

    private ImageObserver createImageObserverMock() {
        return null;
    }

    private Style createStyleMock() {
        return null;
    }

    // method to set private fields
    private void setPrivateField(Object object, String fieldName, Object value) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}