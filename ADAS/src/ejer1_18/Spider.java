package ejer1_18;

import static java.lang.System.out;

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
        out.println("Esoty caminando con mis " + getLegs() + "patas.");
    }

}
