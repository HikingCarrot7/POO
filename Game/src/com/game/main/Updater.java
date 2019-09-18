package com.game.main;

/**
 *
 * @author Mohammed
 */
public class Updater implements Runnable
{

    private final Game GAME;
    private final Window WINDOW;

    public Updater(Game game, Window window)
    {
        this.GAME = game;
        this.WINDOW = window;

    }

    public void start()
    {
        new Thread(this).start();
    }

    @Override
    public void run()
    {
        GAME.init();

        long lastTime = System.nanoTime();
        final double amountOfThicks = 60.0;
        double ns = 1000000000 / amountOfThicks;
        double delta = 0;

        int update = 0;
        int frames = 0;
        Long timer = System.currentTimeMillis();

        while (true)
        {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1)
            {
                GAME.tick();
                update++;
                delta--;

            }

            GAME.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                WINDOW.setTitle(String.format("FPS: %d, TICKS: %d", frames, update));
                timer += 1000;
                update = 0;
                frames = 0;

            }

        }

    }

}
