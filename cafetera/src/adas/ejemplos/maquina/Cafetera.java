package adas.ejemplos.maquina;

import adas.ejemplos.productos.TiposCafe;
import adas.ejemplos.usuario.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class Cafetera
{

    private final File file;
    private final Usuario usuario;
    private final ContenedorMonedas saldoCafetera, saldoGanancias;
    private final ArrayList<ContenedorIngredientes> contenedores;

    public Cafetera(int n_monedas50, int n_monedas20, int n_monedas10) throws IOException
    {

        saldoCafetera = new ContenedorMonedas(n_monedas50, n_monedas20, n_monedas10);
        saldoGanancias = new ContenedorMonedas();

        usuario = new Usuario(this, saldoGanancias);

        contenedores = new ArrayList<>();

        contenedores.add(new ContenedorIngredientes("Agua", 25f));
        contenedores.add(new ContenedorIngredientes("Leche", 25f));
        contenedores.add(new ContenedorIngredientes("Café", 30f));
        contenedores.add(new ContenedorIngredientes("Azúcar", 30f));

        file = new File("res/RegistrosDeVentas.txt");

        if (!file.exists())
            file.createNewFile();

    }

    public void despacharCliente() throws IOException
    {
        while (true)
            if (!sinDinero() && !cafeteraDescompuesta())
                usuario.InsertarDinero();
            else
            {
                System.out.println("Disculpe, la cafetera se quedó sin dinero o  está descompuesta");

                break;
            }

    }

    public void despacharCafe() throws IOException
    {

        imprimirListaCafes();

        int indexCafe = usuario.obtenerOpcionProducto();

        if (indexCafe == 4)
            despacharCliente();

        if (validarIngredientesNecesarios(indexCafe))
        {
            float azucarActual = contenedores.get(3).getContenidoActual();
            int nivelAzucar;
            boolean azucarValida = false;

            if (azucarActual != 0)
            {
                System.out.println("\nNiveles de azúcar disponibles ");

                for (int i = 0; i < 3; i++)
                    if ((i + 1) * 0.1f <= azucarActual)
                        System.out.print((i + 1) + ". ");

            } else
                System.out.println("\nNo hay azúcar, presione 0 para continuar");

            do
            {

                nivelAzucar = usuario.obtenerNivelAzucar();

                if (nivelAzucar * 0.1f <= azucarActual)
                {
                    actualizarContenedores(nivelAzucar, indexCafe);

                    System.out.println("\n" + TiposCafe.values()[indexCafe].getDescripcion() + ((nivelAzucar == 0) ? " sin azúcar" : " con " + nivelAzucar + " nivel(es) de azúcar"));

                    retirarDinero(saldoCafetera, usuario.getSaldoCliente() - TiposCafe.values()[indexCafe].getPrecio());

                    usuario.setSaldoCliente(0);

                    generarRegistros(TiposCafe.values()[indexCafe]);

                    azucarValida = true;

                } else
                    System.out.println("\nNo hay azúcar suficiente, elija otra opción o presione 0 para continuar");

            } while (!azucarValida);

        } else
            System.out.println("\nNo hay ingredientes disponibles para el café que quiere");

    }

    private void imprimirListaCafes()
    {
        String puedoDarteCambio;

        System.out.println("----------Cafés disponibles----------");

        for (int i = 0; i < TiposCafe.values().length; i++)
        {
            if (TiposCafe.values()[i].getPrecio() > usuario.getSaldoCliente())
                continue;

            puedoDarteCambio = validarCambio(saldoCafetera, usuario.getSaldoCliente() - TiposCafe.values()[i].getPrecio()) ? "" : "<No podré darte cambio>";

            System.out.printf("\n%-5s%-20sPrecio: $%-10s%s", String.valueOf(i + 1) + ".-", TiposCafe.values()[i].getTipo(), TiposCafe.values()[i].getPrecio(), puedoDarteCambio);
        }

        System.out.printf("\n\nSu saldo: $%d\nSaldo disponible en la cafetera: $%d\n", usuario.getSaldoCliente(), obtenerSaldoCafetera());
    }

    private boolean validarCambio(ContenedorMonedas contenedor, int precio)
    {

        precio = restarPrecio(precio, contenedor.getN_monedas50(), 50);

        precio = restarPrecio(precio, contenedor.getN_monedas20(), 20);

        precio = restarPrecio(precio, contenedor.getN_monedas10(), 10);

        return precio == 0;
    }

    private int restarPrecio(int precio, int moneda, int valor)
    {
        if (precio >= valor && moneda != 0)
        {
            int precioBillete = precio - (precio % valor);

            precio -= ((moneda <= (precioBillete / valor)) ? (moneda * valor) : precioBillete);
        }

        return precio;
    }

    private boolean validarIngredientesNecesarios(int index)
    {
        TiposCafe cafe = TiposCafe.values()[index];

        return cafe.getAguaNecesaria() <= contenedores.get(0).getContenidoActual()
                && cafe.getLecheNecesaria() <= contenedores.get(1).getContenidoActual()
                && cafe.getCafeNecesario() <= contenedores.get(2).getContenidoActual();

    }

    private void actualizarContenedores(int nivelAzucar, int index)
    {
        TiposCafe cafe = TiposCafe.values()[index];

        contenedores.get(0).setContenidoActual(contenedores.get(0).getContenidoActual() - cafe.getAguaNecesaria());
        contenedores.get(1).setContenidoActual(contenedores.get(1).getContenidoActual() - cafe.getLecheNecesaria());
        contenedores.get(2).setContenidoActual(contenedores.get(2).getContenidoActual() - cafe.getCafeNecesario());
        contenedores.get(3).setContenidoActual(contenedores.get(3).getContenidoActual() - nivelAzucar * 0.1f);

    }

    public void retirarDinero(ContenedorMonedas contenedor, int dinero)
    {
        System.out.println("\n----------Retire su dinero----------");

        int aux = restarPrecio(dinero, contenedor.getN_monedas50(), 50);
        contenedor.setN_monedas50(contenedor.getN_monedas50() - (dinero - aux) / 50);
        System.out.println("\nMonedas de 50: " + (dinero - aux) / 50);
        dinero = aux;

        aux = restarPrecio(dinero, contenedor.getN_monedas20(), 20);
        contenedor.setN_monedas20(contenedor.getN_monedas20() - (dinero - aux) / 20);
        System.out.println("Monedas de 20: " + (dinero - aux) / 20);
        dinero = aux;

        contenedor.setN_monedas10(contenedor.getN_monedas10() - dinero / 10);
        System.out.println("Monedas de 10: " + dinero / 10);

        dineroDisponibleOrdenadoNomina("\n----------Monedas en la cafetara para dar cambio----------", saldoCafetera);
        dineroDisponibleOrdenadoNomina("\n----------Ganancias de la cafetera----------", saldoGanancias);

    }

    private void dineroDisponibleOrdenadoNomina(String text, ContenedorMonedas contenedor)
    {
        System.out.println(text);

        System.out.println(contenedor);

    }

    private void generarRegistros(TiposCafe cafe) throws IOException
    {
        String lineSeparator = System.getProperty("line.separator");

        try (Formatter out = new Formatter(new FileWriter(file, true)))
        {
            out.format("%s%4$s%-30s%s%s", "Fecha: " + String.format("%tF %1$tr", Calendar.getInstance()), "Tipo: " + cafe.getTipo(), "Precio: $" + cafe.getPrecio(), lineSeparator);
            out.format("%s%s%3$s%3$s", "Dinero en la cefetera $" + saldoCafetera.getTotal(), saldoCafetera, lineSeparator);
        }

        try (Formatter out = new Formatter(new FileWriter(new File("res/DineroCafetera.txt"))))
        {
            out.format("%s;%s;%s", saldoCafetera.getN_monedas50(), saldoCafetera.getN_monedas20(), saldoCafetera.getN_monedas10());
        }

    }

    public int obtenerSaldoCafetera()
    {
        return saldoCafetera.getTotal();
    }

    private boolean sinDinero()
    {
        return saldoCafetera.getN_monedas50() == 0 && saldoCafetera.getN_monedas20() == 0 && saldoCafetera.getN_monedas10() == 0;
    }

    private boolean cafeteraDescompuesta()
    {
        return new Random().nextInt(40) == 5;
    }

}
