/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.*;
import Login.Usuario;
import Modulos.Alumno;
import static Vista.VAsistencia.VRasistenciaA;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Poot
 */
public class RAsistenciaAlumno extends javax.swing.JFrame
{

    Conectar RAsitenciaConexion = new Conectar();
    public static VAsistencia VAsistenciaA;
    Usuario Mod;

    /**
     * Creates new form RAsistenciaAlumno
     */
    public RAsistenciaAlumno()
    {
        initComponents();
        Alumno ComboAlumno = new Alumno();
        ComboAlumno.MostrarAlumnos(ComboAlumnosRA);
        Asistencia ComboAsistencia = new Asistencia();
        ComboAsistencia.MostrarTipoAsistencia(ComboTipoAsistencia);
    }

    public RAsistenciaAlumno(Usuario Mod)
    {
        initComponents();
        Alumno ComboAlumno = new Alumno();
        ComboAlumno.MostrarAlumnos(ComboAlumnosRA);
        Asistencia ComboAsistencia = new Asistencia();
        ComboAsistencia.MostrarTipoAsistencia(ComboTipoAsistencia);
        this.Mod = Mod;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloAsistencia = new javax.swing.JLabel();
        FechaAsistencia = new javax.swing.JLabel();
        ComboTipoAsistencia = new javax.swing.JComboBox<>();
        TipoAsistencia = new javax.swing.JLabel();
        RegresarAsistencia = new javax.swing.JButton();
        GuardarAsistencia = new javax.swing.JButton();
        AlumnoAsistencia = new javax.swing.JLabel();
        ComboAlumnosRA = new javax.swing.JComboBox<>();
        CalendarAsistencia = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloAsistencia.setText("Registro de Asistecia Alumnos");

        FechaAsistencia.setText("Fecha  :");

        TipoAsistencia.setText("Tipo : ");

        RegresarAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48.png"))); // NOI18N
        RegresarAsistencia.setText("Regresar");
        RegresarAsistencia.setBorder(null);
        RegresarAsistencia.setBorderPainted(false);
        RegresarAsistencia.setContentAreaFilled(false);
        RegresarAsistencia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48P.png"))); // NOI18N
        RegresarAsistencia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Salir48S.png"))); // NOI18N
        RegresarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegresarAsistenciaMouseClicked(evt);
            }
        });

        GuardarAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Guardar48.png"))); // NOI18N
        GuardarAsistencia.setText("Guardar");
        GuardarAsistencia.setBorder(null);
        GuardarAsistencia.setBorderPainted(false);
        GuardarAsistencia.setContentAreaFilled(false);
        GuardarAsistencia.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Guardar48P.png"))); // NOI18N
        GuardarAsistencia.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesProyecto/Guardar48S.png"))); // NOI18N
        GuardarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarAsistenciaMouseClicked(evt);
            }
        });

        AlumnoAsistencia.setText("Alumno : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(TituloAsistencia)
                .addGap(108, 108, 108))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TipoAsistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ComboTipoAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RegresarAsistencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardarAsistencia))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FechaAsistencia)
                            .addComponent(AlumnoAsistencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboAlumnosRA, 0, 150, Short.MAX_VALUE)
                            .addComponent(CalendarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(TituloAsistencia)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlumnoAsistencia)
                    .addComponent(ComboAlumnosRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FechaAsistencia)
                    .addComponent(CalendarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoAsistencia)
                    .addComponent(ComboTipoAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegresarAsistencia)
                    .addComponent(GuardarAsistencia))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarAsistenciaMouseClicked
        // TODO add your handling code here:

        int IDAlumno = ComboAlumnosRA.getItemAt(ComboAlumnosRA.getSelectedIndex()).getID();
        Date Date = CalendarAsistencia.getDate();
        long Fecha = Date.getTime();
        java.sql.Date FechaA = new java.sql.Date(Fecha);
        int IDTipoAsitencia = ComboTipoAsistencia.getItemAt(ComboAlumnosRA.getSelectedIndex()).getIDTipoAsistencia();

        PreparedStatement PstRA = null;

        try
        {
            PstRA = RAsitenciaConexion.getConnection().prepareStatement("insert into asistenciaalumnos values(null,?,?,?)");
            PstRA.setDate(1, FechaA);
            PstRA.setInt(2, IDAlumno);
            PstRA.setInt(3, IDTipoAsitencia);

        } catch (Exception ERA)
        {
            JOptionPane.showMessageDialog(null, "Error " + ERA);
        }

    }//GEN-LAST:event_GuardarAsistenciaMouseClicked

    private void RegresarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarAsistenciaMouseClicked
        // TODO add your handling code here:
        if (VAsistenciaA == null)
        {
            VAsistencia.VRasistenciaA = null;
            VAsistenciaA = new VAsistencia(Mod);
            VAsistenciaA.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_RegresarAsistenciaMouseClicked

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
            java.util.logging.Logger.getLogger(RAsistenciaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(RAsistenciaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(RAsistenciaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(RAsistenciaAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new RAsistenciaAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlumnoAsistencia;
    private com.toedter.calendar.JDateChooser CalendarAsistencia;
    private javax.swing.JComboBox<Alumno> ComboAlumnosRA;
    private javax.swing.JComboBox<Asistencia> ComboTipoAsistencia;
    private javax.swing.JLabel FechaAsistencia;
    private javax.swing.JButton GuardarAsistencia;
    private javax.swing.JButton RegresarAsistencia;
    private javax.swing.JLabel TipoAsistencia;
    private javax.swing.JLabel TituloAsistencia;
    // End of variables declaration//GEN-END:variables

}