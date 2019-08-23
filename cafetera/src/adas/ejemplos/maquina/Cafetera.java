package adas.ejemplos.maquina;

import adas.ejemplos.productos.TiposCafe;
import adas.ejemplos.usuario.Cliente;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HikingCarrot7
 */
public class Cafetera
{

    private final Cliente cliente;
    private final ArrayList<ContenedorIngredientes> contenedores;
    private final int n_billetes50, n_billetes20, n_monedas10;
    private int saldoCliente, totalVendido;

    public Cafetera(int n_billetes50, int n_billetes20, int n_monedas10)
    {
        this.n_billetes50 = n_billetes50;
        this.n_billetes20 = n_billetes20;
        this.n_monedas10 = n_monedas10;

        cliente = new Cliente(this);

        contenedores = new ArrayList<>();

        contenedores.add(new ContenedorIngredientes("Agua", 25f));
        contenedores.add(new ContenedorIngredientes("Leche", 25f));
        contenedores.add(new ContenedorIngredientes("Café", 30f));
        contenedores.add(new ContenedorIngredientes("Azúcar", 30f));

    }

    public void despacharCliente()
    {
        if (!sinDinero())
        {
            cliente.InsertarDinero();

        } else
        {
            System.out.println("Disculpe, la cafetera se quedó sin dinero!");
        }

    }

    public void despacharCafe()
    {

        imprimirListaCafes();

        int indexCafe = cliente.obtenerOpcionProducto();

        if (validarIngredientesNecesarios(indexCafe))
        {
            float azucarActual = contenedores.get(3).getContenidoActual();
            int nivelAzucar;
            boolean azucarValida = false;

            if (azucarActual != 0)
            {
                System.out.println("\nNiveles de azúcar disponibles ");

                for (int i = 0; i < 3; i++)
                {
                    if ((i + 1) * 0.1f <= azucarActual)
                    {
                        System.out.print((i + 1) + ". ");
                    }
                }

            } else
            {
                System.out.println("\nNo hay azúcar, presione 0 para continuar");
            }

            do
            {

                nivelAzucar = cliente.obtenerNivelAzucar();

                if (nivelAzucar * 0.1f <= azucarActual)
                {
                    actualizarContenedores(nivelAzucar, indexCafe);

                    System.out.println("\n" + TiposCafe.values()[indexCafe].getDescripcion());

                    retirarDinero(saldoCliente - TiposCafe.values()[indexCafe].getPrecio());

                    azucarValida = true;

                } else
                {
                    System.out.println("\nNo hay azúcar suficiente, elija otra opción o presione 0 para continuar");
                }

            } while (!azucarValida);

        } else
        {
            System.out.println("\nNo hay ingredientes disponibles para el café que quiere");
        }

    }

    private void imprimirListaCafes()
    {
        String puedoDarteCambio;

        System.out.println("----------Cafés disponibles----------");

        for (int i = 0; i < TiposCafe.values().length; i++)
        {
            if (TiposCafe.values()[i].getPrecio() > saldoCliente)
            {
                continue;
            }

            puedoDarteCambio = validarCambio(saldoCliente - TiposCafe.values()[i].getPrecio()) ? "" : "<No podré darte cambio>";

            System.out.printf("\n%-5s%-20sPrecio: $%-10s%s", String.valueOf(i + 1) + ".-", TiposCafe.values()[i].getTipo(), TiposCafe.values()[i].getPrecio(), puedoDarteCambio);
        }

        System.out.printf("\n\nSu saldo: $%d\nSaldo disponible en la cafetera: $%d\nGanancias de la cafetera: $%d", saldoCliente, obtenerSaldoCafetera(), totalVendido);
    }

    private boolean validarCambio(int precio)
    {

        precio = comprobarPrecio(precio, n_billetes50, 50);

        precio = comprobarPrecio(precio, n_billetes20, 20);

        precio = comprobarPrecio(precio, n_monedas10, 10);

        return precio == 0;
    }

    private int comprobarPrecio(int precio, int moneda, int valor)
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

    private void retirarDinero(int dinero)
    {

    }

    public void setSaldoCliente(int saldoCliente)
    {
        this.saldoCliente = saldoCliente;
    }

    public int obtenerSaldoCafetera()
    {
        return n_billetes50 * 50 + n_billetes20 * 20 + n_monedas10 * 10;
    }

    private boolean sinDinero()
    {
        return n_billetes50 == 0 && n_billetes20 == 0 && n_monedas10 == 0;
    }

    private boolean cafeteraDescompuesta()
    {
        return new Random().nextInt(10) == 5;
    }

}
