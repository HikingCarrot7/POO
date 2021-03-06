package ejer1_10;

/**
 *
 * @author Mohammed
 */
public class EstudianteGraduado extends Estudiante
{

    public EstudianteGraduado(String nombre)
    {
        super(nombre);
    }

    public EstudianteGraduado()
    {
        super("Sin nombre");
    }

    @Override
    public void calculaCalificacionCurso()
    {
        int total = 0;

        for (int i = 0; i < NUM_DE_EXAMENES; i++)
            total += examen[i];

        calificacionCurso = total / NUM_DE_EXAMENES >= 80 ? "Aprobado" : "No aprobado";

    }

}
