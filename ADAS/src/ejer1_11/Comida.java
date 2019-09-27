package ejer1_11;

/**
 *
 * @author Mohammed
 */
public enum Comida
{

    Pizza(35),
    Hamburguesa(50),
    Tamal(60),
    Empanada(30),
    Pastelito(20),
    Frituras(25),
    Frutas(55),
    Cafe(45),
    Dona(15),
    Cupcake(25),
    Chicles(5),
    Crepas(25),
    Chapatas(35),
    Sandwich(30),
    Churros(15);

    private int precio;

    private Comida(int precio)
    {
        this.precio = precio;
    }

    public int getPrecio()
    {
        return precio;
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }

}
