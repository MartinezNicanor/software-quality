package jabberpoint.slideItemFactory;

import jabberpoint.SlideItem;

public interface SlideItemCreator
{
    public SlideItem createSlideItem(int level, String string);
    public SlideItem createSlideItem();
}
