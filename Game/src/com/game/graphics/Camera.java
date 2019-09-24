package com.game.graphics;

import com.game.main.Game;
import com.game.objects.GameObject;

/**
 *
 * @author Mohammed
 */
public class Camera
{

    private double x, y;

    public Camera(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject player)
    {

        double xTarg = (-player.getX() + Game.ANCHO / 2);
        double yTarg = (-player.getY() + Game.ALTO / 2);

        x += (xTarg - x) * (0.05);
        y += (yTarg - y) * (0.05);

        if (x >= 0)
            x = 0;

        if (y >= 0)
            y = 0;

        if (x - Game.ANCHO <= -32 * 64)
            x = -32 * 64 + Game.ANCHO;

        if (y - Game.ALTO <= -32 * 64)
            y = -32 * 64 + Game.ALTO;

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

}
