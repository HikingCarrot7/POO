/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Adrián
 */
public class Producto
{

    //Atributos

    private String nombre;
    private String categoria;
    private float precio;

    public Producto(String nombre, String categoria, float precio)
    {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    //Métodos
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public float getPrecio()
    {
        return precio;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }

    @Override
    public String toString()
    {
        return nombre + "," + categoria + "," + precio;
    }

}
