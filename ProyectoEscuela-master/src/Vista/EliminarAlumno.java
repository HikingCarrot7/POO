/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Conectar;
import Clases.Render;
import Login.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shirl
 */
public class EliminarAlumno extends javax.swing.JFrame
{

    public Conectar ConexionMO = new Conectar();
    Connection CNMO = ConexionMO.getConnection();
    ResultSet rs;

    Usuario Mod;
    public static Eliminar VEliminar;

    public EliminarAlumno()
    {
        initComponents();
        btnEliminar.setVisible(false);
        /* BTModFecha.setVisible(false);
         ModFoto.setVisible(false);*/
        this.setLocationRelativeTo(null);
        TabladeAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeAlumnos.getSelectedRow() != -1)
                {
                    int fila = TabladeAlumnos.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_alumno.setText(TabladeAlumnos.getValueAt(fila, 0).toString());
                    txnombre.setText(TabladeAlumnos.getValueAt(fila, 1).toString());
                    txApellidoP.setText(TabladeAlumnos.getValueAt(fila, 2).toString());
                    txApellidoM.setText(TabladeAlumnos.getValueAt(fila, 3).toString());
                    txEdad.setText(TabladeAlumnos.getValueAt(fila, 4).toString());
                    txTelCel.setText(TabladeAlumnos.getValueAt(fila, 6).toString());
                    txFechaIng.setText(TabladeAlumnos.getValueAt(fila, 5).toString());
                    txGrupo.setText(TabladeAlumnos.getValueAt(fila, 7).toString());
                    txPagoIns.setText(TabladeAlumnos.getValueAt(fila, 8).toString());
                    txPagoMens.setText(TabladeAlumnos.getValueAt(fila, 9).toString());
                }
                btnEliminar.setVisible(true); /*BTModFecha.setVisible(true); ModFoto.setVisible(true);*/

            }
        });
    }

    EliminarAlumno(Usuario Mod)
    {
        this.Mod = Mod;
        initComponents();
        this.setLocationRelativeTo(null);
        btnEliminar.setVisible(false);
        /*BTModFecha.setVisible(false);
         ModFoto.setVisible(false);*/
        TabladeAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeAlumnos.getSelectedRow() != -1)
                {
                    int fila = TabladeAlumnos.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_alumno.setText(TabladeAlumnos.getValueAt(fila, 0).toString());
                    txnombre.setText(TabladeAlumnos.getValueAt(fila, 1).toString());
                    txApellidoP.setText(TabladeAlumnos.getValueAt(fila, 2).toString());
                    txApellidoM.setText(TabladeAlumnos.getValueAt(fila, 3).toString());
                    txEdad.setText(TabladeAlumnos.getValueAt(fila, 4).toString());
                    txTelCel.setText(TabladeAlumnos.getValueAt(fila, 6).toString());
                    txFechaIng.setText(TabladeAlumnos.getValueAt(fila, 5).toString());
                    txGrupo.setText(TabladeAlumnos.getValueAt(fila, 7).toString());
                    txPagoIns.setText(TabladeAlumnos.getValueAt(fila, 8).toString());
                    txPagoMens.setText(TabladeAlumnos.getValueAt(fila, 9).toString());
                }
                btnEliminar.setVisible(true); /*BTModFecha.setVisible(true);ModFoto.setVisible(true);*/

            }
        });
    }

    public void mostrardatos() throws IOException
    {
        TabladeAlumnos.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        modelo.addColumn("ID_alumno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de ingreso");
        modelo.addColumn("Grupo");
        modelo.addColumn("Pago de inscripcion");
        modelo.addColumn("Pago de mensualidad");
        modelo.addColumn("Foto");
        TabladeAlumnos.setModel(modelo);
        try
        {

            Statement st = CNMO.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ingresoalumnos a,grupos g WHERE a.IDGrupoAlumno=g.IDGrupo ");

            while (rs.next())
            {
                Object datos[] = new Object[11];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getInt(5);
                datos[5] = rs.getDate(6);
                datos[6] = rs.getLong(7);
                datos[7] = rs.getInt(11);
                datos[8] = rs.getDouble(9);
                datos[9] = rs.getDouble(10);
                try
                {
                    byte[] bi = rs.getBytes(8);
                    InputStream in = new ByteArrayInputStream(bi);
                    BufferedImage image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    datos[10] = new JLabel(imgi);
                } catch (Exception ex)
                {
                    datos[10] = rs.getByte("No imagen");
                }
                modelo.addRow(datos);

            }
            TabladeAlumnos.setModel(modelo);
            TabladeAlumnos.setRowHeight(60);

        } catch (SQLException ex)
        {
            Logger.getLogger(EliminarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Limpiarcajas()
    {
        txID_alumno.setText(null);
        txnombre.setText(null);
        txApellidoP.setText(null);
        txApellidoM.setText(null);
        txEdad.setText(null);
        txTelCel.setText(null);
        txFechaIng.setText(null);
        txGrupo.setText(null);
        txPagoIns.setText(null);
        txPagoMens.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txTelCel = new javax.swing.JTextField();
        lbApellidoP = new javax.swing.JLabel();
        lbApellidoM = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        lbTelCel = new javax.swing.JLabel();
        txApellidoP = new javax.swing.JTextField();
        lbID_alumno = new javax.swing.JLabel();
        txID_alumno = new javax.swing.JTextField();
        lbnombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        txApellidoM = new javax.swing.JTextField();
        txEdad = new javax.swing.JTextField();
        txFechaIng = new javax.swing.JTextField();
        txPagoIns = new javax.swing.JTextField();
        txPagoMens = new javax.swing.JTextField();
        txGrupo = new javax.swing.JTextField();
        lbFechaIng = new javax.swing.JLabel();
        lbGrupo = new javax.swing.JLabel();
        lbPagoIns = new javax.swing.JLabel();
        lbPagoMens = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabladeAlumnos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbApellidoP.setText("Apellido Paterno");

        lbApellidoM.setText("Apellido Materno");

        lbEdad.setText("Edad");

        lbTelCel.setText("Telefono Celular");

        lbID_alumno.setText("ID_alumno");

        txID_alumno.setEnabled(false);
        txID_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txID_alumnoActionPerformed(evt);
            }
        });

        lbnombre.setText("Nombre");

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        txApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txApellidoMActionPerformed(evt);
            }
        });

        txFechaIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFechaIngActionPerformed(evt);
            }
        });

        lbFechaIng.setText("Fecha de ingreso");

        lbGrupo.setText("Grupo");

        lbPagoIns.setText("Pago de inscripcion");

        lbPagoMens.setText("Pago de mensualidad");

        btnSalir.setText("Regresar");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        TabladeAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabladeAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladeAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabladeAlumnos);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Alumnos");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("ELIMINAR ALUMNO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbnombre)
                                    .addComponent(lbID_alumno))
                                .addGap(105, 105, 105)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txID_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbEdad)
                                    .addComponent(lbApellidoM)
                                    .addComponent(lbApellidoP)
                                    .addComponent(lbTelCel))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbGrupo)
                                        .addComponent(lbFechaIng))
                                    .addComponent(lbPagoIns))
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbPagoMens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txPagoMens, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txPagoIns, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(323, 323, 323))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnEliminar)
                        .addGap(142, 142, 142)
                        .addComponent(btnMostrar)
                        .addGap(113, 113, 113)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbID_alumno)
                            .addComponent(txID_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbnombre)
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellidoP))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellidoM))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEdad))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFechaIng)
                            .addComponent(txFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbPagoIns)
                            .addComponent(txPagoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPagoMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPagoMens))
                        .addGap(284, 284, 284)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnMostrar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txID_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txID_alumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txID_alumnoActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnombreActionPerformed

    private void txApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txApellidoMActionPerformed

    private void txFechaIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFechaIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txFechaIngActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        if (VEliminar == null)
        {
            Eliminar.VAlumnoEliminar = null;
            this.dispose();
            VEliminar = new Eliminar(Mod);
            VEliminar.setVisible(true);

        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void TabladeAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladeAlumnosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabladeAlumnosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        PreparedStatement Pst = null;
        try
        {

            Pst = ConexionMO.getConnection().prepareStatement("DELETE FROM ingresoalumnos WHERE IDAlumno = ?");
            Pst.setInt(1, Integer.parseInt(txID_alumno.getText()));

            int res = Pst.executeUpdate();

            if (res > 0)
            {
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
                Limpiarcajas();
                btnEliminar.setVisible(false);
            } else
            {
                JOptionPane.showMessageDialog(null, "Error al Eliminar el alumno");
                Limpiarcajas();
            }

        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        try
        {
            // TODO add your handling code here:
            mostrardatos();
        } catch (IOException ex)
        {
            Logger.getLogger(ModicarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnMostrarActionPerformed

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
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(EliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EliminarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new EliminarAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabladeAlumnos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellidoM;
    private javax.swing.JLabel lbApellidoP;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbFechaIng;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbID_alumno;
    private javax.swing.JLabel lbPagoIns;
    private javax.swing.JLabel lbPagoMens;
    private javax.swing.JLabel lbTelCel;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JTextField txApellidoM;
    private javax.swing.JTextField txApellidoP;
    private javax.swing.JTextField txEdad;
    private javax.swing.JTextField txFechaIng;
    private javax.swing.JTextField txGrupo;
    private javax.swing.JTextField txID_alumno;
    private javax.swing.JTextField txPagoIns;
    private javax.swing.JTextField txPagoMens;
    private javax.swing.JTextField txTelCel;
    private javax.swing.JTextField txnombre;
    // End of variables declaration//GEN-END:variables
}
