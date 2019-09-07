package com.sw.view;

import com.sw.controller.AddEntity;
import com.sw.controller.DataTableUpdater;
import com.sw.model.Alumno;
import com.sw.model.Maestro;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Mohammed
 */
public class MaestrosGUI extends javax.swing.JFrame
{

    private final int indexCurrentMaestro;
    private final ArrayList<Maestro> maestros;
    private final DataTableUpdater dataTableUpdater;
    private final Login login;
    private final AddEntity addEntity;

    public MaestrosGUI(int indexCurrentMaestro, ArrayList<Maestro> maestros, Login login, AddEntity addEntity)
    {
        initComponents();

        dataTableUpdater = new DataTableUpdater();
        this.login = login;
        this.addEntity = addEntity;

        if (maestros.get(indexCurrentMaestro).obtenerEntidades().size() > 0)
            dataTableUpdater.updateTableAlumnos(tablaMaestros, maestros, indexCurrentMaestro);

        this.indexCurrentMaestro = indexCurrentMaestro;
        this.maestros = maestros;

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaestros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        agregarAlumno = new javax.swing.JButton();
        removerAlumno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JButton();
        modificarAlumno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        tablaMaestros.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        tablaMaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Licenciatura", "Matrícula", "Nombre", "Calificación"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }
        });
        tablaMaestros.setToolTipText("Registros de sus alumnos");
        jScrollPane1.setViewportView(tablaMaestros);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setText("Sus alumnos:");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel2.setText("Bienvenido:");

        jComboBox1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ordenar por:", "NA", "NA", "NA" }));

        agregarAlumno.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        agregarAlumno.setText("Agregar alumno");
        agregarAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                agregarAlumnoActionPerformed(evt);
            }
        });

        removerAlumno.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        removerAlumno.setText("Remover alumno");
        removerAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removerAlumnoActionPerformed(evt);
            }
        });

        cerrarSesion.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        cerrarSesion.setText("Cerrar sesión");
        cerrarSesion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cerrarSesionActionPerformed(evt);
            }
        });

        modificarAlumno.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        modificarAlumno.setText("Modificar alumno");
        modificarAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                modificarAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removerAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregarAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(agregarAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerAlumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificarAlumno)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarAlumnoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_agregarAlumnoActionPerformed
    {//GEN-HEADEREND:event_agregarAlumnoActionPerformed

        AgregarAlumno.iniciarAgregarAlumno(maestros, indexCurrentMaestro, this, new Alumno());

    }//GEN-LAST:event_agregarAlumnoActionPerformed

    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cerrarSesionActionPerformed
    {//GEN-HEADEREND:event_cerrarSesionActionPerformed
        dispose();

        login.reiniciarLogin();

    }//GEN-LAST:event_cerrarSesionActionPerformed

    private void removerAlumnoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removerAlumnoActionPerformed
    {//GEN-HEADEREND:event_removerAlumnoActionPerformed

        if (validarPosicionSeleccionado())
        {
            maestros.get(indexCurrentMaestro).obtenerEntidades().remove(tablaMaestros.getSelectedRow());
            dataTableUpdater.updateTableAlumnos(tablaMaestros, maestros, indexCurrentMaestro);

        }

    }//GEN-LAST:event_removerAlumnoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        login.reiniciarLogin();
    }//GEN-LAST:event_formWindowClosing

    private void modificarAlumnoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_modificarAlumnoActionPerformed
    {//GEN-HEADEREND:event_modificarAlumnoActionPerformed

        if (validarPosicionSeleccionado())
            AgregarAlumno.iniciarAgregarAlumno(maestros, indexCurrentMaestro, this, (Alumno) maestros.get(indexCurrentMaestro).obtenerEntidades().get(tablaMaestros.getSelectedRow()));

    }//GEN-LAST:event_modificarAlumnoActionPerformed

    private boolean validarPosicionSeleccionado()
    {
        return tablaMaestros.getSelectedRow() >= 0 && tablaMaestros.getSelectedRow() < maestros.get(indexCurrentMaestro).obtenerEntidades().size();
    }

    public JTable getTablaMaestros()
    {
        return tablaMaestros;
    }

    public AddEntity getAddEntity()
    {
        return addEntity;
    }

    public static void IniciarMaestrosGUI(int indexCurrentMaestro, ArrayList<Maestro> maestros, Login login, AddEntity addEntity)
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
            java.util.logging.Logger.getLogger(MaestrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MaestrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MaestrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MaestrosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            MaestrosGUI maestrosGui = new MaestrosGUI(indexCurrentMaestro, maestros, login, addEntity);

            maestrosGui.setVisible(true);
            maestrosGui.setLocationRelativeTo(null);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarAlumno;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarAlumno;
    private javax.swing.JButton removerAlumno;
    private javax.swing.JTable tablaMaestros;
    // End of variables declaration//GEN-END:variables

}
