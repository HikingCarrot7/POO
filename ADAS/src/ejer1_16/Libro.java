package ejer1_16;

import java.util.Date;

/**
 *
 * @author HikingCarrot7
 */
public class Libro extends Publicacion
{

    private Date anioPublicacion;
    private int nPaginas;

    public Libro(String titulo, double precio, Date anioPublicacion, int nPaginas)
    {
        super(titulo, precio);

        this.anioPublicacion = anioPublicacion;
        this.nPaginas = nPaginas;

    }

    public Date getAnioPublicacion()
    {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion)
    {
        this.anioPublicacion = anioPublicacion;
    }

    public int getnPaginas()
    {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas)
    {
        this.nPaginas = nPaginas;
    }

}
