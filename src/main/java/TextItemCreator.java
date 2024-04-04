public class TextItemCreator implements SlideItemCreator
{
    @Override
    public TextItem createItem(int level, String text)
    {
        return new TextItem(level, text);
    }
}
