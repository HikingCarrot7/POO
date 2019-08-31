/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Clases.Conectar;
import Clases.Render;
import Login.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ModificarMaestro extends javax.swing.JFrame
{

    public Conectar ConexionMO = new Conectar();
    Connection CNMOM = ConexionMO.getConnection();
    ResultSet rs;
    public java.sql.Date Fecha;
    public java.sql.Date FechaA;
    public boolean FechaBt;
    public byte[] Imagen1;
    public byte[] Imagen2;
    public boolean ImgBt;
    Usuario Mod;

    public static Modificaciones VModificarM;

    public ModificarMaestro()
    {
        initComponents();
        DateIng.setVisible(false);
        btnFoto.setVisible(false);
        FechaBt = false;
        ImgBt = false;
        Ruta.setVisible(false);
        btnModificar.setVisible(false);
        BTModFecha.setVisible(false);
        ModFoto.setVisible(false);
        this.setLocationRelativeTo(null);
        TabladeMaestros.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeMaestros.getSelectedRow() != -1)
                {
                    int fila = TabladeMaestros.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_Maestro.setText(TabladeMaestros.getValueAt(fila, 0).toString());
                    txnombre.setText(TabladeMaestros.getValueAt(fila, 1).toString());
                    txApellidoP.setText(TabladeMaestros.getValueAt(fila, 2).toString());
                    txApellidoM.setText(TabladeMaestros.getValueAt(fila, 3).toString());
                    txEdad.setText(TabladeMaestros.getValueAt(fila, 4).toString());
                    txTelCel.setText(TabladeMaestros.getValueAt(fila, 6).toString());
                    txFechaIng.setText(TabladeMaestros.getValueAt(fila, 5).toString());
                    txAñosE.setText(TabladeMaestros.getValueAt(fila, 7).toString());

                }
                btnModificar.setVisible(true);
                BTModFecha.setVisible(true);
                ModFoto.setVisible(true);
            }
        });
    }

    ModificarMaestro(Usuario Mod)
    {
        this.Mod = Mod;
        initComponents();
        this.setLocationRelativeTo(null);
        DateIng.setVisible(false);
        btnFoto.setVisible(false);
        FechaBt = false;
        ImgBt = false;
        Ruta.setVisible(false);
        btnModificar.setVisible(false);
        BTModFecha.setVisible(false);
        ModFoto.setVisible(false);
        TabladeMaestros.getSelectionModel().addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                if (TabladeMaestros.getSelectedRow() != -1)
                {
                    int fila = TabladeMaestros.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                    txID_Maestro.setText(TabladeMaestros.getValueAt(fila, 0).toString());
                    txnombre.setText(TabladeMaestros.getValueAt(fila, 1).toString());
                    txApellidoP.setText(TabladeMaestros.getValueAt(fila, 2).toString());
                    txApellidoM.setText(TabladeMaestros.getValueAt(fila, 3).toString());
                    txEdad.setText(TabladeMaestros.getValueAt(fila, 4).toString());
                    txTelCel.setText(TabladeMaestros.getValueAt(fila, 6).toString());
                    txFechaIng.setText(TabladeMaestros.getValueAt(fila, 5).toString());
                    txAñosE.setText(TabladeMaestros.getValueAt(fila, 7).toString());
                }
                btnModificar.setVisible(true);
                BTModFecha.setVisible(true);
                ModFoto.setVisible(true);
            }
        });
    }

    public void mostrardatos() throws IOException
    {
        TabladeMaestros.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        modelo.addColumn("ID_Maestro");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de ingreso");
        modelo.addColumn("Años de experiencia");
        modelo.addColumn("Foto");
        TabladeMaestros.setModel(modelo);
        try
        {

            Statement st = CNMOM.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM maestros");

            while (rs.next())
            {
                Object datos[] = new Object[9];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getInt(5);
                datos[5] = rs.getDate(6);
                Fecha = rs.getDate(6);
                datos[6] = rs.getLong(7);
                datos[7] = rs.getInt(9);
                try
                {
                    byte[] bi = rs.getBytes(8);
                    Imagen1 = rs.getBytes(8);
                    InputStream in = new ByteArrayInputStream(bi);
                    BufferedImage image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    datos[8] = new JLabel(imgi);
                } catch (Exception ex)
                {
                    datos[8] = rs.getByte("No imagen");
                }
                modelo.addRow(datos);

            }
            TabladeMaestros.setModel(modelo);
            TabladeMaestros.setRowHeight(60);

        } catch (SQLException ex)
        {
            Logger.getLogger(ModificarMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Limpiarcajas()
    {
        txID_Maestro.setText(null);
        txnombre.setText(null);
        txApellidoP.setText(null);
        txApellidoM.setText(null);
        txEdad.setText(null);
        txTelCel.setText(null);
        txFechaIng.setText(null);
        txAñosE.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txTelCel = new javax.swing.JTextField();
        lbApellidoP = new javax.swing.JLabel();
        lbApellidoM = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        lbTelCel = new javax.swing.JLabel();
        txApellidoP = new javax.swing.JTextField();
        lbID_Maestro = new javax.swing.JLabel();
        txID_Maestro = new javax.swing.JTextField();
        lbnombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        txApellidoM = new javax.swing.JTextField();
        txEdad = new javax.swing.JTextField();
        txFechaIng = new javax.swing.JTextField();
        DateIng = new com.toedter.calendar.JDateChooser();
        BTModFecha = new javax.swing.JButton();
        lbFechaIng = new javax.swing.JLabel();
        lbAñosE = new javax.swing.JLabel();
        txAñosE = new javax.swing.JTextField();
        ModFoto = new javax.swing.JButton();
        btnFoto = new javax.swing.JButton();
        Ruta = new javax.swing.JTextField();
        MuestraFoto = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabladeMaestros = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbApellidoP.setText("Apellido Paterno");

        lbApellidoM.setText("Apellido Materno");

        lbEdad.setText("Edad");

        lbTelCel.setText("Telefono Celular");

        lbID_Maestro.setText("ID_Maestro");

        txID_Maestro.setEnabled(false);

        lbnombre.setText("Nombre");

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        txApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txApellidoMActionPerformed(evt);
            }
        });

        txFechaIng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txFechaIngActionPerformed(evt);
            }
        });

        BTModFecha.setText("ModificarFecha");
        BTModFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTModFechaMouseClicked(evt);
            }
        });
        BTModFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTModFechaActionPerformed(evt);
            }
        });

        lbFechaIng.setText("Fecha de ingreso");

        lbAñosE.setText("Años de experiencia");

        txAñosE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txAñosEActionPerformed(evt);
            }
        });

        ModFoto.setText("Modificar Foto");
        ModFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModFotoMouseClicked(evt);
            }
        });
        ModFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModFotoActionPerformed(evt);
            }
        });

        btnFoto.setText("Foto");
        btnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoActionPerformed(evt);
            }
        });

        Ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutaActionPerformed(evt);
            }
        });

        lbFoto.setText("Foto");

        TabladeMaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabladeMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladeMaestrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabladeMaestros);

        btnSalir.setText("Regresar");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Maestros");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("MODIFICAR MAESTRO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MuestraFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnFoto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ModFoto))
                        .addComponent(Ruta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(btnModificar)
                                        .addGap(93, 93, 93)
                                        .addComponent(btnMostrar)
                                        .addGap(93, 93, 93)
                                        .addComponent(btnSalir))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbID_Maestro)
                                            .addComponent(lbnombre)
                                            .addComponent(lbApellidoP)
                                            .addComponent(lbApellidoM))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txID_Maestro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbAñosE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txAñosE, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbFechaIng)
                                                    .addComponent(lbTelCel))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txFechaIng, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                    .addComponent(txTelCel))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTModFecha))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbEdad)
                                .addGap(96, 96, 96)
                                .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbID_Maestro)
                    .addComponent(txID_Maestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTelCel)
                    .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbnombre)
                        .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbFechaIng)
                        .addComponent(txFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BTModFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellidoP)
                    .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAñosE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txAñosE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFoto)
                    .addComponent(ModFoto)
                    .addComponent(lbFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEdad))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnMostrar)
                                .addComponent(btnSalir))
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MuestraFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed

    }//GEN-LAST:event_txnombreActionPerformed

    private void txApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txApellidoMActionPerformed

    private void BTModFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTModFechaMouseClicked
        DateIng.setVisible(true);
        FechaBt = true;
    }//GEN-LAST:event_BTModFechaMouseClicked

    private void ModFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModFotoMouseClicked
        btnFoto.setVisible(true);
        Ruta.setVisible(true);
        ImgBt = true;
    }//GEN-LAST:event_ModFotoMouseClicked

    private void ModFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModFotoActionPerformed

    }//GEN-LAST:event_ModFotoActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        JFileChooser ImagenMaestro = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        ImagenMaestro.setFileFilter(fil);

        int Ventana = ImagenMaestro.showOpenDialog(this);
        if (Ventana == JFileChooser.APPROVE_OPTION)
        {
            String ruta = ImagenMaestro.getSelectedFile().getAbsolutePath();
            Ruta.setText(ruta);

            Image FotoMaestro = getToolkit().getImage(Ruta.getText());

            FotoMaestro = FotoMaestro.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            MuestraFoto.setIcon(new ImageIcon(FotoMaestro));
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RutaActionPerformed

    private void txFechaIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFechaIngActionPerformed

    }//GEN-LAST:event_txFechaIngActionPerformed

    private void BTModFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTModFechaActionPerformed

    }//GEN-LAST:event_BTModFechaActionPerformed

    private void txAñosEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txAñosEActionPerformed

    }//GEN-LAST:event_txAñosEActionPerformed

    private void TabladeMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladeMaestrosMouseClicked

    }//GEN-LAST:event_TabladeMaestrosMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        if (VModificarM == null)
        {
            Modificaciones.VModificarMaestro = null;
            this.dispose();
            VModificarM = new Modificaciones(Mod);
            VModificarM.setVisible(true);

        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        PreparedStatement Pst = null;
        int Edad = Integer.parseInt(this.txEdad.getText());
        Long TelCel = Long.parseLong(this.txTelCel.getText());
        int AñosE = Integer.parseInt(this.txAñosE.getText());
        long FechaNueva;

        if (FechaBt != false)
        {
            Date Date = DateIng.getDate();
            FechaNueva = Date.getTime();

            FechaA = new java.sql.Date(FechaNueva);

        }

        if (ImgBt != false)
            try
            {
                File Ruta1 = new File(Ruta.getText());
                Imagen2 = new byte[(int) Ruta1.length()];
                InputStream input1 = new FileInputStream(Ruta1);
                input1.read(Imagen2);
            } catch (IOException ex)
            {
                Logger.getLogger(ModificarMaestro.class.getName()).log(Level.SEVERE, null, ex);
            }

        try
        {

            Pst = ConexionMO.getConnection().prepareStatement("UPDATE maestros SET Nombre=?, ApellidoPaterno=?, ApellidoMaterno=?, Edad=?, FechaIngreso=?, Telefono=?, Foto=?, Experiencia=? WHERE IDMaestro=? ");
            Pst.setString(1, txnombre.getText());
            Pst.setString(2, txApellidoP.getText());
            Pst.setString(3, txApellidoM.getText());
            Pst.setInt(4, Edad);
            if (FechaBt == true)
                Pst.setDate(5, FechaA);
            else
                Pst.setDate(5, Fecha);
            Pst.setLong(6, TelCel);
            if (ImgBt == true)
                Pst.setBytes(7, Imagen2);
            else
                Pst.setBytes(7, Imagen1);
            Pst.setInt(8, AñosE);
            Pst.setString(9, txID_Maestro.getText());

            int res = Pst.executeUpdate();

            if (res > 0)
            {
                JOptionPane.showMessageDialog(null, "Maestro modificado");
                Limpiarcajas();
                btnModificar.setVisible(false);
                BTModFecha.setVisible(false);
                ModFoto.setVisible(false);
            } else
            {
                JOptionPane.showMessageDialog(null, "Error al modificar Maestro");
                Limpiarcajas();
            }

        } catch (Exception e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        try
        {
            // TODO add your handling code here:
            mostrardatos();
        } catch (IOException ex)
        {
            Logger.getLogger(ModificarMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ModificarMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ModificarMaestro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTModFecha;
    private com.toedter.calendar.JDateChooser DateIng;
    private javax.swing.JButton ModFoto;
    private javax.swing.JLabel MuestraFoto;
    private javax.swing.JTextField Ruta;
    private javax.swing.JTable TabladeMaestros;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellidoM;
    private javax.swing.JLabel lbApellidoP;
    private javax.swing.JLabel lbAñosE;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbFechaIng;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbID_Maestro;
    private javax.swing.JLabel lbTelCel;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JTextField txApellidoM;
    private javax.swing.JTextField txApellidoP;
    private javax.swing.JTextField txAñosE;
    private javax.swing.JTextField txEdad;
    private javax.swing.JTextField txFechaIng;
    private javax.swing.JTextField txID_Maestro;
    private javax.swing.JTextField txTelCel;
    private javax.swing.JTextField txnombre;
    // End of variables declaration//GEN-END:variables
}
