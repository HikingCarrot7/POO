package com.game.objects;

import com.game.main.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public class Player extends GameObject
{

    private final ArrayList<Integer> KEYS;
    private boolean controlHorizontal = false;

    public Player(ObjectId id, double x, double y, double velX, double velY)
    {
        super(id, x, y, velX, velY);

        KEYS = new ArrayList<>();

    }

    public Player(ObjectId id, double x, double y)
    {
        super(id, x, y);

        KEYS = new ArrayList<>();
    }

    @Override
    public void tick()
    {
        keyTracker();
    }

    @Override
    public void render(Graphics2D g)
    {
        g.setColor(Color.blue);
        g.fillRect((int) x, (int) y, Game.OBJECTSHEIGHTNWIDTH, Game.OBJECTSHEIGHTNWIDTH);

    }

    public void keyTracker()
    {
        x += getVelX();
        y += getVelY();

        if (KEYS.contains(38))
            setVelY(-5);

        if (KEYS.contains(40))
            setVelY(5);

        if (!controlHorizontal && KEYS.contains(39))
        {
            setVelX(5);

            if (KEYS.contains(37))
            {
                setVelX(-5);
                controlHorizontal = false;

            }

        } else if (KEYS.contains(37))
        {
            setVelX(-5);

            controlHorizontal = true;

            if (KEYS.contains(39))
                setVelX(5);

        }

        if (KEYS.isEmpty() || (KEYS.size() == 1 && KEYS.contains(39)))
            controlHorizontal = false;

    }

    public void addKey(Integer key)
    {
        KEYS.add(key);
    }

    public void removeKey(Integer key)
    {
        KEYS.remove(key);
    }

    public ArrayList<Integer> getKeys()
    {
        return KEYS;
    }

}
