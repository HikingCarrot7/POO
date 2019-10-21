package ejer1_18;

/**
 *
 * @author HikingCarrot7
 */
public class Spider extends Animal
{

    public Spider(int legs)
    {
        super(legs);
    }

    @Override
    public void walk()
    {
        System.out.println("Esoty caminando con mis " + getLegs() + "patas.");
    }

}
