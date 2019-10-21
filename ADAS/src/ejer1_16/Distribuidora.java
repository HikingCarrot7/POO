package ejer1_16;

import java.util.Date;

/**
 *
 * @author HikingCarrot7
 */
public class Distribuidora
{

    private Disco[] discos;
    private Libro[] libros;
    private int indexDiscos = 0;
    private int indexLibros = 0;

    public Distribuidora()
    {
        discos = new Disco[10];
        libros = new Libro[10];

    }

    public void addDisco(Disco disco)
    {
        if (indexDiscos < 10)
            discos[indexDiscos++] = disco;
        else
            System.out.println("\nLímite de discos alcanzado.");

    }

    public void addDisco(String titulo, double precio, int duracionMin)
    {
        if (indexDiscos < 10)
            discos[indexDiscos++] = new Disco(titulo, precio, duracionMin);
        else
            System.out.println("\nLímite de discos alcanzado.");

    }

    public void addLibro(Libro libro)
    {
        if (indexLibros < 10)
            libros[indexLibros++] = libro;
        else
            System.out.println("\nLímite de libros alcanzado.");

    }

    public void addLibro(String titulo, double precio, Date anioPublicacion, int nPaginas)
    {
        if (indexLibros < 10)
            libros[indexLibros++] = new Libro(titulo, precio, anioPublicacion, nPaginas);
        else
            System.out.println("\nLímite de libros alcanzado.");

    }

    public Disco[] getDiscos()
    {
        return discos;
    }

    public Libro[] getLibros()
    {
        return libros;
    }

}
