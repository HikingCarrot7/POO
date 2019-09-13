package herencia;

/**
 *
 * @author juan.ucan
 */
public class EmpleadoBaseMasComision2 extends EmpleadoPorComision
{

    private double sueldo;

    //Constructor
    public EmpleadoBaseMasComision2(String nombre, String apellidoPaterno, String apellidoMaterno, String seguroSocial, double ventasBrutas, double tarifaComision, double sueldo)
    {
        super(nombre, apellidoPaterno, apellidoMaterno, seguroSocial, ventasBrutas, tarifaComision);
        this.sueldo = sueldo;
    }

    //Métodos get
    public double getSueldo()
    {
        return sueldo;
    }

    public void setSueldo(double sueldo)
    {
        this.sueldo = sueldo;
    }

    //Método toString
    @Override
    public String toString()
    {
        return super.toString() + ",sueldo=" + getSueldo();
    }

    //Método para calcular el ingreso
    @Override
    public double ingreso()
    {
        return super.ingreso() + getSueldo();
    }

}
