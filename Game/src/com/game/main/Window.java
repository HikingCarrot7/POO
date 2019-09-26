package com.game.main;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Mohammed
 */
public class Window extends JFrame
{

    private final int W, H;
    private final String TITLE;
    private final Game GAME;

    public Window(int w, int h, String title, Game game)
    {
        this.W = w;
        this.H = h;
        this.TITLE = title;
        this.GAME = game;

    }

    public void iniciarVentana()
    {
        GAME.setPreferredSize(new Dimension(W, H));
        GAME.setMaximumSize(new Dimension(W, H));
        GAME.setMinimumSize(new Dimension(W, H));

        setTitle(TITLE);
        setResizable(false);
        setVisible(true);
        add(GAME);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Updater(GAME, this).start();

    }

}
