package ferreteria;

import java.util.Calendar;

/**
 *
 * @author Mohammed
 */
public class Factura
{

    private static int numFactura;
    private int nPieza, cantidadDePiezas;
    private float precio;
    private String descripcion;
    private Calendar fecha;
    private Empleado empleado;

    public Factura(int nPieza, int cantidadDePiezas, float precio, String descripcion, Calendar fecha, Empleado empleado)
    {
        this.nPieza = nPieza;
        this.cantidadDePiezas = cantidadDePiezas;
        this.precio = precio < 0 ? 0 : precio;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.empleado = empleado;
        numFactura++;

    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado(Empleado empleado)
    {
        this.empleado = empleado;
    }

    public int getnPieza()
    {
        return nPieza;
    }

    public void setnPieza(int nPieza)
    {
        this.nPieza = nPieza;
    }

    public int getCantidadDePiezas()
    {
        return cantidadDePiezas;
    }

    public void setCantidadDePiezas(int cantidadDePiezas)
    {
        this.cantidadDePiezas = cantidadDePiezas;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Calendar getFecha()
    {
        return fecha;
    }

    public void setFecha(Calendar fecha)
    {
        this.fecha = fecha;
    }

    public float getPrecio()
    {
        return precio;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }

    public float obtenerImporteTotal()
    {
        return getPrecio() * getCantidadDePiezas() < 0 ? 0 : getPrecio() * getCantidadDePiezas();
    }

    @Override
    public String toString()
    {
        String lineSeparator = System.getProperty("line.separator");

        return String.format("%17$s%17$s%-25s%d%17$s%17$s%-25s%d%17$s%-25s%s%17$s%-25s%d%17$s%-25s$%,.2f%17$s%-25s%s%17$s%-25s%tc%17$s%17$s\t%-10s$%,.2f%17$s", "Factura: ", numFactura, "Número de producto: ", nPieza, "Descripción: ", descripcion, "Cantidad: ", cantidadDePiezas,
                "Precio por pieza: ", precio, "Vendedor: ", empleado, "Fecha de la venta: ", fecha, "Importe total: ", obtenerImporteTotal(), lineSeparator);
    }

}
