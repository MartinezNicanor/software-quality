package jabberpoint.slideViewer;

import jabberpoint.Presentation;
import jabberpoint.slide.Slide;

import javax.swing.*;
import java.awt.*;


/**
 * <p>SlideViewerComponent is a graphical component that can show slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent
{

    private Slide slide; // current slide
    private Font labelFont = null; // font for labels
    private Presentation presentation = null; // the presentation
    private JFrame frame = null;

    public SlideViewerComponent(Presentation pres, JFrame frame)
    {
        setBackground(Color.white);
        presentation = pres;
        labelFont = new Font("Dialog", Font.BOLD, 10);
        this.frame = frame;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    public void update(Presentation presentation, Slide data)
    {
        if (data == null)
        {
            repaint();
            return;
        }
        this.presentation = presentation;
        this.slide = data;
        repaint();
        frame.setTitle(presentation.getTitle());
    }

    // draw the slide
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, getSize().width, getSize().height);
        if (presentation.getSlideNumber() < 0 || slide == null)
        {
            return;
        }
        g.setFont(labelFont);
        g.setColor(Color.black);
        g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " +
                presentation.getSize(), 1100, 20);
        Rectangle area = new Rectangle(0, 20, getWidth(), (getHeight() - 20));
        slide.draw(g, area, this);
    }
}
