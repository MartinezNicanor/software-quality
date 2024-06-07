package jabberpoint.slide;

import java.awt.*;

public class Style
{
    private static Style[] styles;
    public int indent;
    public Color color;
    public Font font;
    public int fontSize;
    public int leading;

    // Constructor
    public Style(int indent, Color color, int points, int leading)
    {
        this.indent = indent;
        this.color = color;
        font = new Font("Helvetica", Font.BOLD, fontSize = points); // Create font
        this.leading = leading;
    }

    // Getters and setters
    public static Style[] getStyles()
    {
        return styles;
    }

    public static void setStyles(Style[] styles)
    {
        Style.styles = styles;
    }

    // Method to create fixed styles
    public static void createStyles()
    {
        styles = new Style[5];
        styles[0] = new Style(0, Color.red, 48, 20);    // Style for item-level 0
        styles[1] = new Style(20, Color.blue, 40, 10);  // Style for item-level 1
        styles[2] = new Style(50, Color.black, 36, 10); // Style for item-level 2
        styles[3] = new Style(70, Color.black, 30, 10); // Style for item-level 3
        styles[4] = new Style(90, Color.black, 24, 10); // Style for item-level 4
    }

    // Method to get style based on level
    public static Style getStyle(int level)
    {
        if (level >= styles.length)
        {
            level = styles.length - 1;
        }
        return styles[level];
    }

    public int getIndent()
    {
        return indent;
    }

    public void setIndent(int indent)
    {
        this.indent = indent;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public Font getFont()
    {
        return font;
    }

    public void setFont(Font font)
    {
        this.font = font;
    }

    public int getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(int fontSize)
    {
        this.fontSize = fontSize;
    }

    public int getLeading()
    {
        return leading;
    }

    public void setLeading(int leading)
    {
        this.leading = leading;
    }

    // String representation of Style object
    public String toString()
    {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }

    // Get font with scaling
    public Font getFont(float scale)
    {
        return font.deriveFont(fontSize * scale);
    }
}
