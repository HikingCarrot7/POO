package controller;

import inventario.CatalogoProductos;
import java.util.ArrayList;
import model.Producto;
import view.ViewCatalogoProductos;

/**
 *
 * @author edgar.cambranes
 */
public class ControllerCatalogoProducto
{

    private final ViewCatalogoProductos viewCatalogoProductos;
    private ArrayList<Producto> listaDeProductos;

    public ControllerCatalogoProducto(ViewCatalogoProductos viewCatalogoProductos, ArrayList<Producto> listaDeProductos)
    {
        this.viewCatalogoProductos = viewCatalogoProductos;
        this.listaDeProductos = listaDeProductos;

    }

    public ControllerCatalogoProducto(ViewCatalogoProductos viewCatalogoProductos)
    {
        this.viewCatalogoProductos = viewCatalogoProductos;

    }

    public void inicializarLista()
    {
        CatalogoProductos catalogoProductos = new CatalogoProductos();
        listaDeProductos = catalogoProductos.getListProduct();

    }

    public void showFirst()
    {
        Producto producto = listaDeProductos.get(0);
        viewCatalogoProductos.setjTextFieldAllValues(producto.getNombre(),
                producto.getCategoria(),
                "$" + producto.getPrecio());
    }

    public void showNext()
    {
    }

    public void showPrevious()
    {
    }
}
