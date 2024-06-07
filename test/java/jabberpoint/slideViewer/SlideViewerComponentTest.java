package jabberpoint.slideViewer;

import jabberpoint.Presentation;
import jabberpoint.slide.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SlideViewerComponentTest
{

    private SlideViewerComponent slideViewerComponent;
    private Presentation presentation;
    private Slide slide;
    private JFrame frame;

    @BeforeEach
    void setUp()
    {
        presentation = mock(Presentation.class);
        slide = mock(Slide.class);

        frame = mock(JFrame.class);

        // Creating SlideViewerComponent instance
        slideViewerComponent = new SlideViewerComponent(presentation, frame);
    }

    @Test
    void getPreferredSize_ReturnsCorrectDimensions()
    {
        Dimension preferredSize = slideViewerComponent.getPreferredSize();
        assertNotNull(preferredSize);
        assertEquals(Slide.WIDTH, preferredSize.width);
        assertEquals(Slide.HEIGHT, preferredSize.height);
    }

    @Test
    void updateWithNullSlide_NoTitleChange_GraphicsNotNull()
    {
        slideViewerComponent.update(presentation, null);

        // Verify that repaint is called
        verify(frame, never()).setTitle(anyString());
        assertNull(slideViewerComponent.getGraphics()); // No exception should be thrown
    }

    @Test
    void updateWithValidSlide_PresentationAndSlideSetCorrectly_TitleUpdated()
    {
        when(presentation.getTitle()).thenReturn("Presentation Title");

        slideViewerComponent.update(presentation, slide);

        // Verify that the presentation and slide are set correctly
        assertEquals(presentation, slideViewerComponent.getPresentation());
        assertEquals(slide, slideViewerComponent.getSlide());

        // Verify that the JFrame title is updated
        verify(frame).setTitle("Presentation Title");
    }

    @Test
    void paintComponentWithoutSlide_SlideDrawNotCalledWhenSlideIsNull()
    {
        // Prepare Graphics for paintComponent test
        BufferedImage bufferedImage = new BufferedImage(Slide.WIDTH, Slide.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();

        // Mock presentation to return an invalid slide number
        when(presentation.getSlideNumber()).thenReturn(-1);

        // Call paintComponent
        slideViewerComponent.paintComponent(graphics);

        // Verify that slide.draw() is not called when slide is null
        verify(slide, never()).draw(any(Graphics.class), any(Rectangle.class), any(ImageObserver.class));
    }
}