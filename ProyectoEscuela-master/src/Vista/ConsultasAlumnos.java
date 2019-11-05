/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Grupo;
import Datos.BaseDatos;
import Modulos.Alumno;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LuisMartinez
 */
public class ConsultasAlumnos extends javax.swing.JFrame
{

    DefaultTableModel modeloTabla = new DefaultTableModel();
    BaseDatos base = new BaseDatos();

    /**
     * Creates new form ConsultasAlumnos
     */
    public ConsultasAlumnos()
    {
        initComponents();
        cargarModeloTabla();
    }

    private void cargarModeloTabla()
    {
        modeloTabla.addColumn("IDAlumno");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("ApellidoPaterno");
        modeloTabla.addColumn("ApellidoMaterno");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("FechaIngreso");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Foto");
        modeloTabla.addColumn("Mensualidad");
        modeloTabla.addColumn("Inscripcion");

        ArrayList<Alumno> listaAlumnos = base.obtenerAlumnos();
        int numeroAlumnos = listaAlumnos.size();
        modeloTabla.setNumRows(numeroAlumnos);

        for (int i = 0; i < numeroAlumnos; i++)
        {
            Alumno alumno = listaAlumnos.get(i);
            Integer id = alumno.getID();
            String nombre = alumno.getNombre();
            String apellidoPaterno = alumno.getApellidoPaterno();
            String apellidoMaterno = alumno.getApellidoMaterno();
            Integer edad = alumno.getEdad();
            Date fechaIngreso = alumno.getFechaInscripcion();
            Long telefono = alumno.getNumCelular();
            byte[] foto = alumno.getFotografia();
            Double mensualidad = alumno.getCostoMensualidad();
            Double inscripcion = alumno.getCostoMensualidad();
            Grupo grupo = alumno.getGrupoAlumno();

            modeloTabla.setValueAt(id, i, 0);
            modeloTabla.setValueAt(nombre, i, 1);
            modeloTabla.setValueAt(apellidoPaterno, i, 2);
            modeloTabla.setValueAt(apellidoMaterno, i, 3);
            modeloTabla.setValueAt(edad, i, 4);
            modeloTabla.setValueAt(fechaIngreso, i, 5);
            modeloTabla.setValueAt(telefono, i, 6);
            modeloTabla.setValueAt(foto, i, 7);
            modeloTabla.setValueAt(mensualidad, i, 8);
            modeloTabla.setValueAt(inscripcion, i, 9);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        TabladeAlumnos = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAlumnos.setModel(modeloTabla);
        TabladeAlumnos.setViewportView(tablaAlumnos);

        jLabel1.setText("Lista de Alumnos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TabladeAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(TabladeAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ConsultasAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ConsultasAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ConsultasAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TabladeAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
