package adas.ejemplos.productos;

/**
 *
 * @author HikingCarrot7
 */
public enum TiposCafe
{

    CafeNegro("Café negro", "Disfrute de su buen café negro!", 30, 0.0f, 0.5f, 0.2f),
    CafeCapuccino("Café capuccino", "Disfrute de su buen café capuccino!", 40, 0.4f, 0.0f, 0.3f),
    CafeDescafeinado("Café descafeinado", "Disfrute de su buen café descafeinado!", 50, 0.2f, 0.1f, 0.4f);

    private final String tipo, descripcion;
    private final float aguaNecesaria, lecheNecesaria, cafeNecesario;
    private final int precio;

    private TiposCafe(String tipo, String descripcion, int precio, float aguaNecesaria, float lecheNecesaria, float cafeNecesario)
    {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;

        this.aguaNecesaria = aguaNecesaria;
        this.lecheNecesaria = lecheNecesaria;
        this.cafeNecesario = cafeNecesario;
    }

    public float getAguaNecesaria()
    {
        return aguaNecesaria;
    }

    public float getLecheNecesaria()
    {
        return lecheNecesaria;
    }

    public float getCafeNecesario()
    {
        return cafeNecesario;
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
