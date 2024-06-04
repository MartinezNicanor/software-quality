package jabberpoint.controllers.command;

import jabberpoint.Presentation;
import jabberpoint.slideViewer.SlideViewerComponent;

import javax.swing.*;

public class GoToSlideCommand extends Command {

    public GoToSlideCommand(Presentation presentation) {
        super(presentation);
    }

    @Override
    public void execute() {
        SlideViewerComponent parent = this.presentation.getSlideViewComponent();
        String pageNumberStr = JOptionPane.showInputDialog((Object) "Page number?");
        int pageNumber = 0;

        try {
            pageNumber = Integer.parseInt(pageNumberStr);
        } catch (NumberFormatException  e) {
            JOptionPane.showMessageDialog(
                    parent, "A number must be provided");
            return;
        }

        if (pageNumber > this.presentation.getSize() || pageNumber <= 0) {
            JOptionPane.showMessageDialog(
                    parent, "Provide a valid page number");
            return;
        }

        this.presentation.setSlideNumber(pageNumber - 1);
    }
}
