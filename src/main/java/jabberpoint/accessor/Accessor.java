package jabberpoint.accessor;

import jabberpoint.Presentation;

import java.io.IOException;

public abstract class Accessor
{
    private static final String DEMO_NAME = "Demonstration presentation"; // Default name for demo presentation
    private static final String DEFAULT_EXTENSION = ".xml"; // Default file extension

    // Returns instance of DemoPresentation
    public static Accessor getDemoAccessor()
    {
        return new DemoPresentation();
    }

    //Constructor
    public Accessor()
    {
    }

    // Abstract method to load data for presentation
    abstract public void loadFile(Presentation p, String fn) throws IOException;

    // Abstract method to save data for presentation
    abstract public void saveFile(Presentation p, String fn) throws IOException;
}