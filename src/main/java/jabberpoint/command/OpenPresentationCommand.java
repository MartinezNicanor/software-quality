package jabberpoint.command;

import jabberpoint.Accessor;
import jabberpoint.Presentation;
import jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenPresentationCommand extends Command {
    private Frame frame;

    public OpenPresentationCommand(Presentation presentation, Frame frame) {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute() {
        presentation.clear();
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.loadFile(presentation, "test.xml");
            presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(frame, "IO Exception: " + exc, "Load Error", JOptionPane.ERROR_MESSAGE);
        }
        this.frame.repaint();
    }
}
