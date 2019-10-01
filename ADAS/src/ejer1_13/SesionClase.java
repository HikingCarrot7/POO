package ejer1_13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class SesionClase
{

    private long tiempo;
    private final Scanner IN;
    private ArrayList<Respuesta> respuestas;
    private GeneradorPreguntas generadorPreguntas;

    public SesionClase()
    {
        IN = new Scanner(System.in);
        respuestas = new ArrayList<>();
        generadorPreguntas = new GeneradorPreguntas();

    }

    public void preguntar()
    {
        String operacion;
        TiposDeFraccion[] tipoDeFracciones = generadorPreguntas.getTipoDeFracciones();

        pedirTiempo();

        for (int i = 0; i < generadorPreguntas.getFracciones1().length; i++)
        {
            IN.nextLine();
            System.out.printf("Pregunta: %d\n\n¿Estás listo? (Presiona cualquier tecla)", i + 1);
            IN.nextLine();

            Temporizador cronometro = new Temporizador(this);

            cronometro.iniciarTemporizador(tiempo * 1000);

            operacion = obtenerTipoOperacionPregunta(tipoDeFracciones[i]);

            System.out.println("\n¿Cuál es el resultado?");
            System.out.printf("\n\n(%s)  %s  (%s) = ?\n\n", generadorPreguntas.getFracciones1()[i], operacion, generadorPreguntas.getFracciones2()[i]);

            Fraccion respuesta = resolverFraccion(generadorPreguntas.getFracciones1()[i], generadorPreguntas.getFracciones2()[i], tipoDeFracciones[i]);

            System.out.printf("\n\nRespuesta: %s\n\n", respuesta);

            Fraccion respuestaUsuario = pedirRespuesta();

            contabilizarRespuesta(checarRespuesta(respuesta, respuestaUsuario), cronometro.enTiempo());

            if (cronometro.enTiempo())
                cronometro.setMostrarMensaje(false);

        }

        imprimirResultados();

    }

    public Fraccion pedirRespuesta()
    {
        int numerador, denominador;

        System.out.println("\nNumerador: ");
        numerador = IN.nextInt();

        System.out.println("\nDenominador: ");
        denominador = IN.nextInt();

        return new Fraccion(numerador, denominador).simplifica();

    }

    public Fraccion resolverFraccion(Fraccion fraccion1, Fraccion fraccion2, TiposDeFraccion tipoDeFracciones)
    {

        switch (tipoDeFracciones)
        {
            case Suma:
                return fraccion1.suma(fraccion2).simplifica();

            case Resta:
                return fraccion1.resta(fraccion2).simplifica();

            case Multiplicacion:
                return fraccion1.multiplica(fraccion2).simplifica();

            case Division:
                return fraccion1.divide(fraccion2).simplifica();

            default:
                return null;

        }

    }

    public boolean checarRespuesta(Fraccion respuesta, Fraccion respuestaUsuario)
    {
        return respuesta.getNumerador() == respuestaUsuario.getNumerador() && respuesta.getDenominador() == respuestaUsuario.getDenominador();
    }

    public void contabilizarRespuesta(boolean respuestaCorrecta, boolean enTiempo)
    {
        respuestas.add(new Respuesta(respuestaCorrecta, enTiempo));
    }

    public void pedirTiempo()
    {
        System.out.println("Inserte el tiempo en segundos para responder cada pregunta: ");
        tiempo = IN.nextInt();

    }

    public void imprimirResultados()
    {
        int correctasSobreLimite = 0, correctasFueraLimite = 0, incorrectasSobreLimite = 0, incorrectasFueraLimite = 0;
        int puntosTotales = 0;

        for (Respuesta respuesta : respuestas)
            if (respuesta.isRespuestaCorrecta())
                if (respuesta.isEnTiempo())
                {
                    correctasSobreLimite++;
                    puntosTotales += 10;

                } else
                {
                    correctasFueraLimite++;
                    puntosTotales += 6;
                }

            else if (respuesta.isEnTiempo())
            {
                incorrectasSobreLimite++;
                puntosTotales += 3;

            } else
                incorrectasFueraLimite++;

        System.out.printf("\n\n\t\t\tBajo el tiempo límite\tSobre el tiempo límite");
        System.out.printf("\nRespuestas correctas:%24d%24d\nRespuestas incorrectas:%22d%24d", correctasSobreLimite, correctasFueraLimite, incorrectasSobreLimite, incorrectasFueraLimite);
        System.out.printf("\nPuntos totales: %d\n\n", puntosTotales);

        System.exit(1);

    }

    public void seAcaboElTiempo()
    {
        System.out.println("\n\n¡Se acabó el tiempo límite!\nRespuesta retrasada.\n\n");
    }

    public String obtenerTipoOperacionPregunta(TiposDeFraccion tipoDeFracciones)
    {

        switch (tipoDeFracciones)
        {
            case Suma:
                return "+";

            case Resta:
                return "-";

            case Multiplicacion:
                return "*";

            case Division:
                return "/";

            default:
                return null;

        }

    }

}
