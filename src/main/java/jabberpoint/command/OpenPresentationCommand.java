package jabberpoint.command;

import jabberpoint.Accessor;
import jabberpoint.Presentation;
import jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Command class to handle opening presentation from a file
public class OpenPresentationCommand extends Command {
    // Reference to frame associated with presentation
    private Frame frame;

    // Constructor
    public OpenPresentationCommand(Presentation presentation, Frame frame) {
        // Call superclass constructor to initialize presentation reference
        super(presentation);
        // Initialize frame reference
        this.frame = frame;
    }

    // Executes command
    @Override
    public void execute() {
        // Clear current presentation
        presentation.clear();

        // Create instance of XMLAccessor to load presentation from XML
        Accessor xmlAccessor = new XMLAccessor();

        try {
            // Load presentation from XML file "test.xml"
            xmlAccessor.loadFile(presentation, "test.xml");
            // Set the slide number to the first slide (0-based indexing)
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            // If IOException occurs during loading, show an error message dialog
            JOptionPane.showMessageDialog(frame, "IO Exception: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
        }

        // Repaint frame to reflect changes
        this.frame.repaint();
    }
}