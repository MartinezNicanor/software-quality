package jabberpoint.command;

import jabberpoint.Accessor;
import jabberpoint.Presentation;
import jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Command class to handle saving presentation to a file
public class SavePresentationCommand extends Command
{
    // Reference to frame associated with presentation
    private Frame frame;

    // Constructor
    public SavePresentationCommand(Presentation presentation, Frame frame)
    {
        // Calls superclass constructor to initialize presentation
        super(presentation);
        // Initializes the frame
        this.frame = frame;
    }

    // Executes command
    @Override
    public void execute()
    {
        // Creates instance of XMLAccessor to save presentation to XML
        Accessor xmlAccessor = new XMLAccessor();

        try
        {
            // Save presentation to XML file "dump.xml"
            xmlAccessor.saveFile(presentation, "dump.xml");
        } catch (IOException exc)
        {
            // If IOException occurs during saving, show an error message dialog
            JOptionPane.showMessageDialog(frame, "IO Exception: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
