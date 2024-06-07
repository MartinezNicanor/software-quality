package jabberpoint.slide;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>A text item.</p>
 * <p>A TextItem has drawing functionality.</p>
 *
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class TextItem implements SlideItem
{
    private String text;
    private int level;

    // Constructor
    public TextItem(int level, String string)
    {
        this.level = level;
        this.text = string;
    }

    // Empty constructor
    public TextItem()
    {
    }

    // Get text
    public String getText()
    {
        return this.text;
    }

    // Get level
    public int getLevel()
    {
        return this.level;
    }

    // Get attributed string
    public AttributedString getAttributedString(Style style, float scale)
    {
        AttributedString attrStr = new AttributedString(getText());
        attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());
        return attrStr;
    }

    @Override
    // Get bounding box of the item
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle)
    {
        List<TextLayout> layouts = getLayouts(g, myStyle, scale);
        return calculateBoundingBox(layouts, myStyle, scale);
    }

    private Rectangle calculateBoundingBox(List<TextLayout> layouts, Style myStyle, float scale)
    {
        int xsize = 0;
        int ysize = (int) (myStyle.leading * scale);
        for (TextLayout layout : layouts)
        {
            Rectangle2D bounds = layout.getBounds();
            xsize = Math.max(xsize, (int) bounds.getWidth());
            ysize += bounds.getHeight() > 0 ? bounds.getHeight() : 0;
            ysize += layout.getLeading() + layout.getDescent();
        }
        return new Rectangle((int) (myStyle.indent * scale), 0, xsize, ysize);
    }

    @Override
    // Draw the item
    public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o)
    {
        if (text == null || text.isEmpty())
        {
            return;
        }
        List<TextLayout> layouts = getLayouts(g, myStyle, scale);
        drawTextLayouts(layouts, x, y, scale, g, myStyle);
    }

    private void drawTextLayouts(List<TextLayout> layouts, int x, int y, float scale, Graphics g, Style myStyle)
    {
        Point pen = new Point(x + (int) (myStyle.indent * scale), y + (int) (myStyle.leading * scale));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(myStyle.color);

        for (TextLayout layout : layouts)
        {
            pen.y += layout.getAscent();
            layout.draw(g2d, pen.x, pen.y);
            pen.y += layout.getDescent();
        }
    }

    private List<TextLayout> getLayouts(Graphics g, Style s, float scale)
    {
        List<TextLayout> layouts = new ArrayList<>();
        AttributedString attrStr = getAttributedString(s, scale);
        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext frc = g2d.getFontRenderContext();
        LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);
        float wrappingWidth = (Slide.WIDTH - s.indent) * scale;

        while (measurer.getPosition() < getText().length())
        {
            layouts.add(measurer.nextLayout(wrappingWidth));
        }
        return layouts;
    }

    @Override
    public String toString()
    {
        return "TextItem[" + getLevel() + "," + getText() + "]";
    }
}
