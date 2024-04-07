package jabberpoint;

/**
 * A built in demo-presentation
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

class DemoPresentation extends Accessor
{
    //Loads demo presentation into provided Presentation object
    public void loadFile(Presentation presentation, String unusedFilename)
    {
        // Create and set title for presentation
        presentation.setTitle("Demo Presentation");
        // Create slides and add content to them
        Slide slide;

        // Slide 1
        slide = new Slide();
        slide.setTitle("JabberPoint");
        slide.addTextItem(1, "The Java Presentation Tool");
        slide.addTextItem(2, "Copyright (c) 1996-2000: Ian Darwin");
        slide.addTextItem(2, "Copyright (c) 2000-now:");
        slide.addTextItem(2, "Gert Florijn andn Sylvia Stuurman");
        slide.addTextItem(4, "Starting JabberPoint without a filename");
        slide.addTextItem(4, "shows this presentation");
        slide.addTextItem(1, "Navigate:");
        slide.addTextItem(3, "Next slide: PgDn or Enter");
        slide.addTextItem(3, "Previous slide: PgUp or up-arrow");
        slide.addTextItem(3, "Quit: q or Q");
        presentation.append(slide);

        // Slide 2
        slide = new Slide();
        slide.setTitle("Demonstration of levels and stijlen");
        slide.addTextItem(1, "Level 1");
        slide.addTextItem(2, "Level 2");
        slide.addTextItem(1, "Again level 1");
        slide.addTextItem(1, "Level 1 has style number 1");
        slide.addTextItem(2, "Level 2 has style number  2");
        slide.addTextItem(3, "This is how level 3 looks like");
        slide.addTextItem(4, "And this is level 4");
        presentation.append(slide);

        // Slide 3
        slide = new Slide();
        slide.setTitle("The third slide");
        slide.addTextItem(1, "To open a new presentation,");
        slide.addTextItem(2, "use File->Open from the menu.");
        slide.addTextItem(1, " ");
        slide.addTextItem(1, "This is the end of the presentation.");
        slide.addBitmapItem(1, "JabberPoint.gif");
        presentation.append(slide);
    }

    // Method is not implemented for demo presentation
    public void saveFile(Presentation presentation, String unusedFilename)
    {
        // Throws IllegalStateException since saving is not supported for demo presentation
        throw new IllegalStateException("Save As->Demo! called");
    }
}