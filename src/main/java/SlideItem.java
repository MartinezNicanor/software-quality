import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class SlideItem {
	private int level = 0;

	// Constructs SlideItem with the given level
	public SlideItem(int lev) {
		level = lev;
	}

	// Constructs SlideItem with level 0
	public SlideItem() {
		this(0);
	}

	// Returns the level of the slide item
	public int getLevel() {
		return level;
	}

	//Abstract method to get bounding box of slide item
	public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);

	//Abstract method to draw slide item
	public abstract void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer);
}