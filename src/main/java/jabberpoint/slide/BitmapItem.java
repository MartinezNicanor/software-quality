package jabberpoint.slide;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class BitmapItem implements SlideItem {
    BufferedImage bufferedImage;
    private String imageName;
    private int level;

    public BitmapItem(int level, String imageName) {
        this.level = level;
        this.imageName = imageName;
        this.bufferedImage = bufferedImage;
    }

    public String getImageName() {
        return this.imageName;
    }

    public BufferedImage getBufferedImage() {
        return this.bufferedImage;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
        if (bufferedImage == null) {
            return new Rectangle();
        }
        return new Rectangle((int) (myStyle.indent * scale), 0,
                (int) (bufferedImage.getWidth(observer) * scale),
                ((int) (myStyle.leading * scale)) +
                        (int) (bufferedImage.getHeight(observer) * scale));
    }

    @Override
    public void draw(int x, int y, float scale, Graphics g, Style style, ImageObserver observer) {
        if (bufferedImage == null || style == null) {
            return;
        }

        int width = x + (int) (style.indent * scale);
        int height = y + (int) (style.leading * scale);
        g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
                (int) (bufferedImage.getHeight(observer) * scale), observer);
    }

    @Override
    public String toString() {
        return "BitmapItem[" + getLevel() + "," + imageName + "]";
    }
}