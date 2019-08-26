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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shirl
 */
public class EliminarMaestro extends javax.swing.JFrame
{

    public Conectar ConexionMO = new Conectar();
    Connection CNMOM = ConexionMO.getConnection();
    ResultSet rs;
    Usuario Mod;

    public static Eliminar VEliminarM;

    public EliminarMaestro()
    {
        initComponents();
        btnEliminar.setVisible(false);
        this.setLocationRelativeTo(null);
        TabladeMaestros.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeMaestros.getSelectedRow() != -1)
                {
                    int fila = TabladeMaestros.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_Maestro.setText(TabladeMaestros.getValueAt(fila, 0).toString());
                    txnombre.setText(TabladeMaestros.getValueAt(fila, 1).toString());
                    txApellidoP.setText(TabladeMaestros.getValueAt(fila, 2).toString());
                    txApellidoM.setText(TabladeMaestros.getValueAt(fila, 3).toString());
                    txEdad.setText(TabladeMaestros.getValueAt(fila, 4).toString());
                    txTelCel.setText(TabladeMaestros.getValueAt(fila, 6).toString());
                    txFechaIng.setText(TabladeMaestros.getValueAt(fila, 5).toString());
                    txAñosE.setText(TabladeMaestros.getValueAt(fila, 7).toString());

                }
                btnEliminar.setVisible(true);
            }
        });
    }

    EliminarMaestro(Usuario Mod)
    {
        this.Mod = Mod;
        initComponents();
        this.setLocationRelativeTo(null);
        btnEliminar.setVisible(false);
        TabladeMaestros.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeMaestros.getSelectedRow() != -1)
                {
                    int fila = TabladeMaestros.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_Maestro.setText(TabladeMaestros.getValueAt(fila, 0).toString());
                    txnombre.setText(TabladeMaestros.getValueAt(fila, 1).toString());
                    txApellidoP.setText(TabladeMaestros.getValueAt(fila, 2).toString());
                    txApellidoM.setText(TabladeMaestros.getValueAt(fila, 3).toString());
                    txEdad.setText(TabladeMaestros.getValueAt(fila, 4).toString());
                    txTelCel.setText(TabladeMaestros.getValueAt(fila, 6).toString());
                    txFechaIng.setText(TabladeMaestros.getValueAt(fila, 5).toString());
                    txAñosE.setText(TabladeMaestros.getValueAt(fila, 7).toString());
                }
                btnEliminar.setVisible(true);
            }
        });
    }

    public void mostrardatos() throws IOException
    {
        TabladeMaestros.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        modelo.addColumn("ID_Maestro");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de ingreso");
        modelo.addColumn("Años de experiencia");
        modelo.addColumn("Foto");
        TabladeMaestros.setModel(modelo);
        try
        {

            Statement st = CNMOM.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM maestros");

            while (rs.next())
            {
                Object datos[] = new Object[9];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getInt(5);
                datos[5] = rs.getDate(6);
                datos[6] = rs.getLong(7);
                datos[7] = rs.getInt(9);
                try
                {
                    byte[] bi = rs.getBytes(8);
                    InputStream in = new ByteArrayInputStream(bi);
                    BufferedImage image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    datos[8] = new JLabel(imgi);
                } catch (Exception ex)
                {
                    datos[8] = rs.getByte("No imagen");
                }
                modelo.addRow(datos);

            }
            TabladeMaestros.setModel(modelo);
            TabladeMaestros.setRowHeight(60);

        } catch (SQLException ex)
        {
            Logger.getLogger(EliminarMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Limpiarcajas()
    {
        txID_Maestro.setText(null);
        txnombre.setText(null);
        txApellidoP.setText(null);
        txApellidoM.setText(null);
        txEdad.setText(null);
        txTelCel.setText(null);
        txFechaIng.setText(null);
        txAñosE.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txTelCel = new javax.swing.JTextField();
        lbApellidoP = new javax.swing.JLabel();
        lbApellidoM = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        lbTelCel = new javax.swing.JLabel();
        txApellidoP = new javax.swing.JTextField();
        lbID_Maestro = new javax.swing.JLabel();
        txID_Maestro = new javax.swing.JTextField();
        lbnombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        txApellidoM = new javax.swing.JTextField();
        txEdad = new javax.swing.JTextField();
        txFechaIng = new javax.swing.JTextField();
        lbFechaIng = new javax.swing.JLabel();
        lbAñosE = new javax.swing.JLabel();
        txAñosE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabladeMaestros = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("ELIMINAR MAESTRO");

        lbApellidoP.setText("Apellido Paterno");

        lbApellidoM.setText("Apellido Materno");

        lbEdad.setText("Edad");

        lbTelCel.setText("Telefono Celular");

        lbID_Maestro.setText("ID_Maestro");

        txID_Maestro.setEnabled(false);

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

        lbAñosE.setText("Años de experiencia");

        txAñosE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txAñosEActionPerformed(evt);
            }
        });

        TabladeMaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabladeMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladeMaestrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabladeMaestros);

        btnSalir.setText("Regresar");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Maestros");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbID_Maestro)
                                .addComponent(lbnombre)
                                .addComponent(lbApellidoP)
                                .addComponent(lbApellidoM))
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txID_Maestro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbAñosE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txAñosE, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbFechaIng)
                                        .addComponent(lbTelCel))
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txFechaIng)
                                        .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbEdad)
                            .addGap(96, 96, 96)
                            .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(151, 151, 151)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(btnEliminar)
                            .addGap(93, 93, 93)
                            .addComponent(btnMostrar)
                            .addGap(93, 93, 93)
                            .addComponent(btnSalir)
                            .addGap(69, 69, 69))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID_Maestro)
                    .addComponent(txID_Maestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelCel)
                    .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnombre)
                    .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFechaIng)
                    .addComponent(txFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellidoP)
                    .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAñosE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAñosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEdad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnMostrar)
                        .addComponent(btnSalir))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed

    }//GEN-LAST:event_txnombreActionPerformed

    private void txApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txApellidoMActionPerformed

    private void txFechaIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFechaIngActionPerformed

    }//GEN-LAST:event_txFechaIngActionPerformed

    private void txAñosEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txAñosEActionPerformed

    }//GEN-LAST:event_txAñosEActionPerformed

    private void TabladeMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladeMaestrosMouseClicked

    }//GEN-LAST:event_TabladeMaestrosMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        if (VEliminarM == null)
        {
            Eliminar.VMaestroEliminar = null;
            this.dispose();
            VEliminarM = new Eliminar(Mod);
            VEliminarM.setVisible(true);

        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        PreparedStatement Pst = null;

        try
        {

            Pst = ConexionMO.getConnection().prepareStatement("DELETE IDMaestro * FROM maestros  WHERE IDMaestro=? ");
            Pst.setInt(1, Integer.parseInt(txID_Maestro.getText()));

            int res = Pst.executeUpdate();

            if (res > 0)
            {
                JOptionPane.showMessageDialog(null, "Maestro eliminadoado");
                Limpiarcajas();
                btnEliminar.setVisible(false);
            } else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar Maestro");
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
            Logger.getLogger(EliminarMaestro.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(EliminarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EliminarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EliminarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EliminarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new EliminarMaestro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabladeMaestros;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellidoM;
    private javax.swing.JLabel lbApellidoP;
    private javax.swing.JLabel lbAñosE;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbFechaIng;
    private javax.swing.JLabel lbID_Maestro;
    private javax.swing.JLabel lbTelCel;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JTextField txApellidoM;
    private javax.swing.JTextField txApellidoP;
    private javax.swing.JTextField txAñosE;
    private javax.swing.JTextField txEdad;
    private javax.swing.JTextField txFechaIng;
    private javax.swing.JTextField txID_Maestro;
    private javax.swing.JTextField txTelCel;
    private javax.swing.JTextField txnombre;
    // End of variables declaration//GEN-END:variables
}
