package controller;

import model.Producto;
import persistencia.FileProduct;
import view.ViewProducto;

public class ControllerProducto
{

    private Producto modelo;
    private ViewProducto view;
    /*public void setprecio(String m){
     this.precio = m;
     }*/

    public ControllerProducto(Producto modelo, ViewProducto view)
    {

        this.modelo = modelo;
        this.view = view;
    }

    public ControllerProducto(ViewProducto view)
    {

        this.view = view;
    }

    public Producto getModelo()
    {
        return modelo;
    }

    public void setModelo(Producto modelo)
    {
        this.modelo = modelo;
    }

    public ViewProducto getView()
    {
        return view;
    }

    public void setView(ViewProducto view)
    {
        this.view = view;
    }

    public void ValidarProducto()
    {
        String nombre = view.getjTextFieldNombre().getText();
        String categoria = (String) view.getjComboBoxCategoria().getSelectedItem();
        String precio = view.getjTextFieldPrecio().getText();
        float precionum = 0;
        Producto producto;
        FileProduct file;
        try
        {

            precionum = Float.parseFloat(precio);
            producto = new Producto(nombre, categoria, precionum);
            file = new FileProduct();
            file.AgregarProducto(producto);

        } catch (NumberFormatException e)
        {
            view.mostrarMensajeErrorPrecio("Error de precio,ingrese un"
                    + " valor numerico");
        }

    }

}
