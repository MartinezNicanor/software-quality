package jabberpoint.command;

import jabberpoint.Accessor;
import jabberpoint.Presentation;
import jabberpoint.XMLAccessor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SavePresentationCommand extends Command {
    private Frame frame;

    public SavePresentationCommand(Presentation presentation, Frame frame) {
        super(presentation);
        this.frame = frame;
    }

    @Override
    public void execute() {
        Accessor xmlAccessor = new XMLAccessor();
        try {
            xmlAccessor.saveFile(presentation, "dump.xml");
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(frame, "IO Exception: " + exc, "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
