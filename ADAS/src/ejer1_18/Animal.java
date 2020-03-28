package ejer1_18;

import static java.lang.System.out;

/**
 *
 * @author HikingCarrot7
 */
public abstract class Animal
{

    private int legs;

    public Animal(int legs)
    {
        this.legs = legs;
    }

    public abstract void walk();

    public void eat()
    {
        out.println("Estoy comiendo");

    }

    public int getLegs()
    {
        return legs;
    }

}
