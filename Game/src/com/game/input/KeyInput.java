package com.game.input;

import com.game.objects.GameObject;
import com.game.objects.ObjectId;
import com.game.objects.Player;
import com.game.renderhandler.RenderHandler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mohammed
 */
public class KeyInput extends KeyAdapter
{

    private Player player;

    public KeyInput(RenderHandler renderHandler)
    {
        for (GameObject object : renderHandler.getObjects())
            if (object.getId().equals(ObjectId.Player))
            {
                player = (Player) object;
                break;
            }

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Integer key = e.getKeyCode();

        if (key.equals(KeyEvent.VK_UP))
            if (!player.getKeys().contains(KeyEvent.VK_UP))
                player.addKey(KeyEvent.VK_UP);

        if (key.equals(KeyEvent.VK_DOWN))
            if (!player.getKeys().contains(KeyEvent.VK_DOWN))
                player.addKey(KeyEvent.VK_DOWN);

        if (key.equals(KeyEvent.VK_LEFT))
            if (!player.getKeys().contains(KeyEvent.VK_LEFT))
                player.addKey(KeyEvent.VK_LEFT);

        if (key.equals(KeyEvent.VK_RIGHT))
            if (!player.getKeys().contains(KeyEvent.VK_RIGHT))
                player.addKey(KeyEvent.VK_RIGHT);

        if (key.equals(KeyEvent.VK_ESCAPE))
            System.exit(1);

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        Integer key = e.getKeyCode();

        if (key.equals(KeyEvent.VK_UP))
        {
            player.removeKey(KeyEvent.VK_UP);
            player.setVelY(0);
        }

        if (key.equals(KeyEvent.VK_DOWN))
        {
            player.removeKey(KeyEvent.VK_DOWN);
            player.setVelY(0);
        }

        if (key.equals(KeyEvent.VK_LEFT))
        {
            player.removeKey(KeyEvent.VK_LEFT);
            player.setVelX(0);
        }

        if (key.equals(KeyEvent.VK_RIGHT))
        {
            player.removeKey(KeyEvent.VK_RIGHT);
            player.setVelX(0);
        }

    }

}
