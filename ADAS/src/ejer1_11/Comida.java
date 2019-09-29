package ejer1_11;

/**
 * Comidas disponibles en la cafetería.
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

    /**
     * Inicializa el precio de los alimentos.
     *
     * @param precio El precio de los alimentos.
     */
    private Comida(int precio)
    {
        this.precio = precio;
    }

    /**
     * Retorna el precio para este alimento.
     *
     * @return El precio de este alimento.
     */
    public int getPrecio()
    {
        return precio;
    }

    /**
     * Establece el precio para este alimento.
     *
     * @param precio El nuevo precio para este alimento.
     */
    public void setPrecio(int precio)
    {
        this.precio = precio < 0 ? 0 : precio;
    }

}
