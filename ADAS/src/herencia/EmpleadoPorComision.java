package herencia;

/**
 *
 * @author juan.ucan
 */
public class EmpleadoPorComision
{

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String seguroSocial;
    private double ventasBrutas;
    private double tarifaComision;

    //Constructor
    public EmpleadoPorComision(String nombre, String apellidoPaterno, String apellidoMaterno, String seguroSocial, double ventasBrutas, double tarifaComision)
    {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.seguroSocial = seguroSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    //Métodos get
    public String getNombre()
    {
        return nombre;
    }

    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }

    public String getSeguroSocial()
    {
        return seguroSocial;
    }

    public double getVentasBrutas()
    {
        return ventasBrutas;
    }

    public double getTarifaComision()
    {
        return tarifaComision;
    }

    //Métodos set
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setSeguroSocial(String seguroSocial)
    {
        this.seguroSocial = seguroSocial;
    }

    public void setVentasBrutas(double ventasBrutas)
    {
        this.ventasBrutas = ventasBrutas;
    }

    public void setTarifaComision(double tarifaComision)
    {
        this.tarifaComision = tarifaComision;
    }

    //Método toString
    @Override
    public String toString()
    {
        return "nombre=" + getNombre()
                + ", apellidoPaterno="
                + getApellidoPaterno()
                + ", apellidoMaterno="
                + getApellidoMaterno()
                + ", seguroSocial="
                + getSeguroSocial()
                + ", ventasBrutas="
                + getVentasBrutas()
                + ", tarifaComision="
                + getTarifaComision();

    }

    public double ingreso()
    {
        return getVentasBrutas() * getTarifaComision();
    }

}
