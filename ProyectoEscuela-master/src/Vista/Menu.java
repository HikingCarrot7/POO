/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Login.Usuario;

/////Se actualizo
/**
 *
 * @author Daniel Poot
 */
public class Menu extends javax.swing.JFrame
{

    public static Registros VRegistro;
    public static VAsistencia VAsistencias;
    public static Eliminar VEliminar;
    public static Modificaciones VModificar;

    Usuario Mod;

    /**
     * Creates new form Menu
     */
    public Menu()
    {
        initComponents();
    }

    public Menu(Usuario Mod)
    {
        initComponents();
        setLocationRelativeTo(null);
        this.Mod = Mod;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        MenuLb = new javax.swing.JLabel();
        BtRegistrarMenu = new javax.swing.JButton();
        BtConsultaMenu = new javax.swing.JButton();
        BtModificarMenu = new javax.swing.JButton();
        BtAsistenicaMenu = new javax.swing.JButton();
        BtEliminarMenu = new javax.swing.JButton();
        BtPagos = new javax.swing.JToggleButton();
        BtSalirMenu = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MenuLb.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        MenuLb.setText("Menu");

        BtRegistrarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Registrar.png"))); // NOI18N
        BtRegistrarMenu.setText("Registrar");
        BtRegistrarMenu.setBorder(null);
        BtRegistrarMenu.setBorderPainted(false);
        BtRegistrarMenu.setContentAreaFilled(false);
        BtRegistrarMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/RegistrarP.png"))); // NOI18N
        BtRegistrarMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/RegistrarS.png"))); // NOI18N
        BtRegistrarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtRegistrarMenuMouseClicked(evt);
            }
        });

        BtConsultaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Search Property_96px.png"))); // NOI18N
        BtConsultaMenu.setText("Consultas");
        BtConsultaMenu.setBorder(null);
        BtConsultaMenu.setBorderPainted(false);
        BtConsultaMenu.setContentAreaFilled(false);
        BtConsultaMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Search Property_96pxP.png"))); // NOI18N
        BtConsultaMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Search Property_96pxS.png"))); // NOI18N
        BtConsultaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultaMenuActionPerformed(evt);
            }
        });

        BtModificarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Modificar.png"))); // NOI18N
        BtModificarMenu.setText("Modificar");
        BtModificarMenu.setBorder(null);
        BtModificarMenu.setBorderPainted(false);
        BtModificarMenu.setContentAreaFilled(false);
        BtModificarMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/ModificarP.png"))); // NOI18N
        BtModificarMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/ModificarS.png"))); // NOI18N
        BtModificarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtModificarMenuMouseClicked(evt);
            }
        });

        BtAsistenicaMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Asistenica.png"))); // NOI18N
        BtAsistenicaMenu.setText("Asistencias");
        BtAsistenicaMenu.setBorder(null);
        BtAsistenicaMenu.setBorderPainted(false);
        BtAsistenicaMenu.setContentAreaFilled(false);
        BtAsistenicaMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/AsistenicaP.png"))); // NOI18N
        BtAsistenicaMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/AsistenicaS.png"))); // NOI18N
        BtAsistenicaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtAsistenicaMenuMouseClicked(evt);
            }
        });

        BtEliminarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Eliminar.png"))); // NOI18N
        BtEliminarMenu.setText("Eliminar");
        BtEliminarMenu.setBorder(null);
        BtEliminarMenu.setBorderPainted(false);
        BtEliminarMenu.setContentAreaFilled(false);
        BtEliminarMenu.setMaximumSize(new java.awt.Dimension(96, 96));
        BtEliminarMenu.setMinimumSize(new java.awt.Dimension(96, 96));
        BtEliminarMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarP.png"))); // NOI18N
        BtEliminarMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarS.png"))); // NOI18N
        BtEliminarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtEliminarMenuMouseClicked(evt);
            }
        });

        BtPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Money Bag_96px.png"))); // NOI18N
        BtPagos.setText("df");
        BtPagos.setBorder(null);
        BtPagos.setBorderPainted(false);
        BtPagos.setContentAreaFilled(false);
        BtPagos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Money Bag_96pxP.png"))); // NOI18N
        BtPagos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Money Bag_96pxS.png"))); // NOI18N

        BtSalirMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48.png"))); // NOI18N
        BtSalirMenu.setText("Salir");
        BtSalirMenu.setBorder(null);
        BtSalirMenu.setBorderPainted(false);
        BtSalirMenu.setContentAreaFilled(false);
        BtSalirMenu.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48P.png"))); // NOI18N
        BtSalirMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48S.png"))); // NOI18N
        BtSalirMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtSalirMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtRegistrarMenu)
                    .addComponent(BtAsistenicaMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuLb)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtSalirMenu)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtModificarMenu)
                                .addComponent(BtConsultaMenu))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(BtEliminarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtPagos))))))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(MenuLb)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRegistrarMenu)
                    .addComponent(BtModificarMenu)
                    .addComponent(BtEliminarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtAsistenicaMenu)
                    .addComponent(BtConsultaMenu)
                    .addComponent(BtPagos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(BtSalirMenu)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtConsultaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultaMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtConsultaMenuActionPerformed

    private void BtRegistrarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtRegistrarMenuMouseClicked
        // TODO add your handling code here:
        if (VRegistro == null)
        {
            Registros.VMenu = null;
            this.dispose();
            VRegistro = new Registros(Mod);
            VRegistro.setVisible(true);
        }

    }//GEN-LAST:event_BtRegistrarMenuMouseClicked

    private void BtAsistenicaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtAsistenicaMenuMouseClicked
        // TODO add your handling code here:
        if (VAsistencias == null)
        {
            VAsistencia.VMenuAsistencia = null;
            VAsistencias = new VAsistencia(Mod);
            VAsistencias.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_BtAsistenicaMenuMouseClicked

    private void BtEliminarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEliminarMenuMouseClicked
        // TODO add your handling code here:
        if (VEliminar == null)
        {
            Eliminar.VMenuEliminar = null;
            VEliminar = new Eliminar(Mod);
            VEliminar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtEliminarMenuMouseClicked

    private void BtModificarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtModificarMenuMouseClicked
        // TODO add your handling code here:
        if (VModificar == null)
        {
            Modificaciones.VMenuModificar = null;
            VModificar = new Modificaciones(Mod);
            VModificar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtModificarMenuMouseClicked

    private void BtSalirMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtSalirMenuMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BtSalirMenuMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new Menu().setVisible(true);

        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAsistenicaMenu;
    private javax.swing.JButton BtConsultaMenu;
    private javax.swing.JButton BtEliminarMenu;
    private javax.swing.JButton BtModificarMenu;
    private javax.swing.JToggleButton BtPagos;
    private javax.swing.JButton BtRegistrarMenu;
    private javax.swing.JButton BtSalirMenu;
    private javax.swing.JLabel MenuLb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
