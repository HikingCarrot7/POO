package com.game.objects;

import java.awt.Graphics2D;

/**
 *
 * @author Mohammed
 */
public abstract class GameObject
{

    protected double x, y;
    protected double velX, velY;
    protected boolean isFalling;
    protected ObjectId id;

    public GameObject(ObjectId id, double x, double y, double velX, double velY)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.velX = velX;
        this.velY = velY;
    }

    public GameObject(ObjectId id, double x, double y)
    {
        this(id, x, y, 0, 0);
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getVelX()
    {
        return velX;
    }

    public void setVelX(double velX)
    {
        this.velX = velX;
    }

    public double getVelY()
    {
        return velY;
    }

    public void setVelY(double velY)
    {
        this.velY = velY;
    }

    public boolean isIsFalling()
    {
        return isFalling;
    }

    public void setIsFalling(boolean isFalling)
    {
        this.isFalling = isFalling;
    }

    public ObjectId getId()
    {
        return id;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }

    public abstract void render(Graphics2D g);

    public abstract void tick();

}
