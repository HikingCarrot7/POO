package ejer1_19;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HikingCarrot7
 */
public class Empresa
{

    public static final String NOMBREEMPRESA = "Patito";
    private ArrayList<Espectaculo> espectaculos;
    private ArrayList<Agenda> espectaculosAgendados;

    public Empresa()
    {
        espectaculos = new ArrayList<>();
        espectaculosAgendados = new ArrayList<>();

        espectaculos.add(new ShowBasico("Pinocho", 4));
        espectaculos.add(new ShowBasico("Toy Story", 4));
        espectaculos.add(new ShowBasico("Monster Inc", 4));
        espectaculos.add(new ShowCompleto("Spider Man", 7));
        espectaculos.add(new ShowCompleto("La cenicienta", 9));
        espectaculos.add(new ShowCompleto("Batman", 11));
        espectaculos.add(new ShowCompleto("El rey león", 12));

    }

    public void agregarShow(Espectaculo nuevoEspectaculo)
    {
        espectaculos.add(nuevoEspectaculo);
    }

    public void agregarNuevoEspectaculoAgendado(Agenda agenda)
    {
        espectaculosAgendados.add(agenda);
    }

    public void detenerShow(int indexShow)
    {
        if (espectaculos.get(indexShow) instanceof ShowCompleto)
            ((ShowCompleto) espectaculos.get(indexShow)).cancelarShow();

        else
            System.out.println("No se pueden cancelar los shows básicos");

    }

    public void reporteEspectaculo()
    {

        if (!espectaculosAgendados.isEmpty())
        {

            espectaculosAgendados.sort((Agenda agenda1, Agenda agenda2) ->
            {
                return agenda1.getFecha().compareTo(agenda2.getFecha());

            });

            imprimirEspectaculo("Shows básicos.\n", "showbasico");

            imprimirEspectaculo("Shows completos.\n", "showcompleto");

        }

    }

    private void imprimirEspectaculo(String tipoEspectaculo, String clave)
    {
        int indexTemp = 0;

        System.out.println(tipoEspectaculo);

        System.out.printf("%-35s%-35s%s\n\n", "Título", "Fecha", "Precio");

        for (int i = 0; i < espectaculosAgendados.size(); i++)
        {

            Agenda agenda = espectaculosAgendados.get(i);

            if (clave.equals("showbasico"))
            {
                if (agenda.getEspectaculo() instanceof ShowBasico)
                    System.out.printf("%02d.- %s\n", ++indexTemp, agenda);

            } else if (agenda.getEspectaculo() instanceof ShowCompleto)
                System.out.printf("%02d.- %s\n", ++indexTemp, agenda);

        }

        System.out.println("\n");

    }

    public ArrayList<Espectaculo> getEspectaculos()
    {
        return espectaculos;
    }

    public ArrayList<Agenda> getEspectaculosAgendados()
    {
        return espectaculosAgendados;
    }

}
