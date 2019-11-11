/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.*;
import Login.Usuario;
import Modulos.Maestro;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Poot
 */
public class RegistroGrupo extends javax.swing.JFrame
{

    public Conectar ConexionRH = new Conectar();
    public static Registros VRegistroRG;
    Usuario Mod;

    /**
     * Creates new form RegistroGrupo
     */
    public RegistroGrupo()
    {
        initComponents();

        Horario HorarioRGCombo = new Horario();
        HorarioRGCombo.MostrarHorarios(ComboHorarioRG);
        Maestro MaestroRGCombo = new Maestro();
        MaestroRGCombo.MostrarMaestros(ComboMaestroRG);

    }

    public RegistroGrupo(Usuario Mod)
    {
        initComponents();

        Horario HorarioRGCombo = new Horario();
        HorarioRGCombo.MostrarHorarios(ComboHorarioRG);
        Maestro MaestroRGCombo = new Maestro();
        MaestroRGCombo.MostrarMaestros(ComboMaestroRG);
        this.Mod = Mod;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistroGrupo = new javax.swing.JLabel();
        TipoGrupoRG = new javax.swing.JLabel();
        IngreTipoGrupoRG = new javax.swing.JTextField();
        HorarioRG = new javax.swing.JLabel();
        MestroRG = new javax.swing.JLabel();
        ComboMaestroRG = new javax.swing.JComboBox<>();
        BtRegresarRG = new javax.swing.JToggleButton();
        BtGuardarRG = new javax.swing.JToggleButton();
        ComboHorarioRG = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegistroGrupo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        RegistroGrupo.setText("Registro de grupo");

        TipoGrupoRG.setText("Tipo de grupo : ");

        IngreTipoGrupoRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngreTipoGrupoRGActionPerformed(evt);
            }
        });

        HorarioRG.setText("Horario : ");

        MestroRG.setText("Maestro  :");

        BtRegresarRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48.png"))); // NOI18N
        BtRegresarRG.setText("Regresar");
        BtRegresarRG.setBorder(null);
        BtRegresarRG.setBorderPainted(false);
        BtRegresarRG.setContentAreaFilled(false);
        BtRegresarRG.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48P.png"))); // NOI18N
        BtRegresarRG.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48S.png"))); // NOI18N
        BtRegresarRG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtRegresarRGMouseClicked(evt);
            }
        });

        BtGuardarRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Guardar48.png"))); // NOI18N
        BtGuardarRG.setText("Guardar");
        BtGuardarRG.setBorder(null);
        BtGuardarRG.setBorderPainted(false);
        BtGuardarRG.setContentAreaFilled(false);
        BtGuardarRG.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Guardar48P.png"))); // NOI18N
        BtGuardarRG.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Guardar48S.png"))); // NOI18N
        BtGuardarRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtGuardarRGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtRegresarRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(172, 172, 172)
                        .addComponent(BtGuardarRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HorarioRG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TipoGrupoRG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MestroRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboMaestroRG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(IngreTipoGrupoRG)
                                .addGap(36, 36, 36))
                            .addComponent(ComboHorarioRG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RegistroGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(RegistroGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoGrupoRG, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IngreTipoGrupoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HorarioRG)
                    .addComponent(ComboHorarioRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MestroRG)
                    .addComponent(ComboMaestroRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtRegresarRG)
                    .addComponent(BtGuardarRG))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtGuardarRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtGuardarRGActionPerformed
        // TODO add your handling code here:

        String TipoGrupo = IngreTipoGrupoRG.getText();
        int IDHorario = ComboHorarioRG.getItemAt(ComboHorarioRG.getSelectedIndex()).getIDHorario();
        int IDMaestro = ComboMaestroRG.getItemAt(ComboMaestroRG.getSelectedIndex()).getIDMaestro();

        try
        {

            PreparedStatement PstG = null;
            PstG = ConexionRH.getConnection().prepareStatement("INSERT INTO grupos VALUES (NULL,?,?,?)");
            PstG.setString(1, TipoGrupo);
            PstG.setInt(2, IDHorario);
            PstG.setInt(3, IDMaestro);

            PstG.executeUpdate();

            JOptionPane.showMessageDialog(null, "Grupo Registrado");
            IngreTipoGrupoRG.setText("");

        } catch (HeadlessException | SQLException Ex)
        {
            JOptionPane.showMessageDialog(null, Ex);
        }

    }//GEN-LAST:event_BtGuardarRGActionPerformed

    private void IngreTipoGrupoRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngreTipoGrupoRGActionPerformed
        // TODO add your handling code here:
        IngreTipoGrupoRG.transferFocus();
    }//GEN-LAST:event_IngreTipoGrupoRGActionPerformed

    private void BtRegresarRGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtRegresarRGMouseClicked
        // TODO add your handling code here:
        if (VRegistroRG == null)
        {
            Registros.VRegistroGrupo = null;
            this.dispose();
            VRegistroRG = new Registros(Mod);
            VRegistroRG.setVisible(true);
        }
    }//GEN-LAST:event_BtRegresarRGMouseClicked

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
            java.util.logging.Logger.getLogger(RegistroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RegistroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RegistroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RegistroGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new RegistroGrupo().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtGuardarRG;
    private javax.swing.JToggleButton BtRegresarRG;
    private javax.swing.JComboBox<Horario> ComboHorarioRG;
    private javax.swing.JComboBox<Maestro> ComboMaestroRG;
    private javax.swing.JLabel HorarioRG;
    private javax.swing.JTextField IngreTipoGrupoRG;
    private javax.swing.JLabel MestroRG;
    private javax.swing.JLabel RegistroGrupo;
    private javax.swing.JLabel TipoGrupoRG;
    // End of variables declaration//GEN-END:variables
}
