package jabberpoint;

import jabberpoint.accessor.Accessor;
import jabberpoint.accessor.XMLAccessor;
import jabberpoint.slide.Style;
import jabberpoint.slideViewer.SlideViewerFrame;

import javax.swing.*;
import java.io.IOException;

/**
 * JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class JabberPoint
{

    // The main program
    public static void main(String[] argv)
    {
        // Create styles
        Style.createStyles();
        // Create new presentation object
        Presentation presentation = new Presentation();
        // Create and display main frame of presentation
        new SlideViewerFrame("Jabberpoint 1.6 - OU version", presentation);
        try
        {
            if (argv.length == 0)
            { // a demo presentation
                Accessor.getDemoAccessor().loadFile(presentation, "");
            } else
            {
                new XMLAccessor().loadFile(presentation, argv[0]);
            }
            // Set the slide number to start from beginning
            presentation.setSlideNumber(0);
        } catch (IOException ex)
        {
            // Display error message if IO error occurs during loading
            JOptionPane.showMessageDialog(null, "IO Error: " + ex, "Jabberpoint Error ", JOptionPane.ERROR_MESSAGE);
        }
    }
}
