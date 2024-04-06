import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem {
	private BufferedImage image; // The loaded image
	private String imageName; // The name of the image file

	// Constants for error message
	private static final String FILE_PREFIX = "File ";
	private static final String NOT_FOUND_SUFFIX = " not found";

	// Constructor with level and image file name
	public BitmapItem(int level, String imageName) {
		super(level);
		this.imageName = imageName;
		loadImage(); // Load the image upon instantiation
	}

	// Default constructor (creates an empty BitmapItem)
	public BitmapItem() {
		this(0, null);
	}

	// Get the name of the image file
	public String getImageName() {
		return imageName;
	}

	// Get the name of the image file
	public String getName() {
		return imageName;
	}

	// Get the bounding box of the image
	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style) {
		// Calculate bounding box based on image dimensions and style
		return new Rectangle((int) (style.indent * scale), 0,
				(int) (image.getWidth(observer) * scale),
				((int) (style.leading * scale)) +
						(int) (image.getHeight(observer) * scale));
	}

	// Draw the image
	public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
		// Draw the image at specified location and scale
		int width = x + (int) (style.indent * scale);
		int height = y + (int) (style.leading * scale);
		g.drawImage(image, width, height, (int) (image.getWidth(observer) * scale),
				(int) (image.getHeight(observer) * scale), observer);
	}

	// Load the image from file
	private void loadImage() {
		try {
			image = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			// If an error occurs while loading the image, print an error message
			System.err.println(FILE_PREFIX + imageName + NOT_FOUND_SUFFIX);
		}
	}

	// Get a string representation of the BitmapItem
	@Override
	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}
}