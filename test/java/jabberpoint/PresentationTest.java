package jabberpoint;

import jabberpoint.slide.Slide;
import jabberpoint.slideViewer.SlideViewerComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PresentationTest
{

    private Presentation presentation;
    private SlideViewerComponent slideViewerComponent;

    @BeforeEach
    void setUp()
    {
        slideViewerComponent = mock(SlideViewerComponent.class);
        presentation = new Presentation(slideViewerComponent);
    }

    @Test
    void defaultConstructor_NullSlideViewerComponent_MinusOneSlideNumber_ZeroSize()
    {
        Presentation defaultPresentation = new Presentation();
        assertNotNull(defaultPresentation);
        assertNull(defaultPresentation.getSlideViewComponent());
        assertEquals(-1, defaultPresentation.getSlideNumber());
        assertEquals(0, defaultPresentation.getSize());
    }

    @Test
    void constructorWithSlideViewerComponent_NonNullSlideViewerComponent_MinusOneSlideNumber_ZeroSize()
    {
        assertNotNull(presentation);
        assertEquals(slideViewerComponent, presentation.getSlideViewComponent());
        assertEquals(-1, presentation.getSlideNumber());
        assertEquals(0, presentation.getSize());
    }

    @Test
    void getTitle_ReturnsCorrectTitle()
    {
        presentation.setTitle("Test Presentation");
        assertEquals("Test Presentation", presentation.getTitle());
    }

    @Test
    void setTitle_NewTitleSet()
    {
        presentation.setTitle("New Title");
        assertEquals("New Title", presentation.getTitle());
    }

    @Test
    void setSlideViewComponent_NewSlideViewerComponentSet()
    {
        SlideViewerComponent newSlideViewerComponent = mock(SlideViewerComponent.class);
        presentation.setShowView(newSlideViewerComponent);
        assertEquals(newSlideViewerComponent, presentation.getSlideViewComponent());
    }

    @Test
    void appendSlide_SlideAppended_SizeIncreased()
    {
        Slide slide = mock(Slide.class);
        presentation.append(slide);
        assertEquals(1, presentation.getSize());
        assertEquals(slide, presentation.getSlide(0));
    }

    @Test
    void getSlideNumber_ReturnsMinusOne()
    {
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void setSlideNumber_SlideNumberSet_SlideViewerComponentUpdated()
    {
        Slide slide1 = mock(Slide.class);
        Slide slide2 = mock(Slide.class);
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.setSlideNumber(1);
        assertEquals(1, presentation.getSlideNumber());
        verify(slideViewerComponent).update(presentation, slide2);
    }

    @Test
    void prevSlide_SlideNumberDecreased_SlideViewerComponentUpdated()
    {
        Slide slide1 = mock(Slide.class);
        Slide slide2 = mock(Slide.class);
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.setSlideNumber(1);
        presentation.prevSlide();

        assertEquals(0, presentation.getSlideNumber());
        verify(slideViewerComponent).update(presentation, slide1);
    }

    @Test
    void prevSlideAtBeginning_SlideNumberUnchanged()
    {
        presentation.setSlideNumber(0);
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void nextSlide_SlideNumberIncreased()
    {
        Slide slide1 = mock(Slide.class);
        Slide slide2 = mock(Slide.class);
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.nextSlide();
        assertEquals(0, presentation.getSlideNumber());
    }

    @Test
    void nextSlideAtEnd_SlideNumberUnchanged_SlideViewerComponentUpdated()
    {
        Slide slide1 = mock(Slide.class);
        presentation.append(slide1);

        presentation.setSlideNumber(0);
        presentation.nextSlide();
        assertEquals(0, presentation.getSlideNumber());
        verify(slideViewerComponent).update(presentation, slide1);
    }

    @Test
    void clear_AllSlidesRemoved_SlideNumberMinusOne()
    {
        Slide slide = mock(Slide.class);
        presentation.append(slide);
        assertEquals(1, presentation.getSize());

        presentation.clear();
        assertEquals(0, presentation.getSize());
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    void getSlide_SlideReturnedAtIndex()
    {
        Slide slide1 = mock(Slide.class);
        Slide slide2 = mock(Slide.class);
        presentation.append(slide1);
        presentation.append(slide2);

        assertEquals(slide1, presentation.getSlide(0));
        assertEquals(slide2, presentation.getSlide(1));
    }

    @Test
    void getSlideInvalidIndex_NullReturned()
    {
        assertNull(presentation.getSlide(-1));
        assertNull(presentation.getSlide(1));
    }

    @Test
    void getCurrentSlide_CurrentSlideReturned()
    {
        Slide slide1 = mock(Slide.class);
        Slide slide2 = mock(Slide.class);
        presentation.append(slide1);
        presentation.append(slide2);

        presentation.setSlideNumber(1);
        assertEquals(slide2, presentation.getCurrentSlide());
    }
}
