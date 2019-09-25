package ejer1_08;

import galapagos.Turtle;
import galapagos.TurtleDrawingWindow;

/**
 *
 * @author Mohammed
 */
public class Galapagos
{

    public static void main(String[] args)
    {
        new Galapagos().dibujarNombre();
    }

    public void dibujarNombre()
    {
        TurtleDrawingWindow playground = new TurtleDrawingWindow();
        Turtle miTurtle = new Turtle(Turtle.NO_DEFAULT_WINDOW);

        playground.setVisible(true);

        playground.add(miTurtle);

        miTurtle.speed(1000);
        miTurtle.turn(90);
        miTurtle.move(100);

        miTurtle.turn(-135);
        miTurtle.move(140);

        miTurtle.turn(135);
        miTurtle.move(100);

        miTurtle.turn(180);
        miTurtle.move(100);

        miTurtle.turn(90);
        miTurtle.move(15);

        miTurtle.turn(90);
        miTurtle.move(100);

        miTurtle.turn(180);
        miTurtle.move(100);

        miTurtle.turn(90);
        miTurtle.move(15);

        miTurtle.turn(90);
        miTurtle.move(100);

        miTurtle.turn(-90);
        miTurtle.move(30);

        miTurtle.turn(180);
        miTurtle.move(30);

        miTurtle.turn(90);
        miTurtle.move(100);

        miTurtle.turn(90);
        miTurtle.move(75);

        miTurtle.turn(90);
        miTurtle.move(100);

        miTurtle.turn(90);
        miTurtle.move(30);

        miTurtle.turn(90);
        miTurtle.move(100);

    }

}
