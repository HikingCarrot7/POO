package Vista;

import Clases.Conectar;
import Login.Usuario;
import Clases.Render;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Poot
 */
public class ModicarAlumno extends javax.swing.JFrame
{

    public Conectar ConexionMO = new Conectar();
    Connection CNMO = ConexionMO.getConnection();
    ResultSet rs;
    public java.sql.Date Fecha;
    public java.sql.Date FechaA;
    public boolean FechaBt;
    public byte[] Imagen1;
    public byte[] Imagen2;
    public boolean ImgBt;
    Usuario Mod;
    public static Modificaciones VModificar;

    public ModicarAlumno()
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

        TabladeAlumnos.getSelectionModel().addListSelectionListener((ListSelectionEvent e) ->
        {
            if (TabladeAlumnos.getSelectedRow() != -1)
            {
                int fila = TabladeAlumnos.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                txID_alumno.setText(TabladeAlumnos.getValueAt(fila, 0).toString());
                txnombre.setText(TabladeAlumnos.getValueAt(fila, 1).toString());
                txApellidoP.setText(TabladeAlumnos.getValueAt(fila, 2).toString());
                txApellidoM.setText(TabladeAlumnos.getValueAt(fila, 3).toString());
                txEdad.setText(TabladeAlumnos.getValueAt(fila, 4).toString());
                txTelCel.setText(TabladeAlumnos.getValueAt(fila, 6).toString());
                txFechaIng.setText(TabladeAlumnos.getValueAt(fila, 5).toString());
                txGrupo.setText(TabladeAlumnos.getValueAt(fila, 7).toString());
                txPagoIns.setText(TabladeAlumnos.getValueAt(fila, 8).toString());
                txPagoMens.setText(TabladeAlumnos.getValueAt(fila, 9).toString());
            }
            btnModificar.setVisible(true);
            BTModFecha.setVisible(true);
            ModFoto.setVisible(true);
        });
    }

    ModicarAlumno(Usuario Mod)
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
        TabladeAlumnos.getSelectionModel().addListSelectionListener((ListSelectionEvent e) ->
        {
            if (TabladeAlumnos.getSelectedRow() != -1)
            {
                int fila = TabladeAlumnos.getSelectedRow();//To change body of generated methods, choose Tools | Templates
                txID_alumno.setText(TabladeAlumnos.getValueAt(fila, 0).toString());
                txnombre.setText(TabladeAlumnos.getValueAt(fila, 1).toString());
                txApellidoP.setText(TabladeAlumnos.getValueAt(fila, 2).toString());
                txApellidoM.setText(TabladeAlumnos.getValueAt(fila, 3).toString());
                txEdad.setText(TabladeAlumnos.getValueAt(fila, 4).toString());
                txTelCel.setText(TabladeAlumnos.getValueAt(fila, 6).toString());
                txFechaIng.setText(TabladeAlumnos.getValueAt(fila, 5).toString());
                txGrupo.setText(TabladeAlumnos.getValueAt(fila, 7).toString());
                txPagoIns.setText(TabladeAlumnos.getValueAt(fila, 8).toString());
                txPagoMens.setText(TabladeAlumnos.getValueAt(fila, 9).toString());
            }

            btnModificar.setVisible(true);
            BTModFecha.setVisible(true);
            ModFoto.setVisible(true);
        });
    }

    public void mostrardatos() throws IOException
    {
        TabladeAlumnos.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        modelo.addColumn("ID_alumno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Edad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de ingreso");
        modelo.addColumn("Grupo");
        modelo.addColumn("Pago de inscripcion");
        modelo.addColumn("Pago de mensualidad");
        modelo.addColumn("Foto");
        TabladeAlumnos.setModel(modelo);
        try
        {

            Statement st = CNMO.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ingresoalumnos a,grupos g WHERE a.IDGrupoAlumno=g.IDGrupo ");

            while (rs.next())
            {
                Object datos[] = new Object[11];
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getInt(5);
                datos[5] = rs.getDate(6);
                Fecha = rs.getDate(6);
                datos[6] = rs.getLong(7);
                datos[7] = rs.getInt(11);
                datos[8] = rs.getDouble(9);
                datos[9] = rs.getDouble(10);
                try
                {
                    byte[] bi = rs.getBytes(8);
                    Imagen1 = rs.getBytes(8);
                    InputStream in = new ByteArrayInputStream(bi);
                    BufferedImage image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, Image.SCALE_DEFAULT));
                    datos[10] = new JLabel(imgi);
                } catch (Exception ex)
                {
                    datos[10] = rs.getByte("No imagen");
                }
                modelo.addRow(datos);

            }
            TabladeAlumnos.setModel(modelo);
            TabladeAlumnos.setRowHeight(60);

        } catch (SQLException ex)
        {
            Logger.getLogger(ModicarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Limpiarcajas()
    {
        txID_alumno.setText(null);
        txnombre.setText(null);
        txApellidoP.setText(null);
        txApellidoM.setText(null);
        txEdad.setText(null);
        txTelCel.setText(null);
        txFechaIng.setText(null);
        txGrupo.setText(null);
        txPagoIns.setText(null);
        txPagoMens.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabladeAlumnos = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        lbID_alumno = new javax.swing.JLabel();
        txID_alumno = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        lbnombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        lbApellidoP = new javax.swing.JLabel();
        lbApellidoM = new javax.swing.JLabel();
        lbEdad = new javax.swing.JLabel();
        lbTelCel = new javax.swing.JLabel();
        lbFechaIng = new javax.swing.JLabel();
        lbGrupo = new javax.swing.JLabel();
        lbPagoIns = new javax.swing.JLabel();
        lbPagoMens = new javax.swing.JLabel();
        lbFoto = new javax.swing.JLabel();
        txApellidoP = new javax.swing.JTextField();
        txApellidoM = new javax.swing.JTextField();
        txEdad = new javax.swing.JTextField();
        txTelCel = new javax.swing.JTextField();
        txFechaIng = new javax.swing.JTextField();
        txPagoIns = new javax.swing.JTextField();
        txPagoMens = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        DateIng = new com.toedter.calendar.JDateChooser();
        BTModFecha = new javax.swing.JButton();
        txGrupo = new javax.swing.JTextField();
        ModFoto = new javax.swing.JButton();
        btnFoto = new javax.swing.JButton();
        Ruta = new javax.swing.JTextField();
        MuestraFoto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabladeAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabladeAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabladeAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabladeAlumnos);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lbID_alumno.setText("ID_alumno");

        txID_alumno.setEnabled(false);
        txID_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txID_alumnoActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Alumnos");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        lbnombre.setText("Nombre");

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        lbApellidoP.setText("Apellido Paterno");

        lbApellidoM.setText("Apellido Materno");

        lbEdad.setText("Edad");

        lbTelCel.setText("Telefono Celular");

        lbFechaIng.setText("Fecha de ingreso");

        lbGrupo.setText("Grupo");

        lbPagoIns.setText("Pago de inscripcion");

        lbPagoMens.setText("Pago de mensualidad");

        lbFoto.setText("Foto");

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

        btnSalir.setText("Regresar");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        BTModFecha.setText("ModificarFecha");
        BTModFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTModFechaMouseClicked(evt);
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

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 24)); // NOI18N
        jLabel1.setText("MODIFICAR ALUMNO");
        jLabel1.setMaximumSize(new java.awt.Dimension(202, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(202, 202));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEdad)
                            .addComponent(lbTelCel)
                            .addComponent(lbApellidoM)
                            .addComponent(lbApellidoP)
                            .addComponent(lbnombre)
                            .addComponent(lbID_alumno))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txID_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbGrupo)
                                    .addComponent(lbFechaIng))
                                .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lbPagoIns))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbPagoMens)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MuestraFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txPagoMens, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txPagoIns, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(DateIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFoto)
                                .addGap(18, 18, 18)
                                .addComponent(ModFoto))
                            .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTModFecha)))
                .addGap(128, 128, 128))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbID_alumno)
                            .addComponent(txID_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbnombre)
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellidoP))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbApellidoM))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEdad))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTelCel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnMostrar)
                            .addComponent(btnSalir))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbFechaIng)
                                        .addComponent(txFechaIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DateIng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbPagoIns)
                                    .addComponent(txPagoIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txPagoMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbPagoMens)))
                            .addComponent(BTModFecha, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnFoto)
                                    .addComponent(ModFoto)
                                    .addComponent(lbFoto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)))
                        .addComponent(MuestraFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabladeAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabladeAlumnosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabladeAlumnosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        PreparedStatement Pst = null;
        int Edad = Integer.parseInt(this.txEdad.getText());
        Long TelCel = Long.parseLong(this.txTelCel.getText());
        Double Mensualidad = Double.parseDouble(this.txPagoMens.getText());
        Double Inscripcion = Double.parseDouble(this.txPagoIns.getText());
        // int ID = Integer.parseInt(this.txID_alumno.getText());
        int Grupo = Integer.parseInt(this.txGrupo.getText());
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
                Logger.getLogger(ModicarAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        try
        {

            Pst = ConexionMO.getConnection().prepareStatement("UPDATE ingresoalumnos grupos SET Nombre=?, ApellidoPaterno=?, ApellidoMaterno=?, Edad=?, FechaIngreso=?, Telefono=?, Foto=?, Mensualidad=?, Inscripcion=?, IDGrupoAlumno=? WHERE IDAlumno = ?");
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
            Pst.setDouble(8, Mensualidad);
            Pst.setDouble(9, Inscripcion);
            Pst.setInt(10, Grupo);
            Pst.setString(11, txID_alumno.getText());

            int res = Pst.executeUpdate();

            if (res > 0)
            {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
                Limpiarcajas();
                btnModificar.setVisible(false);
                BTModFecha.setVisible(false);
                ModFoto.setVisible(false);
            } else
            {
                JOptionPane.showMessageDialog(null, "Error al modificar Alumno");
                Limpiarcajas();
            }

        } catch (SQLException | HeadlessException e)
        {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txApellidoMActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txnombreActionPerformed

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        if (VModificar == null)
        {
            Modificaciones.VModicarAlumno = null;
            this.dispose();
            VModificar = new Modificaciones(Mod);
            VModificar.setVisible(true);

        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        try
        {
            // TODO add your handling code here:
            mostrardatos();
        } catch (IOException ex)
        {
            Logger.getLogger(ModicarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnMostrarActionPerformed

    private void BTModFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTModFechaMouseClicked
        // TODO add your handling code here:
        DateIng.setVisible(true);
        FechaBt = true;
    }//GEN-LAST:event_BTModFechaMouseClicked

    private void ModFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModFotoMouseClicked

        btnFoto.setVisible(true);
        Ruta.setVisible(true);
        ImgBt = true;
    }//GEN-LAST:event_ModFotoMouseClicked

    private void ModFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModFotoActionPerformed

    private void RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RutaActionPerformed

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoActionPerformed
        // TODO add your handling code here:
        JFileChooser ImagenAlumno = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        ImagenAlumno.setFileFilter(fil);

        int Ventana = ImagenAlumno.showOpenDialog(this);
        if (Ventana == JFileChooser.APPROVE_OPTION)
        {
            String ruta = ImagenAlumno.getSelectedFile().getAbsolutePath();
            Ruta.setText(ruta);

            Image FotoAlumno = getToolkit().getImage(Ruta.getText());

            FotoAlumno = FotoAlumno.getScaledInstance(110, 110, Image.SCALE_DEFAULT);
            MuestraFoto.setIcon(new ImageIcon(FotoAlumno));
        }
    }//GEN-LAST:event_btnFotoActionPerformed

    private void txID_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txID_alumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txID_alumnoActionPerformed

    private void txFechaIngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txFechaIngActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txFechaIngActionPerformed

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
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ModicarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ModicarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ModicarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ModicarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new ModicarAlumno().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTModFecha;
    private com.toedter.calendar.JDateChooser DateIng;
    private javax.swing.JButton ModFoto;
    private javax.swing.JLabel MuestraFoto;
    private javax.swing.JTextField Ruta;
    private javax.swing.JTable TabladeAlumnos;
    private javax.swing.JButton btnFoto;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbApellidoM;
    private javax.swing.JLabel lbApellidoP;
    private javax.swing.JLabel lbEdad;
    private javax.swing.JLabel lbFechaIng;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JLabel lbGrupo;
    private javax.swing.JLabel lbID_alumno;
    private javax.swing.JLabel lbPagoIns;
    private javax.swing.JLabel lbPagoMens;
    private javax.swing.JLabel lbTelCel;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JTextField txApellidoM;
    private javax.swing.JTextField txApellidoP;
    private javax.swing.JTextField txEdad;
    private javax.swing.JTextField txFechaIng;
    private javax.swing.JTextField txGrupo;
    private javax.swing.JTextField txID_alumno;
    private javax.swing.JTextField txPagoIns;
    private javax.swing.JTextField txPagoMens;
    private javax.swing.JTextField txTelCel;
    private javax.swing.JTextField txnombre;
    // End of variables declaration//GEN-END:variables
}
