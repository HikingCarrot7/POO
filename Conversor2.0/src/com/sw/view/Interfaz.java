package com.sw.view;

import com.sw.controller.DataManager;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Interfaz gráfica del programa.
 *
 *
 * @author Naomi García Sanchez.
 * @author Carlos Álvarez Trejo.
 *
 */
public class Interfaz extends javax.swing.JFrame
{

    private final DataManager dataManager;

    public Interfaz()
    {
        initComponents();

        dataManager = new DataManager(this);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        calcular = new javax.swing.JButton();
        entradaOpcion = new javax.swing.JComboBox<String>();
        salidaOpcion = new javax.swing.JComboBox<String>();
        entrada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        decimalDef = new javax.swing.JTextField();
        binarioDef = new javax.swing.JTextField();
        octalDef = new javax.swing.JTextField();
        hexadecimalDef = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        valorInvalido = new javax.swing.JLabel();
        infoBase = new javax.swing.JLabel();
        salida = new javax.swing.JTextField();
        infoBaseSalida = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversor");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Conversor");

        calcular.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        calcular.setText("Calcular");
        calcular.setToolTipText("¡Hacer la conversión!");
        calcular.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                calcularActionPerformed(evt);
            }
        });

        entradaOpcion.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        entradaOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "16" }));
        entradaOpcion.setSelectedIndex(8);
        entradaOpcion.setToolTipText("Seleccione una base");
        entradaOpcion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                entradaOpcionActionPerformed(evt);
            }
        });

        salidaOpcion.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        salidaOpcion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10", "16" }));
        salidaOpcion.setToolTipText("Seleccione una base");
        salidaOpcion.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                salidaOpcionActionPerformed(evt);
            }
        });

        entrada.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        entrada.setToolTipText("Inserte un valor");
        entrada.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                entradaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                entradaFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel2.setText("Decimal");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel3.setText("Binario");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel4.setText("Octal");

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel5.setText("Hexadecimal");

        decimalDef.setEditable(false);
        decimalDef.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        decimalDef.setToolTipText("Resultado en decimal");

        binarioDef.setEditable(false);
        binarioDef.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        binarioDef.setToolTipText("Resultado en binario");

        octalDef.setEditable(false);
        octalDef.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        octalDef.setToolTipText("Resultado en octal");

        hexadecimalDef.setEditable(false);
        hexadecimalDef.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        hexadecimalDef.setToolTipText("Resultado en haxedecimal");

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel6.setText("De base:");

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel7.setText("Valor:");

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel8.setText("A base:");

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel9.setText("Valor:");

        valorInvalido.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        valorInvalido.setForeground(new java.awt.Color(255, 0, 0));
        valorInvalido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        infoBase.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        infoBase.setText("(Decimal)");

        salida.setEditable(false);
        salida.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        salida.setToolTipText("Inserte un valor");

        infoBaseSalida.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        infoBaseSalida.setText("(Binario)");

        limpiar.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        limpiar.setText("Limpiar");
        limpiar.setToolTipText("Limpiar los campos");
        limpiar.setEnabled(false);
        limpiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(decimalDef, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel2)
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel3))
                                                    .addComponent(binarioDef, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel4))
                                            .addComponent(octalDef, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hexadecimalDef, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel5))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(calcular, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(210, 210, 210))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(valorInvalido, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(entradaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(infoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salidaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(infoBaseSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)))))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entradaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salidaOpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(infoBaseSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(valorInvalido, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calcular)
                .addGap(5, 5, 5)
                .addComponent(limpiar)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decimalDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(binarioDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(octalDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hexadecimalDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_entradaFocusLost
    {//GEN-HEADEREND:event_entradaFocusLost
        if (!getEntrada().getText().equals(""))
            dataManager.validarEntrada();
    }//GEN-LAST:event_entradaFocusLost

    private void entradaFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_entradaFocusGained
    {//GEN-HEADEREND:event_entradaFocusGained
        valorInvalido.setText("");
    }//GEN-LAST:event_entradaFocusGained

    private void entradaOpcionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_entradaOpcionActionPerformed
    {//GEN-HEADEREND:event_entradaOpcionActionPerformed
        if (!getEntrada().getText().equals(""))
            dataManager.validarEntrada();

        dataManager.infoBase(infoBase, (String) getEntradaOpcion().getSelectedItem());

    }//GEN-LAST:event_entradaOpcionActionPerformed

    private void calcularActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_calcularActionPerformed
    {//GEN-HEADEREND:event_calcularActionPerformed
        if (dataManager.validarEntrada())
        {
            dataManager.updateCampos();
            limpiar.setEnabled(true);
        }
    }//GEN-LAST:event_calcularActionPerformed

    private void salidaOpcionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_salidaOpcionActionPerformed
    {//GEN-HEADEREND:event_salidaOpcionActionPerformed
        dataManager.infoBase(infoBaseSalida, (String) getSalidaOpcion().getSelectedItem());
    }//GEN-LAST:event_salidaOpcionActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_limpiarActionPerformed
    {//GEN-HEADEREND:event_limpiarActionPerformed
        if (!salida.getText().equals("") || !dataManager.validarEntrada())
        {
            dataManager.limpiarCampos();
            valorInvalido.setText("");
            limpiar.setEnabled(false);
        }
    }//GEN-LAST:event_limpiarActionPerformed

    public JComboBox<String> getEntradaOpcion()
    {
        return entradaOpcion;
    }

    public JComboBox<String> getSalidaOpcion()
    {
        return salidaOpcion;
    }

    public JTextField getEntrada()
    {
        return entrada;
    }

    public JTextField getSalida()
    {
        return salida;
    }

    public JLabel getValorInvalido()
    {
        return valorInvalido;
    }

    public JTextField getBinarioDef()
    {
        return binarioDef;
    }

    public JTextField getDecimalDef()
    {
        return decimalDef;
    }

    public JTextField getHexadecimalDef()
    {
        return hexadecimalDef;
    }

    public JTextField getOctalDef()
    {
        return octalDef;
    }

    public JButton getLimpiar()
    {
        return limpiar;
    }

    public static void iniciarInterfaz()
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            Interfaz interfaz = new Interfaz();

            interfaz.setVisible(true);
            interfaz.setLocationRelativeTo(null);
            interfaz.setIconImage(Toolkit.getDefaultToolkit().getImage(interfaz.getClass().getResource("/com/res/images/icon.png")));

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField binarioDef;
    private javax.swing.JButton calcular;
    private javax.swing.JTextField decimalDef;
    private javax.swing.JTextField entrada;
    private javax.swing.JComboBox<String> entradaOpcion;
    private javax.swing.JTextField hexadecimalDef;
    private javax.swing.JLabel infoBase;
    private javax.swing.JLabel infoBaseSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField octalDef;
    private javax.swing.JTextField salida;
    private javax.swing.JComboBox<String> salidaOpcion;
    private javax.swing.JLabel valorInvalido;
    // End of variables declaration//GEN-END:variables
}
