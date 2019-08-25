package adas.ejemplos.maquina;

/**
 *
 * @author HikingCarrot7
 */
public class ContenedorIngredientes
{

    private final float MAX_CAPACIDAD = 30f;
    private float contenidoActual;
    private String tipoIngrediente;

    public ContenedorIngredientes(String tipoIngrediente, float contenidoActual) throws ExcesoLimiteCapacidad
    {
        this.tipoIngrediente = tipoIngrediente;

        if (contenidoActual > MAX_CAPACIDAD)
        {
            throw new ExcesoLimiteCapacidad();
        }

        this.contenidoActual = contenidoActual;
    }

    public float getContenidoActual()
    {
        return contenidoActual;
    }

    public void setContenidoActual(float contenidoActual)
    {
        this.contenidoActual = contenidoActual;
    }

    public String getTipoIngrediente()
    {
        return tipoIngrediente;
    }

    public void setTipoIngrediente(String tipoIngrediente)
    {
        this.tipoIngrediente = tipoIngrediente;
    }

    private class ExcesoLimiteCapacidad extends RuntimeException
    {

        public ExcesoLimiteCapacidad()
        {
            this("\nLímite del contenedor excedido");
        }

        public ExcesoLimiteCapacidad(String mensaje)
        {
            super(mensaje);
        }

        public ExcesoLimiteCapacidad(String mensaje, Throwable e)
        {
            super(mensaje, e);
        }

    }

}
