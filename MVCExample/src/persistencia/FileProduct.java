package persistencia;

import model.Producto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileProduct
{

    public static void AgregarProducto(Producto product)
    {

        File fProduct = new File("producto.txt");

        try
        {
            if (!fProduct.exists())
                fProduct.createNewFile();

            FileWriter fwProduct = new FileWriter(fProduct, true);

            try (BufferedWriter bwProduct = new BufferedWriter(fwProduct))
            {
                bwProduct.write(product + "\n");
            }

        } catch (IOException ioe)
        {
            // Dear programmer put this magical code here, please. Xoxo.
        }

    }

}
