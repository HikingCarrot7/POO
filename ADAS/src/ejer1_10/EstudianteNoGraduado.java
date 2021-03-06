package ejer1_10;

/**
 *
 * @author Mohammed
 */
public class EstudianteNoGraduado extends Estudiante
{

    public EstudianteNoGraduado(String nombre)
    {
        super(nombre);
    }

    public EstudianteNoGraduado()
    {
        super("Sin nombre");
    }

    @Override
    public void calculaCalificacionCurso()
    {
        int total = 0;

        for (int i = 0; i < NUM_DE_EXAMENES; i++)
            total += examen[i];

        calificacionCurso = total / NUM_DE_EXAMENES >= 70 ? "Aprobado" : "No aprobado";

    }

}
