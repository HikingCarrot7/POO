package Vista;

import Login.Usuario;

/**
 *
 * @author Daniel Poot
 */
public class Eliminar extends javax.swing.JFrame
{

    public static Menu VMenuEliminar;
    public static EliminarAlumno VAlumnoEliminar;
    public static EliminarMaestro VMaestroEliminar;
    public static EliminarGrupo VEliminarGrupo;
    Usuario Mod;

    /**
     * Creates new form Registros
     */
    public Eliminar()
    {
        initComponents();
    }

    public Eliminar(Usuario Mod)
    {
        initComponents();
        this.Mod = Mod;

        if (Mod.getIDTipo() == 1)
        {

        } else if (Mod.getIDTipo() == 2)
            BtEliminarUsuario.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        BtEliminarAlumno = new javax.swing.JButton();
        BtEliminarMaestro = new javax.swing.JButton();
        BtEliminarUsuario = new javax.swing.JButton();
        BtEliminarGrupo = new javax.swing.JButton();
        BtRegresarEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtEliminarAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarAlumno.png"))); // NOI18N
        BtEliminarAlumno.setText("Alumno");
        BtEliminarAlumno.setBorder(null);
        BtEliminarAlumno.setBorderPainted(false);
        BtEliminarAlumno.setContentAreaFilled(false);
        BtEliminarAlumno.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarAlumnoP.png"))); // NOI18N
        BtEliminarAlumno.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarAlumnoS.png"))); // NOI18N
        BtEliminarAlumno.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                BtEliminarAlumnoMouseClicked(evt);
            }
        });

        BtEliminarMaestro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarMeaestro.png"))); // NOI18N
        BtEliminarMaestro.setText("Mestro");
        BtEliminarMaestro.setBorder(null);
        BtEliminarMaestro.setBorderPainted(false);
        BtEliminarMaestro.setContentAreaFilled(false);
        BtEliminarMaestro.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarMeaestroP.png"))); // NOI18N
        BtEliminarMaestro.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarMeaestroS.png"))); // NOI18N
        BtEliminarMaestro.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                BtEliminarMaestroMouseClicked(evt);
            }
        });

        BtEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarUsuario.png"))); // NOI18N
        BtEliminarUsuario.setText("Usuario");
        BtEliminarUsuario.setBorder(null);
        BtEliminarUsuario.setBorderPainted(false);
        BtEliminarUsuario.setContentAreaFilled(false);
        BtEliminarUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarUsuarioP.png"))); // NOI18N
        BtEliminarUsuario.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarUsuarioS.png"))); // NOI18N

        BtEliminarGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarGrupo.png"))); // NOI18N
        BtEliminarGrupo.setText("Grupo");
        BtEliminarGrupo.setBorder(null);
        BtEliminarGrupo.setBorderPainted(false);
        BtEliminarGrupo.setContentAreaFilled(false);
        BtEliminarGrupo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarGrupoP.png"))); // NOI18N
        BtEliminarGrupo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/EliminarGrupoS.png"))); // NOI18N
        BtEliminarGrupo.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                BtEliminarGrupoMouseClicked(evt);
            }
        });

        BtRegresarEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48.png"))); // NOI18N
        BtRegresarEliminar.setText("Regresar");
        BtRegresarEliminar.setBorder(null);
        BtRegresarEliminar.setBorderPainted(false);
        BtRegresarEliminar.setContentAreaFilled(false);
        BtRegresarEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48P.png"))); // NOI18N
        BtRegresarEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48S.png"))); // NOI18N
        BtRegresarEliminar.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                BtRegresarEliminarMouseClicked(evt);
            }
        });
        BtRegresarEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtRegresarEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(BtEliminarAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtEliminarMaestro)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtEliminarGrupo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BtRegresarEliminar)
                                .addComponent(BtEliminarUsuario)))
                        .addGap(153, 153, 153))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtEliminarAlumno)
                    .addComponent(BtEliminarMaestro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtEliminarGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(BtEliminarUsuario)
                .addGap(105, 105, 105)
                .addComponent(BtRegresarEliminar)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegresarEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegresarEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtRegresarEliminarActionPerformed

    private void BtRegresarEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtRegresarEliminarMouseClicked
        // TODO add your handling code here:
        if (VMenuEliminar == null)
        {
            Menu.VEliminar = null;
            VMenuEliminar = new Menu(Mod);
            VMenuEliminar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtRegresarEliminarMouseClicked

    private void BtEliminarAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEliminarAlumnoMouseClicked
        // TODO add your handling code here:
        if (VAlumnoEliminar == null)
        {
            EliminarAlumno.VEliminar = null;
            VAlumnoEliminar = new EliminarAlumno(Mod);
            VAlumnoEliminar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtEliminarAlumnoMouseClicked

    private void BtEliminarMaestroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEliminarMaestroMouseClicked
        if (VMaestroEliminar == null)
        {
            EliminarMaestro.VEliminarM = null;
            VMaestroEliminar = new EliminarMaestro(Mod);
            VMaestroEliminar.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtEliminarMaestroMouseClicked

    private void BtEliminarGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtEliminarGrupoMouseClicked
        if (VEliminarGrupo == null)
        {
            EliminarGrupo.VEliminarG = null;
            VEliminarGrupo = new EliminarGrupo(Mod);
            VEliminarGrupo.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtEliminarGrupoMouseClicked

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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new Eliminar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtEliminarAlumno;
    private javax.swing.JButton BtEliminarGrupo;
    private javax.swing.JButton BtEliminarMaestro;
    private javax.swing.JButton BtEliminarUsuario;
    private javax.swing.JButton BtRegresarEliminar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
