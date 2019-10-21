package ejer1_16;

/**
 *
 * @author HikingCarrot7
 */
public abstract class Publicacion
{

    private String titulo;
    private double precio;

    public Publicacion(String titulo, double precio)
    {
        this.titulo = titulo;
        this.precio = precio;

    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

}
