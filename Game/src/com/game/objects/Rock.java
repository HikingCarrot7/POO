package com.game.objects;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Mohammed
 */
public class Rock extends GameObject
{

    public Rock(ObjectId id, double x, double y, double velX, double velY)
    {
        super(id, x, y, velX, velY);
    }

    public Rock(ObjectId id, double x, double y)
    {
        super(id, x, y);
    }

    @Override
    public void render(Graphics2D g)
    {
        g.setColor(Color.yellow);
        g.fillOval((int) x, (int) y, Game.OBJECTSHEIGHTNWIDTH, Game.OBJECTSHEIGHTNWIDTH);

    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;

    }

}
