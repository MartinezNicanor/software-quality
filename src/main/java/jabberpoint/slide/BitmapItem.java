package jabberpoint.slide;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BitmapItem implements SlideItem
{
    private BufferedImage bufferedImage;
    private String imageName;
    private int level;

    public BitmapItem(int level, String imageName)
    {
        this.level = level;
        this.imageName = imageName;

        try
        {
            this.bufferedImage = ImageIO.read(new File(imageName));
        } catch (IOException e)
        {
            this.bufferedImage = null;
            throw new RuntimeException("File " + imageName + " not found");
        }
    }

    public String getImageName()
    {
        return this.imageName;
    }

    public BufferedImage getBufferedImage()
    {
        return this.bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getLevel()
    {
        return this.level;
    }

    @Override
    // gives bounding box of the image
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle)
    {
        return new Rectangle((int) (myStyle.indent * scale), 0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (myStyle.leading * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale));
    }

    @Override
    // draws the image
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer)
    {
        if (style == null || imageName == null)
        {
            // handle null style or null image
            style = new Style(0, Color.BLACK, 0, 0);
        }

        int width = x + (int) (style.indent * scale);
        int height = y + (int) (style.leading * scale);
        g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale), observer);
    }

    // Get string representation of BitmapItem
    @Override
    public String toString()
    {
        return "BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}
