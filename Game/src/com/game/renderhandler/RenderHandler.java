package com.game.renderhandler;

import com.game.objects.GameObject;
import com.game.objects.ObjectId;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public class RenderHandler
{

    private ArrayList<GameObject> objects;

    public RenderHandler()
    {
        objects = new ArrayList<>();
    }

    public void render(Graphics2D g)
    {
        objects.stream().forEach((object) ->
        {
            object.render(g);

        });

    }

    public void tick()
    {
        objects.stream().forEach((object) ->
        {
            object.tick();

        });

    }

    public void addObject(GameObject object)
    {
        objects.add(object);
    }

    public void setObjects(ArrayList<GameObject> objects)
    {
        this.objects = objects;
    }

    public ArrayList<GameObject> getObjects()
    {
        return objects;
    }

    public GameObject getPlayer()
    {
        for (GameObject object : objects)
            if (object.getId().equals(ObjectId.Player))
                return object;

        return null;

    }

}
