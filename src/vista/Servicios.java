
package vista;

import abm.abmCliente;
import abm.abmCotizacion;
import abm.abmProducto;
import abm.abmServicio;
import config.sesion;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCliente;
import modelo.modeloCotizacion;
import modelo.modeloProducto;
import modelo.modeloServicio;


public class Servicios extends javax.swing.JInternalFrame {

    int xMouse, yMouse;
    sesion Osesion;
    
    modeloCliente omodCliente = new modeloCliente();
    modeloProducto omodProducto = new modeloProducto();
    modeloCotizacion omodCotizacion = new modeloCotizacion();
    modeloServicio omodServicio = new modeloServicio(Osesion);
    
    abmCliente oabmCliente = new abmCliente(Osesion);
    abmProducto oabmProducto = new abmProducto(Osesion);
    abmCotizacion oabmCotizacion = new abmCotizacion(Osesion);
    abmServicio oabmServicio = new abmServicio(Osesion);
    
    frmBuscarCliente oFrmBuscarCliente;
    frmBuscarProducto oFrmBuscarProducto;
    
    //variables
    float subtotal = 0, totaiva = 0, totalneto = 0;
    float totalCosto = 0;
    float exenta = 0, iva5 = 0, iva10 = 0;
    float gs = 0, rs = 0, ps = 0, us = 0;
    float totalGeneral = 0;

    String Fecha;
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    
    DefaultTableModel modeloGrilla = new DefaultTableModel();

    public Servicios() {
        initComponents();
    }
    
       public Servicios(sesion pSesion) {
        initComponents();
        Osesion = pSesion;
        
        omodCliente = new modeloCliente();
        omodProducto = new modeloProducto();
        omodCotizacion = new modeloCotizacion();
        omodServicio = new modeloServicio(Osesion);

        oabmCliente = new abmCliente(Osesion);
        oabmProducto = new abmProducto(Osesion);
        oabmCotizacion = new abmCotizacion(Osesion);
        oabmServicio = new abmServicio(Osesion);
        
        oabmCotizacion.cargarCotizacion(omodCotizacion);
        
        
        iniciarServicio();
        //ajustarTabla();
    }
           public void iniciarServicio() {
         //variables
        subtotal = 0;
        totaiva = 0;
        totalneto = 0;
        totalCosto = 0;
        exenta = 0;
        iva5 = 0;
        iva10 = 0;
        gs = 0;
        rs = 0;
        ps = 0;
        us = 0;
        totalGeneral = 0;

        txtFactura.setText("");
        txtCodigoProducto.setText("");
        lblInfoCodigo.setText("");
        lblInfoCosto.setText("");
        lblInfoDescripcion.setText("");
        lblInfoPrecioMay.setText("");
        lblInfoPrecioUnit.setText("");
        lblInfoStock.setText("");
        txtCantidad.setText("");
        txtPrecioVenta.setText("");
        txtIdCliente.requestFocus();
        txtTotalGeneral.setText("");
        txtTotalGs.setText("");
        txtTotalUs.setText("");
        txtTotalRs.setText("");
        txtTotalPs.setText("");
        txtIva.setText("");
        txtIva10.setText("");
        txtIva5.setText("");
        txtExenta.setText("");
        txtSubtotal.setText("");
        txtTotalNeto.setText(title);

        modeloGrilla.setRowCount(0);
        tablaDetalles.setModel(modeloGrilla);
        
        omodServicio = new modeloServicio(Osesion);
        omodServicio.setFactura_nro("");
        omodServicio.setId_cliente(1);
        omodServicio.setTipo_venta("Contado");
        omodServicio.setFecha("");
        omodServicio.setUser(Osesion.getIdUsuario());
        omodServicio.setEstado(0);
        
        if(oabmServicio.generarServicio(omodServicio)== true){
            
            //CARGAR TXT Y LABEL
            txtFecha.setText(omodServicio.getFecha());
            txtVentaId.setText(String.valueOf(omodServicio.getId_operacion()));
            txtFactura.setText(omodServicio.getFactura_nro());
            txtIdCliente.setText(omodServicio.getId_cliente() + "");
            
            omodCliente.setId(omodServicio.getId_cliente());
            if(oabmCliente.cargarRegistro(omodCliente)==true){
                txtNombreCliente.setText(omodCliente.getRazon_social());
            }
            
            
            cbxTipo.setSelectedItem(omodServicio.getTipo_venta());
            txtTotalGeneral.setText(Osesion.formatoPrecio(0));
            txtTotalGs.setText(Osesion.formatoPrecio(0));
            txtTotalUs.setText(Osesion.formatoPrecio(0));
            txtTotalPs.setText(Osesion.formatoPrecio(0));
            txtTotalRs.setText(Osesion.formatoPrecio(0));
            lblInfoDescripcion.setText(" ");
            lblInfoCodigo.setText(" ");
            lblInfoPrecioUnit.setText(" ");
            lblInfoPrecioMay.setText(" ");
            lblInfoCosto.setText(" ");
            txtSubtotal.setText(Osesion.formatoPrecio(0));
            txtIva.setText(Osesion.formatoPrecio(0));
            txtTotalNeto.setText(Osesion.formatoPrecio(0));
            txtIva5.setText(Osesion.formatoPrecio(0));
            txtIva10.setText(Osesion.formatoPrecio(0));
            txtExenta.setText(Osesion.formatoPrecio(0));

        }
        
        
        txtIdCliente.requestFocus();



    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        botonExit = new javax.swing.JPanel();
        botonExitLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelEncabezado = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtVentaId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        cbxTipo = new javax.swing.JComboBox<>();
        panelCliente = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        panelVehiculo = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtIdVehiculo = new javax.swing.JTextField();
        txtNombreVehiculo = new javax.swing.JTextField();
        btnBuscarVehiculo = new javax.swing.JButton();
        panelTotal = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTotalGeneral = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTotalGs = new javax.swing.JTextField();
        txtTotalRs = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTotalPs = new javax.swing.JTextField();
        txtTotalUs = new javax.swing.JTextField();
        panelMecanico = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtNombreMecanico = new javax.swing.JTextField();
        paneCodigoProducto = new javax.swing.JPanel();
        lblInfoCodigo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelInfoProducto = new javax.swing.JPanel();
        lblInfoDescripcion = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblInfoStock = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        panelProducto = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        panelInfoPrecio = new javax.swing.JPanel();
        lblInfoPrecioUnit = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblInfoPrecioMay = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblInfoCosto = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        panelBoton = new javax.swing.JPanel();
        btnProcesar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panelSubtotal = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        txtTotalNeto = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtExenta = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtIva5 = new javax.swing.JTextField();
        txtIva10 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMinimumSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(241, 249, 249));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(51, 153, 255));
        panel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelMouseReleased(evt);
            }
        });

        botonExit.setBackground(new java.awt.Color(51, 153, 255));
        botonExit.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        botonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonExitMouseExited(evt);
            }
        });
        botonExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonExitLabel.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        botonExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonExitLabel.setText("X");
        botonExit.add(botonExitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 95, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PUNTO DE SERVICIO");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(botonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 50));

        panelEncabezado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("FECHA");

        txtFecha.setText("04/05/2020");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("VENTA ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("FACTURA");

        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });

        cbxTipo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));

        javax.swing.GroupLayout panelEncabezadoLayout = new javax.swing.GroupLayout(panelEncabezado);
        panelEncabezado.setLayout(panelEncabezadoLayout);
        panelEncabezadoLayout.setHorizontalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVentaId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        panelEncabezadoLayout.setVerticalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncabezadoLayout.createSequentialGroup()
                .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEncabezadoLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEncabezadoLayout.createSequentialGroup()
                                .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))))
                    .addGroup(panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelEncabezadoLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(txtVentaId, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGroup(panelEncabezadoLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(txtFecha))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 660, -1));

        panelCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("CLIENTE");

        txtIdCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdClienteFocusLost(evt);
            }
        });
        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyPressed(evt);
            }
        });

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.add(panelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 660, 60));

        panelVehiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Vehiculo");

        txtIdVehiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdVehiculoFocusLost(evt);
            }
        });
        txtIdVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdVehiculoKeyPressed(evt);
            }
        });

        txtNombreVehiculo.setEditable(false);
        txtNombreVehiculo.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscarVehiculo.setText("...");
        btnBuscarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVehiculoLayout = new javax.swing.GroupLayout(panelVehiculo);
        panelVehiculo.setLayout(panelVehiculoLayout);
        panelVehiculoLayout.setHorizontalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        panelVehiculoLayout.setVerticalGroup(
            panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVehiculoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.add(panelVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 660, 60));

        panelTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL");

        txtTotalGeneral.setEditable(false);
        txtTotalGeneral.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("GS");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("RS");

        txtTotalGs.setEditable(false);
        txtTotalGs.setBackground(new java.awt.Color(255, 255, 255));

        txtTotalRs.setEditable(false);
        txtTotalRs.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("US");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PS");

        txtTotalPs.setEditable(false);
        txtTotalPs.setBackground(new java.awt.Color(255, 255, 255));

        txtTotalUs.setEditable(false);
        txtTotalUs.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelTotalLayout = new javax.swing.GroupLayout(panelTotal);
        panelTotal.setLayout(panelTotalLayout);
        panelTotalLayout.setHorizontalGroup(
            panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTotalLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalGeneral))
                    .addGroup(panelTotalLayout.createSequentialGroup()
                        .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTotalLayout.createSequentialGroup()
                                .addComponent(txtTotalRs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalPs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTotalLayout.createSequentialGroup()
                                .addComponent(txtTotalGs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalUs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelTotalLayout.setVerticalGroup(
            panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTotalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTotalGs)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalUs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalRs, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTotalPs)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 370, 130));

        panelMecanico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Mecanico");

        txtNombreMecanico.setEditable(false);
        txtNombreMecanico.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMecanicoLayout = new javax.swing.GroupLayout(panelMecanico);
        panelMecanico.setLayout(panelMecanicoLayout);
        panelMecanicoLayout.setHorizontalGroup(
            panelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMecanicoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtNombreMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        panelMecanicoLayout.setVerticalGroup(
            panelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMecanicoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelMecanicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNombreMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel1.add(panelMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 370, 60));

        paneCodigoProducto.setBackground(new java.awt.Color(255, 255, 102));
        paneCodigoProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        paneCodigoProducto.setPreferredSize(new java.awt.Dimension(270, 55));

        lblInfoCodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfoCodigo.setForeground(new java.awt.Color(0, 0, 153));
        lblInfoCodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoCodigo.setText("0012312");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("CODIGO");

        javax.swing.GroupLayout paneCodigoProductoLayout = new javax.swing.GroupLayout(paneCodigoProducto);
        paneCodigoProducto.setLayout(paneCodigoProductoLayout);
        paneCodigoProductoLayout.setHorizontalGroup(
            paneCodigoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCodigoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneCodigoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInfoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneCodigoProductoLayout.setVerticalGroup(
            paneCodigoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneCodigoProductoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblInfoCodigo)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(5, 5, 5))
        );

        jPanel1.add(paneCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 270, -1));

        panelInfoProducto.setBackground(new java.awt.Color(255, 255, 102));
        panelInfoProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblInfoDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfoDescripcion.setForeground(new java.awt.Color(0, 0, 153));
        lblInfoDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoDescripcion.setText("LAPIZ DE COLOR FABER CASTELL 12 COLORES");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("DESCRIPCION");

        lblInfoStock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfoStock.setForeground(new java.awt.Color(0, 0, 153));
        lblInfoStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoStock.setText("0012312");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("STOCK");

        javax.swing.GroupLayout panelInfoProductoLayout = new javax.swing.GroupLayout(panelInfoProducto);
        panelInfoProducto.setLayout(panelInfoProductoLayout);
        panelInfoProductoLayout.setHorizontalGroup(
            panelInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInfoDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelInfoProductoLayout.setVerticalGroup(
            panelInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoProductoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelInfoProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoProductoLayout.createSequentialGroup()
                        .addComponent(lblInfoStock)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel21))
                    .addGroup(panelInfoProductoLayout.createSequentialGroup()
                        .addComponent(lblInfoDescripcion)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel19)))
                .addContainerGap())
        );

        jPanel1.add(panelInfoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 760, -1));

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro", "Codigo", "Descripcion", "Precio", "Cantidad", "SubTotal", "Iva"
            }
        ));
        tablaDetalles.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tablaDetalles);
        tablaDetalles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tablaDetalles.getColumnModel().getColumnCount() > 0) {
            tablaDetalles.getColumnModel().getColumn(0).setMinWidth(30);
            tablaDetalles.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaDetalles.getColumnModel().getColumn(0).setMaxWidth(60);
            tablaDetalles.getColumnModel().getColumn(1).setMinWidth(100);
            tablaDetalles.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaDetalles.getColumnModel().getColumn(1).setMaxWidth(200);
            tablaDetalles.getColumnModel().getColumn(2).setMinWidth(120);
            tablaDetalles.getColumnModel().getColumn(2).setPreferredWidth(400);
            tablaDetalles.getColumnModel().getColumn(2).setMaxWidth(500);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1030, 230));

        panelProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("CODIGO");

        txtCodigoProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoProductoFocusLost(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyPressed(evt);
            }
        });

        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCantidadFocusLost(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("CANTIDAD");

        txtPrecioVenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioVentaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVentaFocusLost(evt);
            }
        });
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("PRECIO");

        javax.swing.GroupLayout panelProductoLayout = new javax.swing.GroupLayout(panelProducto);
        panelProducto.setLayout(panelProductoLayout);
        panelProductoLayout.setHorizontalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(txtCodigoProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidad)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecioVenta)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProductoLayout.setVerticalGroup(
            panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductoLayout.createSequentialGroup()
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel25))
                    .addGroup(panelProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelProductoLayout.createSequentialGroup()
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel24))
                        .addGroup(panelProductoLayout.createSequentialGroup()
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel23))))
                .addGap(8, 8, 8))
        );

        jPanel1.add(panelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 440, -1));

        panelInfoPrecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblInfoPrecioUnit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInfoPrecioUnit.setForeground(new java.awt.Color(153, 153, 153));
        lblInfoPrecioUnit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoPrecioUnit.setText("0012312");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("PRECIO UNIT.");

        lblInfoPrecioMay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInfoPrecioMay.setForeground(new java.awt.Color(153, 153, 153));
        lblInfoPrecioMay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoPrecioMay.setText("0012312");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("PRECIO MAY.");

        lblInfoCosto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblInfoCosto.setForeground(new java.awt.Color(153, 153, 153));
        lblInfoCosto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblInfoCosto.setText("0012312");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("COSTO");

        javax.swing.GroupLayout panelInfoPrecioLayout = new javax.swing.GroupLayout(panelInfoPrecio);
        panelInfoPrecio.setLayout(panelInfoPrecioLayout);
        panelInfoPrecioLayout.setHorizontalGroup(
            panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoPrecioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(lblInfoPrecioUnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoPrecioMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panelInfoPrecioLayout.setVerticalGroup(
            panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoPrecioLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInfoPrecioLayout.createSequentialGroup()
                        .addComponent(lblInfoCosto)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel30))
                    .addGroup(panelInfoPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelInfoPrecioLayout.createSequentialGroup()
                            .addComponent(lblInfoPrecioMay)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel28))
                        .addGroup(panelInfoPrecioLayout.createSequentialGroup()
                            .addComponent(lblInfoPrecioUnit)
                            .addGap(0, 0, 0)
                            .addComponent(jLabel26))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelInfoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 440, -1));

        panelBoton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnProcesar.setText("PROCESAR");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonLayout = new javax.swing.GroupLayout(panelBoton);
        panelBoton.setLayout(panelBotonLayout);
        panelBotonLayout.setHorizontalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonLayout.createSequentialGroup()
                        .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotonLayout.setVerticalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnProcesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));

        panelSubtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("SUBTOTAL");

        txtSubtotal.setEditable(false);
        txtSubtotal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("IVA");

        txtIva.setEditable(false);
        txtIva.setBackground(new java.awt.Color(255, 255, 255));

        txtTotalNeto.setEditable(false);
        txtTotalNeto.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("TOTAL NETO");

        txtExenta.setEditable(false);
        txtExenta.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("EXENTA");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("IVA 5%");

        txtIva5.setEditable(false);
        txtIva5.setBackground(new java.awt.Color(255, 255, 255));

        txtIva10.setEditable(false);
        txtIva10.setBackground(new java.awt.Color(255, 255, 255));
        txtIva10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIva10KeyTyped(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel37.setText("IVA 10%");

        javax.swing.GroupLayout panelSubtotalLayout = new javax.swing.GroupLayout(panelSubtotal);
        panelSubtotal.setLayout(panelSubtotalLayout);
        panelSubtotalLayout.setHorizontalGroup(
            panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubtotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSubtotalLayout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalNeto))
                    .addGroup(panelSubtotalLayout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIva))
                    .addGroup(panelSubtotalLayout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSubtotalLayout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIva10))
                    .addGroup(panelSubtotalLayout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIva5))
                    .addGroup(panelSubtotalLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSubtotalLayout.setVerticalGroup(
            panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSubtotalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubtotalLayout.createSequentialGroup()
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGap(2, 2, 2))
                        .addComponent(txtSubtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubtotalLayout.createSequentialGroup()
                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addGap(2, 2, 2))
                        .addComponent(txtExenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubtotalLayout.createSequentialGroup()
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(1, 1, 1))
                        .addComponent(txtIva5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubtotalLayout.createSequentialGroup()
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(1, 1, 1))
                        .addComponent(txtIva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubtotalLayout.createSequentialGroup()
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(1, 1, 1))
                        .addComponent(txtIva10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSubtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelSubtotalLayout.createSequentialGroup()
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(1, 1, 1))
                        .addComponent(txtTotalNeto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 400, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseClicked
        //CERRAR EL PROGRAMA
        
        this.dispose();
    }//GEN-LAST:event_botonExitMouseClicked

    private void botonExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseEntered
        //HOVER DEL BOTON DE CERRAR
        botonExit.setBackground(Color.red);
        botonExitLabel.setForeground(Color.white);
    }//GEN-LAST:event_botonExitMouseEntered

    private void botonExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseExited
        //HOVER DEL BOTON DE CERRAR
        botonExit.setBackground(new Color(51, 153, 255));
        botonExitLabel.setForeground(Color.black);
    }//GEN-LAST:event_botonExitMouseExited

    private void panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseDragged
        //MOVIMIENTO DE LA VENTANA DEL PROGRAMA
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelMouseDragged

    private void panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMousePressed
        //MOVIMIENTO DE LA VENTANA DEL PROGRAMA
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelMousePressed

    private void panelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseReleased

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void txtIdClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteFocusLost

    private void txtIdClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteKeyPressed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtIdVehiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdVehiculoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVehiculoFocusLost

    private void txtIdVehiculoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdVehiculoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVehiculoKeyPressed

    private void btnBuscarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarVehiculoActionPerformed

    private void txtCodigoProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProductoFocusLost
        String producto = txtCodigoProducto.getText().trim();
        if (!producto.equals("")) {

            omodProducto = new modeloProducto();

            if(Osesion.validarInt(txtCodigoProducto.getText())==true){
                omodProducto.setId(Integer.parseInt(txtCodigoProducto.getText()));
                omodProducto.setBarra(txtCodigoProducto.getText());
            }else{
                omodProducto.setId(0);
                omodProducto.setBarra(txtCodigoProducto.getText());
            }

            if (oabmProducto.verProductoVenta(omodProducto) == true) {
                //cargar formulario
                txtCodigoProducto.setText(String.valueOf(omodProducto.getId()));
                txtPrecioVenta.setText(Osesion.formatoPrecio(omodProducto.getPrecio_unitario()));
                lblInfoCodigo.setText(String.valueOf(omodProducto.getId()));
                lblInfoDescripcion.setText(omodProducto.getDescripcion());
                lblInfoStock.setText(Osesion.formatoCantidad(omodProducto.getStock()));
                lblInfoCosto.setText(Osesion.formatoCosto(omodProducto.getCosto_medio()));
                lblInfoPrecioMay.setText(Osesion.formatoPrecio(omodProducto.getPrecio_mayorista()));
                lblInfoPrecioUnit.setText(Osesion.formatoPrecio(omodProducto.getPrecio_unitario()));
                txtCantidad.setText("1");
            } else {
                //abrir formulario de busqueda
                //limpiarProducto();
                oFrmBuscarProducto  = new frmBuscarProducto(null, closable, Osesion, this);
                oFrmBuscarProducto.setVisible(true);
                oFrmBuscarProducto.toFront();
            }
        }/*else{
            oFrmBuscarProducto  = new frmBuscarProducto(null, closable, Osesion, this);
            oFrmBuscarProducto.setVisible(true);
            oFrmBuscarProducto.toFront();

        }*/
    }//GEN-LAST:event_txtCodigoProductoFocusLost

    private void txtCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyPressed
        if (Osesion.verificarEnter(evt) == true) {
            txtCantidad.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoProductoKeyPressed

    private void txtCantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusLost
        if(Osesion.validarInt(txtCantidad.getText())){
            if(Osesion.getUsuarioSinStock().equals("no")){
                //verifica stock del product
                //va pasar la validacion
                float Cantidad = Osesion.convertirFloat(txtCantidad.getText());
                if(omodProducto.getStock() >= Cantidad){
                    txtPrecioVenta.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stok Insuficiente");
                    txtCantidad.requestFocus();
                }
            }

        }else if( !txtCantidad.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese Numero");
            txtCantidad.setText("1");
            txtCantidad.requestFocus();

        }
    }//GEN-LAST:event_txtCantidadFocusLost

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed

        if (Osesion.verificarEnter(evt) == true) {
            txtPrecioVenta.requestFocus();
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped

    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecioVentaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaFocusGained

    }//GEN-LAST:event_txtPrecioVentaFocusGained

    private void txtPrecioVentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioVentaFocusLost

    }//GEN-LAST:event_txtPrecioVentaFocusLost

    private void txtPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyPressed
        if(Osesion.verificarEnter(evt) == true){
            boolean validacion = true;

            String Precio = txtPrecioVenta.getText();
            Float precio2 = Osesion.convertirFloat(Precio);

            if(Osesion.validarFloat(precio2 +"")== false){
                validacion = false;
            }
            if(Osesion.validarInt(txtCantidad.getText()) == false){
                validacion = false;
            }
            if(validacion == true){
                if(Float.parseFloat(txtCantidad.getText()) > 0){
                    //cargar datos en la tablaDetalles
                }else{
                    JOptionPane.showMessageDialog(null, "Cantidad debe ser mayor a cero");
                    txtPrecioVenta.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error de datos");
            }

        }

    }//GEN-LAST:event_txtPrecioVentaKeyPressed

    private void txtPrecioVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyReleased

    }//GEN-LAST:event_txtPrecioVentaKeyReleased

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped

    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed

    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar Venta?", "Mensaje", JOptionPane.YES_NO_OPTION) == 0) {
            subtotal = 0;
            totaiva = 0;
            totalneto = 0;
            totalCosto = 0;
            exenta = 0;
            iva5 = 0;
            iva10 = 0;
            gs = 0;
            rs = 0;
            ps = 0;
            us = 0;
            totalGeneral = 0;
            iniciarServicio();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = 0;
        String total_fila, codigo, cantidad;
        float pcantidad;
        if (tablaDetalles.getSelectedRow() >= 0) {
            fila = tablaDetalles.getSelectedRow();
            codigo = tablaDetalles.getValueAt(fila, 0).toString();
            cantidad = tablaDetalles.getValueAt(fila, 3).toString();
            pcantidad =   Osesion.convertirFloat(cantidad);
            omodProducto = new modeloProducto();
            omodProducto.setId(Integer.parseInt(codigo));

            if (oabmProducto.verProductoVenta(omodProducto)) {
                total_fila = tablaDetalles.getValueAt(fila, 4).toString();
                float subtotalProducto = Osesion.convertirFloat(total_fila);

                //separa valores del iva
                if (omodProducto.getIva() == 5) {
                    iva5 = iva5 - subtotalProducto;
                    txtIva5.setText(Osesion.formatoPrecio(iva5));
                } else if (omodProducto.getIva() == 10) {
                    iva10 = iva10 - subtotalProducto;
                    txtIva10.setText(Osesion.formatoPrecio(iva10));
                } else {
                    exenta = exenta - subtotalProducto;
                    txtExenta.setText(Osesion.formatoPrecio(exenta));
                }
                totaiva = (iva5 / 21) + (iva10 / 11);
                txtIva.setText(Osesion.formatoPrecio(totaiva));

                totalCosto = totalCosto - (omodProducto.getCosto_medio() * Integer.parseInt(cantidad));
                totalneto = totalneto - subtotalProducto;
                txtTotalNeto.setText(Osesion.formatoPrecio(totalneto));
                txtTotalGeneral.setText(Osesion.formatoPrecio(totalneto));

                subtotal = totalneto - totaiva;
                txtSubtotal.setText(Osesion.formatoPrecio(subtotal));

                if (Osesion.getConfigMoneda().equals("gs")) {
                    txtTotalGs.setText(Osesion.formatoValorEnGs(totalneto / omodCotizacion.getGs()));
                    txtTotalUs.setText(Osesion.formatoPrecio(totalneto / omodCotizacion.getUs()));
                    txtTotalRs.setText(Osesion.formatoPrecio(totalneto / omodCotizacion.getRs()));
                    txtTotalPs.setText(Osesion.formatoPrecio(totalneto / omodCotizacion.getPs()));
                } else {
                    txtTotalGs.setText(Osesion.formatoValorEnGs(totalneto * omodCotizacion.getGs()));
                    txtTotalUs.setText(Osesion.formatoPrecio(totalneto * omodCotizacion.getUs()));
                    txtTotalRs.setText(Osesion.formatoPrecio(totalneto * omodCotizacion.getRs()));
                    txtTotalPs.setText(Osesion.formatoPrecio(totalneto * omodCotizacion.getPs()));
                }

                modeloGrilla.removeRow(fila);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione Producto a eliminar");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIva10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIva10KeyTyped

    }//GEN-LAST:event_txtIva10KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonExit;
    private javax.swing.JLabel botonExitLabel;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarVehiculo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblInfoCodigo;
    private javax.swing.JLabel lblInfoCosto;
    public javax.swing.JLabel lblInfoDescripcion;
    private javax.swing.JLabel lblInfoPrecioMay;
    private javax.swing.JLabel lblInfoPrecioUnit;
    private javax.swing.JLabel lblInfoStock;
    private javax.swing.JPanel paneCodigoProducto;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCliente;
    private javax.swing.JPanel panelEncabezado;
    private javax.swing.JPanel panelInfoPrecio;
    private javax.swing.JPanel panelInfoProducto;
    private javax.swing.JPanel panelMecanico;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JPanel panelSubtotal;
    private javax.swing.JPanel panelTotal;
    private javax.swing.JPanel panelVehiculo;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtExenta;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtIdCliente;
    public javax.swing.JTextField txtIdVehiculo;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtIva10;
    private javax.swing.JTextField txtIva5;
    public javax.swing.JTextField txtNombreCliente;
    public javax.swing.JTextField txtNombreMecanico;
    public javax.swing.JTextField txtNombreVehiculo;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotalGeneral;
    private javax.swing.JTextField txtTotalGs;
    private javax.swing.JTextField txtTotalNeto;
    private javax.swing.JTextField txtTotalPs;
    private javax.swing.JTextField txtTotalRs;
    private javax.swing.JTextField txtTotalUs;
    private javax.swing.JTextField txtVentaId;
    // End of variables declaration//GEN-END:variables
}
