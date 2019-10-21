package ejer1_18;

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
        System.out.println("Estoy caminando con mis " + getLegs() + "patas");
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
        System.out.println("Estoy jugando con estambre.");
    }

}
