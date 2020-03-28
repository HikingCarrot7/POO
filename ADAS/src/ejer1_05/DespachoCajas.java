package ejer1_05;

import static java.lang.String.format;
import static java.lang.System.out;

/**
 * Clase DespachoCajas.
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class DespachoCajas
{

    private final int PRECIOBOLSAS = 250;
    private Caja cajaGrande; // Caja grande.
    private Caja cajaMediana; // Caja mediana.
    private Caja cajaPequena; // Caja pequeña.

    public DespachoCajas()
    {
        cajaGrande = new Caja("Grande", 20, 10);
        cajaMediana = new Caja("Mediana", 10, 5);
        cajaPequena = new Caja("Pequeña", 5, 3);

    }

    /**
     * Imprime en consola el menor número de cajas para realizar el envío.
     *
     * @param bolsas El número de bolsas para hacer el cálculo.
     */
    public void calcularMenorNumeroCajas(int bolsas)
    {

        //Si el número de bolsas que se insertó es un múltiplo de 20, entonces el menor número de cajas que necesitamos son bolsas / 20 cajas grandes.
        //En caso contrario sería bolsas / 20 + 1 cajas grandes.
        int nCajasGrandes = bolsas % cajaGrande.getCAPACIDAD() == 0 ? bolsas / cajaGrande.getCAPACIDAD() : bolsas / cajaGrande.getCAPACIDAD() + 1;

        out.println("---------------Menor número de cajas---------------");
        out.println(format("\n\tNúmero de bolsas ordenadas: %d - $%d", bolsas, bolsas * PRECIOBOLSAS));
        out.println(format("\nCajas grandes necesarias: %-10dEspacios remanentes: %d\n\n\t\tSu costo total es: $%,.2f\n",
                nCajasGrandes, // Total de cajas grandes.
                cajaGrande.getCAPACIDAD() * nCajasGrandes - bolsas, // El número de espacios remanentes se calcula multiplicando el número de cajas grandes necesarias por su capacidad y restándole el número de bolsas.
                bolsas * PRECIOBOLSAS + nCajasGrandes * cajaGrande.getPRECIO())); // Precio total.

    }

    /**
     * Imprime en consola el menor número de espacios desperdiciados para hacer el envío.
     *
     * @param bolsas El número de bolsas para hacer el cálculo.
     */
    public void calcularMenorNumeroEspaciosDesperdiciados(int bolsas)
    {
        int tempBolsas = bolsas;
        int totalCajasGrandes;
        int totalCajasMedianas;
        int totalCajasPequenas = 0;

        // Las cajas grandes es igual al número de bolsas menos el residuo de dividir el número de bolsas por la capacidad de las cajas grandes, todo esto dividido entre la capacidad de las cajas grandes.
        // Si tenemos 67 bolsas, las cajas grandes se calculan de la siguiente manera:
        // Cajas Grandes = (67 - 67 % 20) / 20 = (67 - 7) / 20 = 60 / 20 = 3 cajas grandes.
        totalCajasGrandes = (tempBolsas - tempBolsas % cajaGrande.getCAPACIDAD()) / cajaGrande.getCAPACIDAD();
        tempBolsas -= totalCajasGrandes * cajaGrande.getCAPACIDAD(); // Restamos el número de cajas grandes por su capacidad al número de bolsas.

        // Repetimos exactamente lo mismo para las bolsas restantes.
        totalCajasMedianas = (tempBolsas - tempBolsas % cajaMediana.getCAPACIDAD()) / cajaMediana.getCAPACIDAD();
        tempBolsas -= totalCajasMedianas * cajaMediana.getCAPACIDAD();

        // Si el número de bolsas que tenemos hasta llegar aquí NO es 0 entoneces procedemos de las siguiente manera:
        // Si nos quedan más de 5 bolsas para empaquetar entonces necesitamos 2 cajas, en caso contrario sólo necesitamos 1 caja.
        if (tempBolsas != 0)
            totalCajasPequenas = (float) tempBolsas / 5 > 1 ? 2 : 1;

        out.println("-----Menor número de espacios desaprovechados-----");
        out.println(format("\n\tNúmero de cajas ordenadas: %d - $%d", bolsas, bolsas * PRECIOBOLSAS));
        out.println(format("\n%-25s %d\n%-25s %d\n%-25s %d\n%-25s %d\n\n\t\tSu costo total es: $%,.2f\n",
                "Cajas grandes: ", totalCajasGrandes, // Número de cajas grandes totales.
                "Cajas medianas: ", totalCajasMedianas, // Número de cajas medianas totales.
                "Cajas pequeñas: ", totalCajasPequenas, // Número de cajas pequeñas totales.
                "Espacios remanentes: ",
                totalCajasPequenas * cajaPequena.getCAPACIDAD() - tempBolsas, // Especios restantes.
                bolsas * PRECIOBOLSAS + totalCajasGrandes * cajaGrande.getPRECIO() + totalCajasMedianas * cajaMediana.getPRECIO() + totalCajasPequenas * cajaPequena.getPRECIO())); // Total de la venta.

    }

}
