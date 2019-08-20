package maquinacafetera;

/**
 *
 * @author HikingCarrot7
 */
public enum TiposCafe
{

    CafeNegro("Café negro", "Disfrute de su buen café negro!", 30),
    CafeCapuccino("Café capuccino", "Disfrute de su buen café capuccino!", 40),
    CafeDescafeinado("Café descafeinado", "Disfrute de su buen café descafeinado!", 50);

    private final String tipo, descripcion;
    private final int precio;

    private TiposCafe(String tipo, String descripcion, int precio)
    {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getTipo()
    {
        return tipo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public int getPrecio()
    {
        return precio;
    }

}
