package ejer1_18;

import static java.lang.System.out;

/**
 *
 * @author HikingCarrot7
 */
public class Fish extends Animal implements Pet
{

    private String name;

    public Fish(int legs, String name)
    {
        super(legs);

        this.name = name;

    }

    @Override
    public void walk()
    {
        out.println("Estoy nadando");
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
        out.println("Estoy jugando con una pelotas");
    }

}
