package com.game.graphics;

import com.game.main.Game;
import com.game.objects.Block;
import com.game.objects.ObjectId;
import com.game.objects.Rock;
import com.game.renderhandler.RenderHandler;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mohammed
 */
public class MapGenerator
{

    private final BufferedImageLoader bufferedImageLoader;
    private final RenderHandler renderHandler;

    public MapGenerator(RenderHandler renderHandler)
    {
        bufferedImageLoader = new BufferedImageLoader();
        this.renderHandler = renderHandler;

    }

    public void createMap()
    {
        loadImageLevel(bufferedImageLoader.loadImage("/com/res/map/map.png"));
    }

    public void loadImageLevel(BufferedImage image)
    {
        for (int j = 0; j < image.getWidth(); j++)
            for (int i = 0; i < image.getHeight(); i++)
            {
                int pixel = image.getRGB(i, j);

                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255 && green == 255 && blue == 0)
                    renderHandler.addObject(new Rock(ObjectId.Rock, i * Game.OBJECTSHEIGHTNWIDTH, j * Game.OBJECTSHEIGHTNWIDTH, 0, 1));

                else if (red == 0 && green == 255 && blue == 0)
                    renderHandler.addObject(new Rock(ObjectId.Rock, i * Game.OBJECTSHEIGHTNWIDTH, j * Game.OBJECTSHEIGHTNWIDTH, 0, 0));

                else if (red == 0 && green == 0 && blue == 0)
                    renderHandler.addObject(new Block(ObjectId.Block, i * Game.OBJECTSHEIGHTNWIDTH, j * Game.OBJECTSHEIGHTNWIDTH));

            }

    }

}
