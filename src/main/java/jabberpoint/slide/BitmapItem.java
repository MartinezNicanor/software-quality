package jabberpoint.slide;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BitmapItem implements SlideItem {
    private BufferedImage bufferedImage;
    private final String imageName;
    private final int level;

    public BitmapItem(int level, String imageName) {
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

    public String getImageName() {
        return this.imageName;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        if (bufferedImage == null) {
            return new Rectangle((int) (myStyle.getIndent() * scale), 0, 0, 0);
        }
        return new Rectangle((int) (myStyle.getIndent() * scale), 0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (myStyle.getLeading() * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale));
    }


    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
        if (bufferedImage == null || style == null) {
            return;
        }

        int width = x + (int) (style.getIndent() * scale);
        int height = y + (int) (style.getLeading() * scale);
        g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale), observer);
    }

    @Override
    public String toString() {
        return "BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}