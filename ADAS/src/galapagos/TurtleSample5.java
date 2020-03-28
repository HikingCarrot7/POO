package galapagos;

import static galapagos.Turtle.NO_DEFAULT_WINDOW;
import java.awt.Color;
import static java.awt.Color.magenta;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;

/**
 * This sample program shows how to use a TurtleDrawingWindow.
 *
 */
public class TurtleSample5
{

    public static void main(String args[])
    {

        Turtle myTurtle;
        TurtleDrawingWindow playground;

        int size, turn;

        playground = new TurtleDrawingWindow();

        myTurtle = new Turtle(NO_DEFAULT_WINDOW);
        myTurtle.bodyColor(magenta);

        playground.add(myTurtle);

        playground.setVisible(true);

        //Get input
        size = parseInt(showInputDialog("Enter the size of a square:"));

        turn = 90;

        //draw a square
        myTurtle.move(size);
        myTurtle.turn(turn);

        myTurtle.move(size);
        myTurtle.turn(turn);

        myTurtle.move(size);
        myTurtle.turn(turn);

        myTurtle.move(size);
        myTurtle.turn(turn);

    }
}
