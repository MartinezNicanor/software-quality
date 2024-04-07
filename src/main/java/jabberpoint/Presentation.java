package jabberpoint;

import jabberpoint.slideViewer.SlideViewerComponent;

import java.util.ArrayList;

public class Presentation
{
    private String showTitle;
    private ArrayList<Slide> showList = null;
    private int currentSlideNumber = 0;
    private SlideViewerComponent slideViewComponent = null;

    // Constructor
    public Presentation()
    {
        slideViewComponent = null;
        clear();
    }

    // Constructs new Presentation with the specified SlideViewerComponent
    public Presentation(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
        clear();
    }

    // Getters and Setters
    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent)
    {
        this.slideViewComponent = slideViewerComponent;
    }

    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    public void setSlideNumber(int number)
    {
        currentSlideNumber = number;
        if (slideViewComponent != null)
        {
            slideViewComponent.update(this, getCurrentSlide());
        }
    }

    // Moves to the previous slide, if not at the beginning of the presentation
    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    // Moves to the next slide, if not at the end of the presentation
    public void nextSlide()
    {
        if (currentSlideNumber < (showList.size() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    // Clears the presentation
    public void clear()
    {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    // Appends slide to presentation.
    public void append(Slide slide)
    {
        showList.add(slide);
    }

    // Gets slide with the specified slide number
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }
        return showList.get(number);
    }

    // Gets current slide
    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    // Exits presentation
    public void exit(int n)
    {
        System.exit(n);
    }
}
