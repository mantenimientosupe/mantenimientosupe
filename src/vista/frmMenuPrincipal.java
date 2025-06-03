
package vista;

import abm.abmMarca;
import config.sesion;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class frmMenuPrincipal extends javax.swing.JFrame {

    sesion oSesion;
    //frmVenta oFrmVenta;
    frmProveedor oFrmProveedor;
    frmClientE oFrmCliente;
    frmCategoria oFrmCategoria;
    frmMarca oFrmMarca;
    frmMecanico oFrmMecanico;
    frmProducto oFrmProducto;
    frmVehiculos oFrmVehiculos;
    Servicios oFrmServicios;
    abmMarca oAbmMarca;
    
    public frmMenuPrincipal() {
        initComponents();
    }
    
    public frmMenuPrincipal(sesion pSesion){
        initComponents();
        oSesion = pSesion;
        txtUsuario.setText("Usuario: " + oSesion.getNombreUsuario());
        liberarMenu();
    }
    
    public void liberarMenu(){
        String nivel = oSesion.getNivel();
        
        if(nivel.equals("1")){
            /* ACCESO COMPLETO*/
        }else if(nivel.equals("2")){
            //CAJERO
            sm_oCompra.setVisible(false);
            sm_oVenta.setVisible(false);
            sm_oCaja.setVisible(true);
            
            mRegistro.setVisible(true);
            
        }else if(nivel.equals("3")){
            //VENTAS
            sm_oCompra.setVisible(false);
            sm_oVenta.setVisible(true);
            sm_oCaja.setVisible(false);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mRegistro = new javax.swing.JMenu();
        sm_rProducto = new javax.swing.JMenuItem();
        sm_rCliente = new javax.swing.JMenuItem();
        ms_rProveedor = new javax.swing.JMenuItem();
        sm_rCategoria = new javax.swing.JMenuItem();
        sm_rMarcas = new javax.swing.JMenuItem();
        sm_rMecanico = new javax.swing.JMenuItem();
        sm_rVehiculo = new javax.swing.JMenuItem();
        mOperaciones = new javax.swing.JMenu();
        sm_oCompra = new javax.swing.JMenuItem();
        sm_oVenta = new javax.swing.JMenuItem();
        sm_oCaja = new javax.swing.JMenuItem();
        sm_oNuevoServicio = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        contenedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setText("USUARIO: -");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(436, 50));

        mRegistro.setText("Registro");
        mRegistro.setFocusable(false);

        sm_rProducto.setText("Producto");
        sm_rProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_rProductoActionPerformed(evt);
            }
        });
        mRegistro.add(sm_rProducto);

        sm_rCliente.setText("Cliente");
        sm_rCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_rClienteActionPerformed(evt);
            }
        });
        mRegistro.add(sm_rCliente);

        ms_rProveedor.setText("Proveedor");
        ms_rProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ms_rProveedorActionPerformed(evt);
            }
        });
        mRegistro.add(ms_rProveedor);

        sm_rCategoria.setText("Categoria");
        sm_rCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_rCategoriaActionPerformed(evt);
            }
        });
        mRegistro.add(sm_rCategoria);

        sm_rMarcas.setText("Marcas");
        sm_rMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_rMarcasActionPerformed(evt);
            }
        });
        mRegistro.add(sm_rMarcas);

        sm_rMecanico.setText("Mecanico");
        sm_rMecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_rMecanicoActionPerformed(evt);
            }
        });
        mRegistro.add(sm_rMecanico);

        sm_rVehiculo.setText("Vehiculos");
        sm_rVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_rVehiculoActionPerformed(evt);
            }
        });
        mRegistro.add(sm_rVehiculo);

        jMenuBar1.add(mRegistro);

        mOperaciones.setText("Operaciones");

        sm_oCompra.setText("Compra");
        mOperaciones.add(sm_oCompra);

        sm_oVenta.setText("Venta");
        sm_oVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_oVentaActionPerformed(evt);
            }
        });
        mOperaciones.add(sm_oVenta);

        sm_oCaja.setText("Caja");
        mOperaciones.add(sm_oCaja);

        sm_oNuevoServicio.setText("Nuevo Servicio ");
        sm_oNuevoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sm_oNuevoServicioActionPerformed(evt);
            }
        });
        mOperaciones.add(sm_oNuevoServicio);

        jMenuBar1.add(mOperaciones);

        jMenu1.setText("Mantenimiento");

        jMenuItem1.setText("Ayuda");
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Configuracion");
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedor)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sm_oVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_oVentaActionPerformed
        
      /* if(oFrmVenta == null || oFrmVenta.isVisible() == false){
            oFrmVenta = new frmVenta(oSesion);
            contenedor.add(oFrmVenta);
            oFrmVenta.setVisible(true);
            oFrmVenta.toFront();    
       }*/
        
    }//GEN-LAST:event_sm_oVentaActionPerformed

    private void ms_rProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ms_rProveedorActionPerformed
        if(oFrmProveedor == null || oFrmProveedor.isVisible() == false){
            oFrmProveedor = new frmProveedor(oSesion);
            CentrarVentana(oFrmProveedor);
            //contenedor.add(oFrmProveedor);
            //oFrmProveedor.setVisible(true);
            //oFrmProveedor.toFront();    
       }        
    }//GEN-LAST:event_ms_rProveedorActionPerformed

    private void sm_rClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_rClienteActionPerformed
        if(oFrmCliente == null || oFrmCliente.isVisible() == false){
            oFrmCliente = new frmClientE(oSesion);
            CentrarVentana(oFrmCliente);
            //contenedor.add(oFrmCliente);
            //oFrmCliente.setVisible(true);
            //oFrmCliente.toFront();
        }   
    }//GEN-LAST:event_sm_rClienteActionPerformed

    private void sm_rCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_rCategoriaActionPerformed
        if(oFrmCategoria == null || oFrmCategoria.isVisible() == false){
            oFrmCategoria = new frmCategoria(oSesion);
            CentrarVentana(oFrmCategoria);
            //contenedor.add(oFrmCategoria);
            //oFrmCategoria.setVisible(true);
            //oFrmCategoria.toFront();
        }   
    }//GEN-LAST:event_sm_rCategoriaActionPerformed

    private void sm_rMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_rMarcasActionPerformed
          if(oFrmMarca == null || oFrmMarca.isVisible() == false){
            oFrmMarca = new frmMarca(oSesion);
            CentrarVentana(oFrmMarca);
          //  contenedor.add(oFrmMarca); 
           // oFrmMarca.setVisible(true);
           // oFrmMarca.toFront();
        } 
    }//GEN-LAST:event_sm_rMarcasActionPerformed

    private void sm_rMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_rMecanicoActionPerformed
       if(oFrmMecanico == null || oFrmMecanico.isVisible() == false){
            oFrmMecanico = new frmMecanico(oSesion);
            CentrarVentana(oFrmMecanico);
            /*BasicInternalFrameUI ui = (BasicInternalFrameUI) oFrmMecanico.getUI();
            if (ui.getNorthPane() != null) {
                oFrmMecanico.setBorder(null);
                ui.setNorthPane(null);
                 }*/
            //contenedor.add(oFrmMecanico);
            //oFrmMecanico.setVisible(true);
            //oFrmMecanico.toFront();
       }
    }//GEN-LAST:event_sm_rMecanicoActionPerformed

    private void sm_rProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_rProductoActionPerformed
         if(oFrmProducto == null || oFrmProducto.isVisible() == false){
            oFrmProducto = new frmProducto(oSesion);
            CentrarVentana(oFrmProducto);
            //contenedor.add(oFrmProducto);
            //oFrmProducto.setVisible(true);
            //oFrmProducto.toFront();
       }
    }//GEN-LAST:event_sm_rProductoActionPerformed

    private void sm_rVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_rVehiculoActionPerformed
         if(oFrmVehiculos == null || oFrmVehiculos.isVisible() == false){
            oFrmVehiculos = new frmVehiculos(oSesion);
            //contenedor.add(oFrmVehiculos);
            CentrarVentana(oFrmVehiculos);
          //  oFrmVehiculos.setVisible(true);
          //  oFrmVehiculos.toFront();
             
            
       }
        
        
    }//GEN-LAST:event_sm_rVehiculoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void sm_oNuevoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sm_oNuevoServicioActionPerformed
            if(oFrmServicios == null || oFrmServicios.isVisible() == false){
            oFrmServicios = new Servicios();
            //contenedor.add(oFrmVehiculos);
            CentrarVentana(oFrmServicios);
            BasicInternalFrameUI ui = (BasicInternalFrameUI) oFrmServicios.getUI();
            if (ui.getNorthPane() != null) {
                oFrmServicios.setBorder(null);
                ui.setNorthPane(null);
                 }
            
            }
    }//GEN-LAST:event_sm_oNuevoServicioActionPerformed

    void  CentrarVentana(JInternalFrame frame){
        contenedor.add(frame);
        Dimension dimension=contenedor.getSize();
        Dimension Dframe=frame.getSize();
        frame.setLocation((dimension.width -Dframe.width)/2,(dimension.height-Dframe.height)/2);
        frame.show();
        
    }
    /**
     * @param args the command line arguments
     */
    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu mOperaciones;
    private javax.swing.JMenu mRegistro;
    private javax.swing.JMenuItem ms_rProveedor;
    private javax.swing.JMenuItem sm_oCaja;
    private javax.swing.JMenuItem sm_oCompra;
    private javax.swing.JMenuItem sm_oNuevoServicio;
    private javax.swing.JMenuItem sm_oVenta;
    private javax.swing.JMenuItem sm_rCategoria;
    private javax.swing.JMenuItem sm_rCliente;
    private javax.swing.JMenuItem sm_rMarcas;
    private javax.swing.JMenuItem sm_rMecanico;
    private javax.swing.JMenuItem sm_rProducto;
    private javax.swing.JMenuItem sm_rVehiculo;
    private javax.swing.JLabel txtUsuario;
    // End of variables declaration//GEN-END:variables
}
