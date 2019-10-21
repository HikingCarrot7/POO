package ejer1_18;

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
        System.out.println("Estoy comiendo");

    }

    public int getLegs()
    {
        return legs;
    }

}
