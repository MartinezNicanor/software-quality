package jabberpoint.slideItemFactory;

import jabberpoint.SlideItem;
import jabberpoint.TextItem;

public class TextItemCreator implements SlideItemCreator
{
    @Override
    public TextItem createSlideItem(int level, String text)
    {
        return new TextItem(level, text);
    }

    @Override
    public SlideItem createSlideItem()
    {
        return new TextItem();
    }
}
