package controlador;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Mohammed
 */
public class Draw implements Runnable
{

    private Canvas canvas;
    int x, y, velX, velY;

    public Draw(Canvas canvas)
    {
        this.canvas = canvas;

        new Thread(this).start();

        x = 50;
        y = 50;
        velX = 7;
        velY = 9;

    }

    public void draw()
    {
        GraphicsContext g2d = canvas.getGraphicsContext2D();

        g2d.drawImage(new Image("white.jpg"), 0, 0);
        g2d.fillOval(x += velX, y += velY, 50, 50);

        if (x > 400 || x < 0)
            velX *= -1;

        if (y > 400 || y < 0)
            velY *= -1;

    }

    @Override
    public void run()
    {
        while (!false)
            try
            {
                Thread.sleep(50);

                draw();

            } catch (InterruptedException ex)
            {
                System.out.println(ex.getMessage());
            }
    }

}
