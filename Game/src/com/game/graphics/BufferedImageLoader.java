package com.game.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mohammed
 */
public class BufferedImageLoader
{

    public BufferedImage loadImage(String path)
    {
        try
        {

            BufferedImage loadedImage = ImageIO.read(getClass().getResource(path));

            BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(), loadedImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null);

            return formattedImage;

        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return null;

    }
}
