import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest
{
    private Slide slide;
    private SlideItem item1;
    private TextItem item2;
    private BitmapItem item3;

    @Test
    void testingPipelines()
    {
        this.slide.items.add(item1);
        this.slide.items.add(item2);
        this.slide.items.add(item3);

        assertEquals(slide.items.size(), 3);
    }
}