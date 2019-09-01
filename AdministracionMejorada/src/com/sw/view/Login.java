package com.sw.view;

import com.sw.controller.DataManager;
import com.sw.controller.DataUpdater;
import com.sw.interfaces.InicioSesion;
import com.sw.model.Administrador;
import com.sw.model.Maestro;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author HikingCarrot7
 */
public class Login extends javax.swing.JFrame
{

    private int indexCurrentMaestro;
    private final DataManager dataManager;
    private final DataUpdater dataUpdater;
    private final TextFieldManager userTextFieldManager, passwordTextFieldManager;
    private final ArrayList<Maestro> maestros;
    private final ArrayList<Administrador> administradores;

    public Login()
    {
        dataManager = new DataManager();
        dataUpdater = new DataUpdater();
        maestros = dataManager.getMaestros();
        administradores = new ArrayList<>();

        administradores.add(new Administrador("18004567", "Eusebio Ajas", 21, 90000, "eusebio.fca", "12345678"));

        initComponents();

        userTextFieldManager = new TextFieldManager("", usuario, uservalido);
        passwordTextFieldManager = new TextFieldManager("", contrasena, contravalida);

        usuario.getDocument().addDocumentListener(userTextFieldManager);
        contrasena.getDocument().addDocumentListener(passwordTextFieldManager);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contrasena = new javax.swing.JTextField();
        soyunmaestro = new javax.swing.JButton();
        soyunadministrador = new javax.swing.JButton();
        login = new javax.swing.JButton();
        uservalido = new javax.swing.JLabel();
        contravalida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión como administrador");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel2.setText("Iniciar sesión");

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel3.setText("Usuario:");

        usuario.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario.setText("Usuario");
        usuario.setToolTipText("Usuario");
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

        soyunmaestro.setText("Soy un maestro");
        soyunmaestro.setEnabled(maestros.size() > 0 );
        soyunmaestro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                soyunmaestroActionPerformed(evt);
            }
        });

        soyunadministrador.setText("Soy un administrador");
        soyunadministrador.setEnabled(!soyunmaestro.isEnabled());
        soyunadministrador.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                soyunadministradorActionPerformed(evt);
            }
        });

        login.setText("Iniciar Sesión");
        login.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loginActionPerformed(evt);
            }
        });

        uservalido.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        uservalido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        uservalido.setToolTipText("");

        contravalida.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        contravalida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contravalida.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(uservalido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(contravalida, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(soyunmaestro)
                        .addGap(18, 18, 18)
                        .addComponent(soyunadministrador)
                        .addGap(18, 18, 18)
                        .addComponent(login)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uservalido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contravalida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soyunmaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soyunadministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contrasenaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_contrasenaFocusGained
    {//GEN-HEADEREND:event_contrasenaFocusGained

        contrasena.setText(passwordTextFieldManager.getText().equals("") ? "" : contrasena.getText());

    }//GEN-LAST:event_contrasenaFocusGained

    private void contrasenaFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_contrasenaFocusLost
    {//GEN-HEADEREND:event_contrasenaFocusLost

        if (!contrasena.getText().trim().equals(""))
            contravalida.setText(validarFormatoTexto(contrasena.getText(), "^[a-zA-Z0-9._-]{8,}$") ? "" : "Contraseña inválida");

    }//GEN-LAST:event_contrasenaFocusLost

    private void soyunmaestroActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_soyunmaestroActionPerformed
    {//GEN-HEADEREND:event_soyunmaestroActionPerformed

        setTitle("Iniciar sesión como maestro");
        soyunmaestro.setEnabled(false);
        soyunadministrador.setEnabled(true);

    }//GEN-LAST:event_soyunmaestroActionPerformed

    private void soyunadministradorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_soyunadministradorActionPerformed
    {//GEN-HEADEREND:event_soyunadministradorActionPerformed

        setTitle("Iniciar sesión como administrador");
        soyunmaestro.setEnabled(true);
        soyunadministrador.setEnabled(false);

    }//GEN-LAST:event_soyunadministradorActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loginActionPerformed
    {//GEN-HEADEREND:event_loginActionPerformed

        if (!soyunmaestro.isEnabled() && validarLogin(maestros, usuario.getText().trim(), contrasena.getText().trim()))
        {
            MaestrosGUI.IniciarMaestrosGUI(indexCurrentMaestro, maestros, this);

            setVisible(false);

        } else if (validarLogin(administradores, usuario.getText().trim(), contrasena.getText().trim()))
        {
            AdministradoresGUI.IniciarAdministradoresGui(maestros, dataManager, dataUpdater, this);

            setVisible(false);

        } else
            JOptionPane.showMessageDialog(this, "Los datos no son válidos", "Datos inválidos", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_loginActionPerformed

    private void usuarioFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_usuarioFocusGained
    {//GEN-HEADEREND:event_usuarioFocusGained

        usuario.setText(userTextFieldManager.getText().equals("") ? "" : usuario.getText());

    }//GEN-LAST:event_usuarioFocusGained

    private void usuarioFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_usuarioFocusLost
    {//GEN-HEADEREND:event_usuarioFocusLost

        if (!usuario.getText().trim().equals(""))
            uservalido.setText(validarFormatoTexto(usuario.getText(), "^([á-úa-zA-Z._-]( ?)){9,}$") ? "" : "Usuario inválido");

    }//GEN-LAST:event_usuarioFocusLost

    private boolean validarFormatoTexto(String texto, String regex)
    {
        return texto.matches(regex);
    }

    public JTextField getContrasena()
    {
        return contrasena;
    }

    public JTextField getUsuario()
    {
        return usuario;
    }

    public int getIndexCurrentMaestro()
    {
        return indexCurrentMaestro;
    }

    public static void IniciarLogin()
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            Login login = new Login();

            login.setVisible(true);
            login.setLocationRelativeTo(null);

        });
    }

    private <T extends InicioSesion> boolean validarLogin(ArrayList<T> autoridades, String user, String password)
    {

        for (int i = 0; i < autoridades.size(); i++)
            if (autoridades.get(i).getUsuario().equals(user) && autoridades.get(i).getPassword().equals(password))
            {
                indexCurrentMaestro = i;
                return true;

            }

        return false;

    }

    private class TextFieldManager implements DocumentListener
    {

        private String text;
        private final JTextField jtextfield;
        private final JLabel jlabel;

        private TextFieldManager(String text, JTextField jtextfield, JLabel jlabel)
        {
            this.text = text;
            this.jtextfield = jtextfield;
            this.jlabel = jlabel;
        }

        @Override
        public void insertUpdate(DocumentEvent e)
        {
            text += jtextfield.getText();

            jlabel.setText("");

        }

        @Override
        public void removeUpdate(DocumentEvent e)
        {
            text += jtextfield.getText();

            jlabel.setText("");

        }

        @Override
        public void changedUpdate(DocumentEvent e)
        {

        }

        public String getText()
        {
            return text;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contrasena;
    private javax.swing.JLabel contravalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login;
    private javax.swing.JButton soyunadministrador;
    private javax.swing.JButton soyunmaestro;
    private javax.swing.JLabel uservalido;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables

}
