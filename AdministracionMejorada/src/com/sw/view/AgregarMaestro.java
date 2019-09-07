package com.sw.view;

import com.sw.controller.DataTableUpdater;
import com.sw.model.Maestro;
import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public class AgregarMaestro extends javax.swing.JFrame
{

    private final ArrayList<Maestro> maestros;
    private final DataTableUpdater dataUpdater;
    private final AdministradoresGUI administradoresGui;

    public AgregarMaestro(ArrayList<Maestro> maestros, DataTableUpdater dataUpdater, AdministradoresGUI administradoresGui)
    {
        initComponents();

        this.maestros = maestros;
        this.dataUpdater = dataUpdater;
        this.administradoresGui = administradoresGui;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        especialidad = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        sueldoBase = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contrasena = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar a un maestro: ");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel2.setText("Especialidad:");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setText("Matrícula:");

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel8.setText("Edad:");

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel10.setText("Sueldo base:");

        matricula.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        matricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matricula.setText("Matrícula");
        matricula.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                matriculaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                matriculaFocusLost(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre.setText("Nombre");
        nombre.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                nombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                nombreFocusLost(evt);
            }
        });

        especialidad.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        especialidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        especialidad.setText("Especialidad");
        especialidad.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                especialidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                especialidadFocusLost(evt);
            }
        });

        edad.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        edad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        edad.setText("Edad");
        edad.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                edadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                edadFocusLost(evt);
            }
        });

        sueldoBase.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        sueldoBase.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sueldoBase.setText("Sueldo base");
        sueldoBase.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                sueldoBaseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                sueldoBaseFocusLost(evt);
            }
        });

        registrar.setText("Registrar");
        registrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                registrarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel11.setText("Usuario:");

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel12.setText("Contraseña:");

        usuario.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario.setText("Usuario");
        usuario.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                usuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                usuarioFocusLost(evt);
            }
        });

        contrasena.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        contrasena.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contrasena.setText("Contraseña");
        contrasena.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                contrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                contrasenaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matricula, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_registrarActionPerformed
    {//GEN-HEADEREND:event_registrarActionPerformed

        maestros.add(new Maestro(matricula.getText(), nombre.getText(), Integer.parseInt(edad.getText()), Double.parseDouble(sueldoBase.getText()), usuario.getText(), contrasena.getText(), especialidad.getText()));

        dataUpdater.updateTableMaestros(administradoresGui.getjTable1(), maestros);

        dispose();

    }//GEN-LAST:event_registrarActionPerformed

    private void matriculaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_matriculaFocusGained
    {//GEN-HEADEREND:event_matriculaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaFocusGained

    private void matriculaFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_matriculaFocusLost
    {//GEN-HEADEREND:event_matriculaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaFocusLost

    private void especialidadFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_especialidadFocusGained
    {//GEN-HEADEREND:event_especialidadFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_especialidadFocusGained

    private void especialidadFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_especialidadFocusLost
    {//GEN-HEADEREND:event_especialidadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_especialidadFocusLost

    private void nombreFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_nombreFocusGained
    {//GEN-HEADEREND:event_nombreFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFocusGained

    private void nombreFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_nombreFocusLost
    {//GEN-HEADEREND:event_nombreFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFocusLost

    private void edadFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_edadFocusGained
    {//GEN-HEADEREND:event_edadFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_edadFocusGained

    private void edadFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_edadFocusLost
    {//GEN-HEADEREND:event_edadFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_edadFocusLost

    private void sueldoBaseFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_sueldoBaseFocusGained
    {//GEN-HEADEREND:event_sueldoBaseFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoBaseFocusGained

    private void sueldoBaseFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_sueldoBaseFocusLost
    {//GEN-HEADEREND:event_sueldoBaseFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_sueldoBaseFocusLost

    private void usuarioFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_usuarioFocusGained
    {//GEN-HEADEREND:event_usuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioFocusGained

    private void usuarioFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_usuarioFocusLost
    {//GEN-HEADEREND:event_usuarioFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioFocusLost

    private void contrasenaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_contrasenaFocusGained
    {//GEN-HEADEREND:event_contrasenaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaFocusGained

    private void contrasenaFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_contrasenaFocusLost
    {//GEN-HEADEREND:event_contrasenaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaFocusLost

    public static void iniciarAgregarMaestro(ArrayList<Maestro> maestros, DataTableUpdater dataUpdater, AdministradoresGUI administradoresGui)
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

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            System.out.println(ex.getMessage());
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            AgregarMaestro agregarMaestro = new AgregarMaestro(maestros, dataUpdater, administradoresGui);

            agregarMaestro.setVisible(true);
            agregarMaestro.setLocationRelativeTo(null);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contrasena;
    private javax.swing.JTextField edad;
    private javax.swing.JTextField especialidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton registrar;
    private javax.swing.JTextField sueldoBase;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
