/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Login.Usuario;

/**
 *
 * @author Daniel Poot
 */
public class Modificaciones extends javax.swing.JFrame
{

    public static Menu VMenuModificar;
    public static ModicarAlumno VModicarAlumno;
    public static ModificarMaestro VModificarMaestro;
    public static ModificarGrupo VModificarGrupo;

    Usuario Mod;

    /**
     * Creates new form Registros
     */
    public Modificaciones()
    {
        initComponents();
    }

    public Modificaciones(Usuario Mod)
    {
        initComponents();
        this.Mod = Mod;
        setLocationRelativeTo(null);

        if (Mod.getIDTipo() == 1)
        {

        } else if (Mod.getIDTipo() == 2)
            BtModificarUsuario.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtModificarAlumno = new javax.swing.JButton();
        BtModificarMaestro = new javax.swing.JButton();
        BtModificarUsuario = new javax.swing.JButton();
        BtModificarModificar = new javax.swing.JLabel();
        BtModificarGrupo = new javax.swing.JButton();
        BtRegresarModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtModificarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/ModificarAlumno.png"))); // NOI18N
        BtModificarAlumno.setText("Alumno");
        BtModificarAlumno.setBorder(null);
        BtModificarAlumno.setBorderPainted(false);
        BtModificarAlumno.setContentAreaFilled(false);
        BtModificarAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtModificarAlumnoMouseClicked(evt);
            }
        });
        BtModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtModificarAlumnoActionPerformed(evt);
            }
        });

        BtModificarMaestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/ModProfesor.png"))); // NOI18N
        BtModificarMaestro.setText("Maestro");
        BtModificarMaestro.setBorder(null);
        BtModificarMaestro.setBorderPainted(false);
        BtModificarMaestro.setContentAreaFilled(false);
        BtModificarMaestro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtModificarMaestroMouseClicked(evt);
            }
        });

        BtModificarUsuario.setText("Usuario");

        BtModificarModificar.setText("Modificar");

        BtModificarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/ModGrupo.png"))); // NOI18N
        BtModificarGrupo.setText("Grupo");
        BtModificarGrupo.setBorder(null);
        BtModificarGrupo.setBorderPainted(false);
        BtModificarGrupo.setContentAreaFilled(false);
        BtModificarGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtModificarGrupoMouseClicked(evt);
            }
        });

        BtRegresarModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48.png"))); // NOI18N
        BtRegresarModificar.setText("Regresar");
        BtRegresarModificar.setBorder(null);
        BtRegresarModificar.setBorderPainted(false);
        BtRegresarModificar.setContentAreaFilled(false);
        BtRegresarModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48P.png"))); // NOI18N
        BtRegresarModificar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48S.png"))); // NOI18N
        BtRegresarModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtRegresarModificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(BtModificarAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(BtModificarMaestro)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(BtModificarModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(BtRegresarModificar)))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtModificarGrupo)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtModificarUsuario)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BtModificarModificar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtModificarAlumno)
                    .addComponent(BtModificarMaestro))
                .addGap(73, 73, 73)
                .addComponent(BtModificarGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(BtModificarUsuario)
                .addGap(92, 92, 92)
                .addComponent(BtRegresarModificar)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtRegresarModificarMouseClicked
        // TODO add your handling code here:
        if (VMenuModificar == null)
        {
            Menu.VModificar = null;
            VMenuModificar = new Menu(Mod);
            VMenuModificar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtRegresarModificarMouseClicked

    private void BtModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtModificarAlumnoActionPerformed

    }//GEN-LAST:event_BtModificarAlumnoActionPerformed

    private void BtModificarAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtModificarAlumnoMouseClicked
        // TODO add your handling code here:
        if (VModicarAlumno == null)
        {
            ModicarAlumno.VModificar = null;
            this.dispose();
            VModicarAlumno = new ModicarAlumno(Mod);
            VModicarAlumno.setVisible(true);

        }
    }//GEN-LAST:event_BtModificarAlumnoMouseClicked

    private void BtModificarMaestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtModificarMaestroMouseClicked
        // TODO add your handling code here:
        if (VModificarMaestro == null)
        {
            ModificarMaestro.VModificarM = null;
            this.dispose();
            VModificarMaestro = new ModificarMaestro(Mod);
            VModificarMaestro.setVisible(true);

        }
    }//GEN-LAST:event_BtModificarMaestroMouseClicked

    private void BtModificarGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtModificarGrupoMouseClicked
        if (VModificarGrupo == null)
        {
            ModificarGrupo.VModificarG = null;
            this.dispose();
            VModificarGrupo = new ModificarGrupo(Mod);
            VModificarGrupo.setVisible(true);

        }
    }//GEN-LAST:event_BtModificarGrupoMouseClicked

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
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Modificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtModificarAlumno;
    private javax.swing.JButton BtModificarGrupo;
    private javax.swing.JButton BtModificarMaestro;
    private javax.swing.JLabel BtModificarModificar;
    private javax.swing.JButton BtModificarUsuario;
    private javax.swing.JButton BtRegresarModificar;
    // End of variables declaration//GEN-END:variables
}
