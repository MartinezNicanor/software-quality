public class BitmapItemCreator implements SlideItemCreator
{
    public BitmapItem createItem(int level, String title)
    {
        return new BitmapItem(level, title);
    }
}
