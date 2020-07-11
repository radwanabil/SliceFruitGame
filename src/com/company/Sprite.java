package com.company;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {

    private Image image;
    private Image image1;
    private Image image2;
    double posX;
    double posY;
    private double width;
    private double height;
    private double verticalOffset;
    private int direction;
    private double speed;
    int slice;

    public Sprite(Image image,int min,int max)
    {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        direction = -1;
        speed=rand(min,max);
        verticalOffset = rand(20,100);
    }
    public double rand(int min, int max) {
        return (Math.random() * max + min);
    }

    public void setSpeed(int min, int max) {
        this.speed = rand(min,max);
    }

    private Rectangle2D getBoundry() {
        return new Rectangle2D(posX,posY,width,height);
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public Image getImage()
    {
        return this.image;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }

   /* public void getPosY(double posY) {
        this.posY = posY;
    }
    public void getPosX(double posX) {
        this.posX = posX;
    }*/

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public boolean intersects(Sprite sprite) {
        return this.getBoundry().intersects(sprite.getBoundry());
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image,posX,posY);
    }


    public void updateLocation() {
        double newPosY = this.posY -this.speed;
        if(direction == -1)
        {
            if (newPosY < verticalOffset||slice ==1) {
                direction = 1;
            }
            else {
                this.posY -= this.speed;
            }
        }
        else if(direction == 1) {
            this.posY += this.speed;
        }

    }
    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public Boolean contains (double clickedX, double clickedY) {
        return this.getBoundry().contains(clickedX, clickedY);
    }
}
