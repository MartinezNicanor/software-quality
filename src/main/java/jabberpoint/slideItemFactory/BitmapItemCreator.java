package jabberpoint.slideItemFactory;

import jabberpoint.BitmapItem;
import jabberpoint.SlideItem;

public class BitmapItemCreator implements SlideItemCreator {
    @Override
    public BitmapItem createSlideItem(int level, String title) {
        return new BitmapItem(level, title);
    }

    @Override
    public SlideItem createSlideItem() {
        return new BitmapItem();
    }
}
