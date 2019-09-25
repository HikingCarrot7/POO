package ejer1_10;

/**
 *
 * @author Mohammed
 */
public class MainEstudiante
{

    public static void main(String[] args)
    {
        EstudianteGraduado estudiante1 = new EstudianteGraduado();

        estudiante1.asignaNombre("Juan Trejo");
        estudiante1.asignaCalifExamen(1, 80);
        estudiante1.asignaCalifExamen(2, 90);
        estudiante1.asignaCalifExamen(3, 70);

        estudiante1.calculaCalificacionCurso();

        System.out.println(String.format("%-15s terminó el curso con la nota: %s.", estudiante1.obtenNombre(), estudiante1.obtenCalificacionCurso()));

        EstudianteNoGraduado estudiante2 = new EstudianteNoGraduado();

        estudiante2.asignaNombre("Lupita Perez");

        estudiante2.asignaCalifExamen(1, 80);
        estudiante2.asignaCalifExamen(2, 90);
        estudiante2.asignaCalifExamen(3, 70);

        estudiante2.calculaCalificacionCurso();

        System.out.println(String.format("%-15s terminó el curso con la nota: %s.", estudiante2.obtenNombre(), estudiante2.obtenCalificacionCurso()));

    }

}
