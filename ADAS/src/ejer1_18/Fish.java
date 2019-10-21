package ejer1_18;

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
        System.out.println("Estoy nadando");
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
        System.out.println("Estoy jugando con una pelotas");
    }

}
