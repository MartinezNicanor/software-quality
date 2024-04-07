package jabberpoint.slideItemFactory;

import jabberpoint.TextItem;

public class TextItemCreator implements SlideItemCreator
{
    @Override
    public TextItem createSlideItem(int level, String text)
    {
        return new TextItem(level, text);
    }
}
