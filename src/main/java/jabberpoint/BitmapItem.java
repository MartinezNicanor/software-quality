package jabberpoint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem {
    private BufferedImage image;
    private String imageName;

    // Constants for error message
    private static final String FILE_PREFIX = "File ";
    private static final String NOT_FOUND_SUFFIX = " not found";

    // Constructor
    public BitmapItem(int level, String name) {
        super(level);
        imageName = name;
        loadImage();
    }

    // Default constructor (creates an empty BitmapItem)
    public BitmapItem() {
        this(0, null);
    }

    // Get the name of the image file
    public String getImageName() {
        return imageName;
    }

    // Load image from file
    private void loadImage() {
        if (imageName != null) {
            try {
                image = ImageIO.read(new File(imageName));
            } catch (IOException e) {
                // If an error occurs while loading the image, print an error message
                System.err.println(FILE_PREFIX + imageName + NOT_FOUND_SUFFIX);
                // Set image to null to indicate failure
                image = null;
            }
        }
    }

    // Get bounding box of the image
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        if (myStyle == null || image == null) {
            // handle null Style or image
            return new Rectangle(0, 0, 0, 0); // return an empty Rectangle
        }
        return new Rectangle((int) (myStyle.getIndent() * scale), 0,
                (int) (image.getWidth(observer) * scale),
                ((int) (myStyle.getLeading() * scale)) +
                        (int) (image.getHeight(observer) * scale));
    }

    // Draw image
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
        if (style == null || image == null) {
            // handle null style or null image
            style = new Style(0, Color.BLACK, 0, 0);
        }

        // Draw image using the style
        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getLeading() * scale);
        g.drawImage(image, width, height, (int) (image.getWidth(observer) * scale),
                (int) (image.getHeight(observer) * scale), observer);
    }

    // Get string representation of BitmapItem
    @Override
    public String toString() {
        return "BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}
