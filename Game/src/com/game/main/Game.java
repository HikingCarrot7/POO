package com.game.main;

import com.game.graphics.Camera;
import com.game.graphics.MapGenerator;
import com.game.input.KeyInput;
import com.game.objects.ObjectId;
import com.game.objects.Player;
import com.game.renderhandler.RenderHandler;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Mohammed
 */
public class Game extends Canvas
{

    public static final int ALTO = 800, ANCHO = 1000, OBJECTSHEIGHTNWIDTH = 50;

    private RenderHandler renderHandler;
    private Camera camera;

    public static void main(String[] args)
    {
        new Window(ANCHO, ALTO, "", new Game()).iniciarVentana();
    }

    public void init()
    {
        createBufferStrategy(3);

        camera = new Camera(0, 0);
        renderHandler = new RenderHandler();
        new MapGenerator(renderHandler).createMap();
        renderHandler.addObject(new Player(ObjectId.Player, 100, 100));
        addKeyListener(new KeyInput(renderHandler));
        requestFocus();

    }

    public void tick()
    {
        renderHandler.tick();
        camera.tick(renderHandler.getPlayer());
    }

    public void render()
    {
        BufferStrategy bs = getBufferStrategy();

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, ANCHO, ALTO);

        g.translate((int) camera.getX(), (int) camera.getY());

        renderHandler.render(g);

        g.translate((int) -camera.getX(), (int) -camera.getY());

        g.dispose();
        bs.show();

    }

}
