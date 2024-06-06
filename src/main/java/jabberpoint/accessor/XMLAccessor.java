package jabberpoint.accessor;

import jabberpoint.Presentation;
import jabberpoint.slide.BitmapItem;
import jabberpoint.slide.Slide;
import jabberpoint.slide.SlideItem;
import jabberpoint.slide.TextItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class XMLAccessor extends Accessor
{
    // Constants for XML tags and declarations
    private static final String XML_DECLARATION = "<?xml version=\"1.0\"?>";
    private static final String DOCTYPE = "<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">";
    private static final String PRESENTATION_TAG = "presentation";
    private static final String SHOWTITLE_TAG = "showtitle";
    private static final String SLIDE_TAG = "slide";
    private static final String TITLE_TAG = "title";
    private static final String ITEM_TAG = "item";

    @Override
    public void loadFile(Presentation presentation, String filename) throws IOException
    {
        try
        {
            Document document = parseXmlFile(filename);
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, SHOWTITLE_TAG));
            loadSlides(presentation, doc);
        } catch (SAXException | ParserConfigurationException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private Document parseXmlFile(String filename) throws SAXException, IOException, ParserConfigurationException
    {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(filename));
    }

    private void loadSlides(Presentation presentation, Element doc)
    {
        NodeList slides = doc.getElementsByTagName(SLIDE_TAG);
        for (int slideNumber = 0; slideNumber < slides.getLength(); slideNumber++)
        {
            Element xmlSlide = (Element) slides.item(slideNumber);
            Slide slide = new Slide();
            slide.setTitle(getTitle(xmlSlide, TITLE_TAG));
            presentation.append(slide);
            loadSlideItems(slide, xmlSlide);
        }
    }

    private void loadSlideItems(Slide slide, Element xmlSlide)
    {
        NodeList slideItems = xmlSlide.getElementsByTagName(ITEM_TAG);
        for (int itemNumber = 0; itemNumber < slideItems.getLength(); itemNumber++)
        {
            Element item = (Element) slideItems.item(itemNumber);
            loadSlideItem(slide, item);
        }
    }

    // Loads a slide item from XML element and adds it to slide
    protected void loadSlideItem(Slide slide, Element item)
    {
        int level = parseLevel(item);
        String type = item.getAttribute("kind");

        if ("text".equals(type))
        {
            slide.addTextItem(level, item.getTextContent());
        } else if ("image".equals(type))
        {
            slide.addBitmapItem(level, item.getTextContent());
        } else
        {
            System.err.println("Unknown Element type");
        }
    }

    private int parseLevel(Element item)
    {
        String textLevel = item.getAttribute("level");
        try
        {
            return Integer.parseInt(textLevel);
        } catch (NumberFormatException e)
        {
            System.err.println("Number Format Exception");
            return 1;
        }
    }

    @Override
    public void saveFile(Presentation presentation, String filename) throws IOException
    {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename)))
        {
            writeXml(out, presentation);
        }
    }

    private void writeXml(PrintWriter out, Presentation presentation)
    {
        out.println(XML_DECLARATION);
        out.println(DOCTYPE);
        out.println("<" + PRESENTATION_TAG + ">");
        writeShowTitle(out, presentation);
        writeSlides(out, presentation);
        out.println("</" + PRESENTATION_TAG + ">");
    }

    private void writeShowTitle(PrintWriter out, Presentation presentation)
    {
        out.print("<" + SHOWTITLE_TAG + ">");
        out.print(presentation.getTitle());
        out.println("</" + SHOWTITLE_TAG + ">");
    }

    private void writeSlides(PrintWriter out, Presentation presentation)
    {
        for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++)
        {
            Slide slide = presentation.getSlide(slideNumber);
            out.println("<" + SLIDE_TAG + ">");
            out.println("<" + TITLE_TAG + ">" + slide.getTitle() + "</" + TITLE_TAG + ">");
            writeSlideItems(out, slide);
            out.println("</" + SLIDE_TAG + ">");
        }
    }

    private void writeSlideItems(PrintWriter out, Slide slide)
    {
        Vector<SlideItem> slideItems = slide.getSlideItems();
        for (SlideItem slideItem : slideItems)
        {
            out.print("<" + ITEM_TAG + " kind=");
            if (slideItem instanceof TextItem)
            {
                out.print("\"text\" level=\"" + slideItem.getLevel() + "\">");
                out.print(((TextItem) slideItem).getText());
            } else if (slideItem instanceof BitmapItem)
            {
                out.print("\"image\" level=\"" + slideItem.getLevel() + "\">");
                out.print(((BitmapItem) slideItem).getImageName());
            } else
            {
                System.out.println("Ignoring " + slideItem);
            }
            out.println("</" + ITEM_TAG + ">");
        }
    }

    private String getTitle(Element element, String tagName)
    {
        NodeList titles = element.getElementsByTagName(tagName);
        return titles.item(0).getTextContent();
    }
}
