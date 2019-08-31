/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Grupo;
import Datos.BaseDatos;
import Modulos.Alumno;
import Modulos.Maestro;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LuisMartinez
 */
public class ConsultasMaestros extends javax.swing.JFrame
{

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos base = new BaseDatos();

    /**
     * Creates new form ConsultasMaestros
     */
    public ConsultasMaestros()
    {
        initComponents();
        cargarModeloTabla();
    }

    private void cargarModeloTabla()
    {
        modeloTabla.addColumn("IDMaestro");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("ApellidoPaterno");
        modeloTabla.addColumn("ApellidoMaterno");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("FechaIngreso");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Foto");
        modeloTabla.addColumn("Experiencia");

        ArrayList<Maestro> listaMaestros = base.obtenerMaestros();
        int numeroMaestros = listaMaestros.size();
        modeloTabla.setNumRows(numeroMaestros);

        for (int i = 0; i < numeroMaestros; i++)
        {
            Maestro maestro = listaMaestros.get(i);
            Integer id = maestro.getIDMaestro();
            String nombre = maestro.getNombre();
            String apellidoPaterno = maestro.getApellidoPaterno();
            String apellidoMaterno = maestro.getApellidoMaterno();
            Integer edad = maestro.getEdad();
            Date fechaIngreso = maestro.getFechaInicio();
            Long telefono = maestro.getNumCelular();
            byte[] foto = maestro.getFotografia();
            Integer experiencia = maestro.getAñosExp();

            modeloTabla.setValueAt(id, i, 0);
            modeloTabla.setValueAt(nombre, i, 1);
            modeloTabla.setValueAt(apellidoPaterno, i, 2);
            modeloTabla.setValueAt(apellidoMaterno, i, 3);
            modeloTabla.setValueAt(edad, i, 4);
            modeloTabla.setValueAt(fechaIngreso, i, 5);
            modeloTabla.setValueAt(telefono, i, 6);
            modeloTabla.setValueAt(foto, i, 7);
            modeloTabla.setValueAt(experiencia, i, 8);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrupos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Lista de Grupos");

        tablaGrupos.setModel(modeloTabla);
        jScrollPane1.setViewportView(tablaGrupos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(359, 359, 359))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConsultasMaestros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGrupos;
    // End of variables declaration//GEN-END:variables
}
