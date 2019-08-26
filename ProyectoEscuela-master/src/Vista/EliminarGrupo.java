/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Conectar;
import Clases.Render;
import Login.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shirl
 */
public class EliminarGrupo extends javax.swing.JFrame
{

    public Conectar ConexionMO = new Conectar();
    Connection CNMO = ConexionMO.getConnection();
    ResultSet rs;
    Usuario Mod;
    public static Modificaciones VEliminarG;

    public EliminarGrupo()
    {
        initComponents();
        btnEliminar.setVisible(false);

        this.setLocationRelativeTo(null);
        TabladeGrupos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeGrupos.getSelectedRow() != -1)
                {
                    int fila = TabladeGrupos.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_Grupo.setText(TabladeGrupos.getValueAt(fila, 0).toString());
                    txGrupo.setText(TabladeGrupos.getValueAt(fila, 1).toString());
                    txID_Horario2.setText(TabladeGrupos.getValueAt(fila, 2).toString());
                    ID_Maestro.setText(TabladeGrupos.getValueAt(fila, 3).toString());
                }
                btnEliminar.setVisible(true);
            }
        });
    }

    EliminarGrupo(Usuario Mod)
    {
        this.Mod = Mod;
        initComponents();
        btnEliminar.setVisible(false);

        this.setLocationRelativeTo(null);
        TabladeGrupos.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeGrupos.getSelectedRow() != -1)
                {
                    int fila = TabladeGrupos.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_Grupo.setText(TabladeGrupos.getValueAt(fila, 0).toString());
                    txGrupo.setText(TabladeGrupos.getValueAt(fila, 1).toString());
                    txID_Horario2.setText(TabladeGrupos.getValueAt(fila, 2).toString());
                    ID_Maestro.setText(TabladeGrupos.getValueAt(fila, 3).toString());
                }
                btnEliminar.setVisible(true);
            }
        });
    }

    public void mostrardatos() throws IOException
    {
        TabladeGrupos.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        modelo.addColumn("ID_Grupo");
        modelo.addColumn("Grupo");
        modelo.addColumn("ID_HorarioGrupo");
        modelo.addColumn("ID_HorarioMaestro");

        TabladeGrupos.setModel(modelo);
        try
        {

            Statement st = CNMO.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM grupos g, horario h, maestros m WHERE g.IDHorarioGrupo=h.IDHorario AND g.IDMaestroGrupo=m.IDMaestro");

            while (rs.next())
            {
                Object datos[] = new Object[4];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getInt(3);
                datos[3] = rs.getInt(4);

                modelo.addRow(datos);

            }
            TabladeGrupos.setModel(modelo);
            TabladeGrupos.setRowHeight(60);

        } catch (SQLException ex)
        {
            Logger.getLogger(EliminarGrupo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Limpiarcajas()
    {
        txID_Grupo.setText(null);
        txGrupo.setText(null);
        txID_Horario2.setText(null);
        ID_Maestro.setText(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ID_Maestro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbID_Horario1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabladeGrupos = new javax.swing.JTable();
        txID_Horario2 = new javax.swing.JTextField();
        lbID_Horario2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        txID_Grupo = new javax.swing.JTextField();
        lbID_Horario = new javax.swing.JLabel();
        txGrupo = new javax.swing.JTextField();
        lbGrupo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("ELIMINAR GRUPO");

        lbID_Horario1.setText("ID_Maestro Grupo");

        TabladeGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabladeGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladeGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabladeGrupos);

        lbID_Horario2.setText("ID_Horario Grupo");

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

        btnMostrar.setText("Mostrar Grupos");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        txID_Grupo.setEnabled(false);

        lbID_Horario.setText("ID_Grupo");

        lbGrupo.setText("Grupo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbGrupo)
                                        .addGap(52, 52, 52)
                                        .addComponent(txGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbID_Horario)
                                        .addGap(40, 40, 40)
                                        .addComponent(txID_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(283, 283, 283)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbID_Horario2)
                                                .addGap(40, 40, 40)
                                                .addComponent(txID_Horario2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbID_Horario1)
                                                .addGap(40, 40, 40)
                                                .addComponent(ID_Maestro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEliminar)
                        .addGap(117, 117, 117)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID_Horario)
                    .addComponent(txID_Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbID_Horario2)
                    .addComponent(txID_Horario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbID_Horario1)
                    .addComponent(ID_Maestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnMostrar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabladeGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladeGruposMouseClicked

    }//GEN-LAST:event_TabladeGruposMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        if (VEliminarG == null)
        {
            Eliminar.VEliminarGrupo = null;
            this.dispose();
            VEliminarG = new Modificaciones(Mod);
            VEliminarG.setVisible(true);

        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        PreparedStatement Pst = null;

        try
        {

            Pst = ConexionMO.getConnection().prepareStatement("DELETE FROM grupos WHERE IDGrupo=? ");
            Pst.setInt(1, Integer.parseInt(txID_Grupo.getText()));

            int res = Pst.executeUpdate();

            if (res > 0)
            {
                JOptionPane.showMessageDialog(null, "Grupo Eliminado");
                Limpiarcajas();
                btnEliminar.setVisible(false);
            } else
            {
                JOptionPane.showMessageDialog(null, "Error al eliminar el grupo");
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
            Logger.getLogger(EliminarGrupo.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(EliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(EliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(EliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(EliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new EliminarGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID_Maestro;
    private javax.swing.JTable TabladeGrupos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbID_Horario;
    private javax.swing.JLabel lbID_Horario1;
    private javax.swing.JLabel lbID_Horario2;
    private javax.swing.JTextField txGrupo;
    private javax.swing.JTextField txID_Grupo;
    private javax.swing.JTextField txID_Horario2;
    // End of variables declaration//GEN-END:variables
}
