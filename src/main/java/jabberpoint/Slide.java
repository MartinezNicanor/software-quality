package jabberpoint;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide {
	public final static int WIDTH = 1200; // Default width of slide
	public final static int HEIGHT = 800; // Default height of slide

	protected String title;
	protected Vector<SlideItem> items;

	// Constructor
	public Slide() {
		items = new Vector<SlideItem>();
	}

	// Method to append a slide item to slide
	public void append(SlideItem anItem) {
		items.addElement(anItem);
	}

	// Method to get the title the slide
	public String getTitle() {
		return title;
	}

	// Method to set the title of slide
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	// Method to append text item to slide with given level and message
	public void append(int level, String message) {
		append(new TextItem(level, message));
	}

	// Method to get slide item at the specified index
	public SlideItem getSlideItem(int number) {
		return (SlideItem) items.elementAt(number);
	}

	// Method to get all slide items in a Vector
	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	// Method to get number of slide items in slide
	public int getSize() {
		return items.size();
	}

	// Method to draw slide
	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
		int y = area.y;

		// Draw the title separately
		SlideItem slideItem = new TextItem(0, getTitle());
		Style style = Style.getStyle(slideItem.getLevel());
		slideItem.draw(area.x, y, scale, g, style, view);
		y += slideItem.getBoundingBox(g, view, scale, style).height;

		// Draw each slide item
		for (int number = 0; number < getSize(); number++) {
			slideItem = (SlideItem) getSlideItems().elementAt(number);
			style = Style.getStyle(slideItem.getLevel());
			slideItem.draw(area.x, y, scale, g, style, view);
			y += slideItem.getBoundingBox(g, view, scale, style).height;
		}
	}

	// method to calculate scale for drawing
	private float getScale(Rectangle area) {
		return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
	}
}