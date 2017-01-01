package gui;

import model.Position;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * Created by Sidi on 11/6/2016.
 */
public class ImageBasedGuiComponent implements GUIComponent {
    private final Position centerPoint;
    private final int width;
    private final int height;
    private final ImageObserver imageObserver;
    private final Image image;

    public ImageBasedGuiComponent(Position centerPoint, int width, int height, ImageObserver imageObserver, Image image) {
        this.centerPoint = centerPoint;
        this.width = width;
        this.height = height;
        this.imageObserver = imageObserver;
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, (int) centerPoint.getH(), (int) centerPoint.getV(), width, height, imageObserver);
    }
}
