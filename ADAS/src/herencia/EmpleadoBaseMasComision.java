package herencia;

/**
 *
 * @author juan.ucan
 */
public class EmpleadoBaseMasComision
{

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String seguroSocial;
    private double ventasBrutas;
    private double tarifaComision;
    private double sueldoBase;

    //Constructor
    public EmpleadoBaseMasComision(String nombre, String apellidoPaterno, String apellidoMaterno, String seguroSocial, double ventasBrutas, double tarifaComision, double sueldoBase)
    {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.seguroSocial = seguroSocial;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
        this.sueldoBase = sueldoBase;
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

    public double getSueldoBase()
    {
        return sueldoBase;
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

    public void setSueldoBase(double sueldoBase)
    {
        this.sueldoBase = sueldoBase;
    }

    //Método toString
    @Override
    public String toString()
    {
        return "nombre=" + getNombre()
                + ", apellidoPaterno=" + getApellidoPaterno()
                + ", apellidoMaterno=" + getApellidoMaterno()
                + ", seguroSocial=" + getSeguroSocial()
                + ", ventasBrutas=" + getVentasBrutas()
                + ", tarifaComision=" + getTarifaComision()
                + ", sueldoBase=" + getSueldoBase();

    }

    //Método para calcular el ingreso
    public double ingreso()
    {
        return getSueldoBase() + getVentasBrutas() * getTarifaComision();
    }

}
