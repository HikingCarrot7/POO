package ejer1_18;

import static java.lang.System.out;

/**
 *
 * @author HikingCarrot7
 */
public class Cat extends Animal implements Pet
{

    private String name;

    public Cat(int legs, String name)
    {
        super(legs);

        this.name = name;

    }

    public Cat()
    {
        this(4, " ");
    }

    @Override
    public void walk()
    {
        out.println("Estoy caminando con mis " + getLegs() + "patas");
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void play()
    {
        out.println("Estoy jugando con estambre.");
    }

}
