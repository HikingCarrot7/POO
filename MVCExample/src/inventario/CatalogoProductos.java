/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Producto;

/**
 *
 * @author edgar.cambranes
 */
public class CatalogoProductos
{

    ArrayList<Producto> listProduct;

    public CatalogoProductos()
    {
        listProduct = new ArrayList<>();
    }

    public ArrayList<Producto> getListProduct()
    {

        File file = new File("producto.txt");

        try
        {

            try (Scanner sc = new Scanner(file))
            {
                while (sc.hasNextLine())
                {
                    String line = sc.nextLine();
                    listProduct.add(stringToProduct(line));
                    
                }
            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return listProduct;
    }

    public Producto stringToProduct(String line)
    {

        String[] split = line.split(",");
        Producto producto = new Producto(split[0], split[1], Float.parseFloat(split[2]));

        return producto;
    }

}
