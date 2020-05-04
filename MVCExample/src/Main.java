
/**
 *
 * @author edgar.cambranes
 */
import java.awt.EventQueue;
import view.ViewProducto;

public class Main
{

    public static void main(String args[])
    {
        EventQueue.invokeLater(() ->
        {
            new ViewProducto().setVisible(true);
        });
    }
}
