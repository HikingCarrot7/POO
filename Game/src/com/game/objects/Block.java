package com.game.objects;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Mohammed
 */
public class Block extends GameObject
{

    public Block(ObjectId id, double x, double y)
    {
        super(id, x, y);
    }

    @Override
    public void render(Graphics2D g)
    {
        g.setColor(Color.white);
        g.drawRect((int) x, (int) y, Game.OBJECTSHEIGHTNWIDTH, Game.OBJECTSHEIGHTNWIDTH);

    }

    @Override
    public void tick()
    {

    }

}
