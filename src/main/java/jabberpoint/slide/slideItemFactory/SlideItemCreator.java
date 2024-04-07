package jabberpoint.slide.slideItemFactory;

import jabberpoint.slide.SlideItem;

public interface SlideItemCreator
{
    public SlideItem createSlideItem(int level, String string);
}
