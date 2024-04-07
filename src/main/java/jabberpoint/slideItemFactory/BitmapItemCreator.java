package jabberpoint.slideItemFactory;

import jabberpoint.BitmapItem;

public class BitmapItemCreator implements SlideItemCreator
{
    @Override
    public BitmapItem createSlideItem(int level, String title)
    {
        return new BitmapItem(level, title);
    }
}
