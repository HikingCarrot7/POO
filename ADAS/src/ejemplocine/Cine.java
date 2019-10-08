package ejemplocine;

/**
 *
 * @author Mohammed
 */
public final class Cine
{

    private final Asiento[][] asientos;
    private String pelicula;
    private double precioPelicula;

    public Cine(String pelicula, double precioPelicula)
    {
        asientos = new Asiento[5][10];

        this.pelicula = pelicula;
        this.precioPelicula = precioPelicula;

        iniciarAsientos();

    }

    private void iniciarAsientos()
    {
        char letra = 'A';

        for (int i = 0; i < asientos.length; i++)
        {
            for (int j = 0; j < asientos[i].length; j++)
                asientos[i][j] = new Asiento(false, new Cliente("Vacío", 0), letra++, i + 1);

            letra = 'A';
        }

    }

    public void imprimirCine()
    {
        for (Asiento[] I : asientos)
        {
            for (Asiento asiento : I)
                System.out.print(asiento);

            System.out.println("");
        }

    }

    public void ocuparAsiento(Cliente cliente, char columna, int fila)
    {
        asientos[fila][((int) columna) - 65].setOcupado(true);
        asientos[fila][((int) columna) - 65].setCliente(cliente);

    }

    public Asiento[][] obtenerAsientos()
    {
        return asientos;
    }

    public boolean cineLleno()
    {
        for (Asiento[] fila : asientos)
            for (Asiento asiento : fila)
                if (!asiento.isOcupado())
                    return false;

        return true;

    }

    public String getPelicula()
    {
        return pelicula;
    }

    public void setPelicula(String pelicula)
    {
        this.pelicula = pelicula;
    }

    public double getPrecioPelicula()
    {
        return precioPelicula;
    }

    public void setPrecioPelicula(double precioPelicula)
    {
        this.precioPelicula = precioPelicula;
    }

}
