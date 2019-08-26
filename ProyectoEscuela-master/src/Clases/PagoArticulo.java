package Clases;

/**
 *
 * @author Daniel Poot
 */
public class PagoArticulo
{

    private int IDArticulo;
    private String nombreArticulo;
    private double precioArticulo;
    private double numeroArticulos;
    private double pagoArticulo;
    private int IDAlumnoPago;

    //Constructor
    public PagoArticulo(int IDArticulo, String nombreArticulo, double precioArticulo, double numeroArticulos,
            double pagoArticulo, int IDAlumnoPago)
    {
        this.IDArticulo = IDArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioArticulo = precioArticulo;
        this.numeroArticulos = numeroArticulos;
        this.pagoArticulo = pagoArticulo;
        this.IDAlumnoPago = IDAlumnoPago;
    }

    //Metodos get
    public int getIDArticulo()
    {
        return IDArticulo;
    }

    public String getNombreArticulo()
    {
        return nombreArticulo;
    }

    public double getPrecioArticulo()
    {
        return precioArticulo;
    }

    public double getNumeroArticulos()
    {
        return numeroArticulos;
    }

    public double getPagoArticulo()
    {
        return pagoArticulo;
    }

    public int getIDAlumnoPago()
    {
        return IDAlumnoPago;
    }

    //Metodos set
    public void setIDArticulo(int IDArticulo)
    {
        this.IDArticulo = IDArticulo;
    }

    public void setNombreArticulo(String nombreArticulo)
    {
        this.nombreArticulo = nombreArticulo;
    }

    public void setPrecioArticulo(double precioArticulo)
    {
        this.precioArticulo = precioArticulo;
    }

    public void setNumeroArticulos(double numeroArticulos)
    {
        this.numeroArticulos = numeroArticulos;
    }

    public void setPagoArticulo(double pagoArticulo)
    {
        this.pagoArticulo = pagoArticulo;
    }

    public void setIDAlumnoPago(int IDAlumnoPago)
    {
        this.IDAlumnoPago = IDAlumnoPago;
    }

    @Override
    public String toString()
    {
        return "PagoArticulo{" + "IDArticulo=" + IDArticulo + ", nombreArticulo=" + nombreArticulo + ", precioArticulo=" + precioArticulo + ", numeroArticulos=" + numeroArticulos + ", pagoArticulo=" + pagoArticulo + ", IDAlumnoPago=" + IDAlumnoPago + '}';
    }

}
