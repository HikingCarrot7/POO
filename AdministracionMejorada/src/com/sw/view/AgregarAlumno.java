package com.sw.view;

import com.sw.controller.AddEntity;
import com.sw.model.Alumno;
import com.sw.model.Maestro;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Mohammed
 */
public class AgregarAlumno extends javax.swing.JFrame
{

    private final MaestrosGUI maestrosGui;
    private final Alumno alumno;
    private final ArrayList<Maestro> maestros;
    private final AddEntity addEntity;
    private final int indexCurrentMaestro;

    public AgregarAlumno(ArrayList<Maestro> maestros, int indexCurrentMaestro, MaestrosGUI maestrosGui, Alumno alumno)
    {
        initComponents();

        this.maestrosGui = maestrosGui;
        this.maestros = maestros;
        this.alumno = alumno;
        this.indexCurrentMaestro = indexCurrentMaestro;

        addEntity = maestrosGui.getAddEntity();
        addEntity.actualizarCamposRelleno(this);
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
        licenciatura = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        calificacion = new javax.swing.JTextField();
        registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar a un alumno: ");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel2.setText("Licenciatura:");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setText("Matrícula:");

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel8.setText("Edad:");

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel10.setText("Calificación:");

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

        licenciatura.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        licenciatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        licenciatura.setText("Licenciatura");
        licenciatura.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                licenciaturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                licenciaturaFocusLost(evt);
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

        calificacion.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        calificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        calificacion.setText("Calificación");
        calificacion.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                calificacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                calificacionFocusLost(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(licenciatura, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matricula))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(licenciatura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edad, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_registrarActionPerformed
    {//GEN-HEADEREND:event_registrarActionPerformed

        addEntity.anadirAlumno(this);

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

    private void licenciaturaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_licenciaturaFocusGained
    {//GEN-HEADEREND:event_licenciaturaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_licenciaturaFocusGained

    private void licenciaturaFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_licenciaturaFocusLost
    {//GEN-HEADEREND:event_licenciaturaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_licenciaturaFocusLost

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

    private void calificacionFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_calificacionFocusGained
    {//GEN-HEADEREND:event_calificacionFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_calificacionFocusGained

    private void calificacionFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_calificacionFocusLost
    {//GEN-HEADEREND:event_calificacionFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_calificacionFocusLost

    public int getIndexCurrentMaestro()
    {
        return indexCurrentMaestro;
    }

    public JTextField getCalificacion()
    {
        return calificacion;
    }

    public JTextField getEdad()
    {
        return edad;
    }

    public JTextField getLicenciatura()
    {
        return licenciatura;
    }

    public JTextField getMatricula()
    {
        return matricula;
    }

    public JTextField getNombre()
    {
        return nombre;
    }

    public ArrayList<Maestro> getMaestros()
    {
        return maestros;
    }

    public Alumno getAlumno()
    {
        return alumno;
    }

    public MaestrosGUI getMaestrosGui()
    {
        return maestrosGui;
    }

    public static void iniciarAgregarAlumno(ArrayList<Maestro> maestros, int indexCurrentMaestro, MaestrosGUI maestrosGui, Alumno alumno)
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
            AgregarAlumno agregarAlumno = new AgregarAlumno(maestros, indexCurrentMaestro, maestrosGui, alumno);

            agregarAlumno.setVisible(true);
            agregarAlumno.setLocationRelativeTo(null);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField calificacion;
    private javax.swing.JTextField edad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField licenciatura;
    private javax.swing.JTextField matricula;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}
