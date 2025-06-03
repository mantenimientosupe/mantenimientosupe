
package vista;

import java.awt.Color;
import config.sesion;
import javax.swing.JOptionPane;


public class frmNewLogin extends javax.swing.JFrame {

    int xMouse, yMouse;
    sesion oSesion =new sesion(); 
    frmMenuPrincipal oFrmMenu;
    public frmNewLogin() {
        initComponents();
        txtUsuario.setText("DerPer");
        txtPassword.setText("123");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelCabecera = new javax.swing.JPanel();
        btnExtit = new javax.swing.JPanel();
        txtExit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JPanel();
        txtEntrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 134, 190));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mantenimiento de Autos - UPE CDE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 470, 80));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/sat_logo_2x.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 390, 190));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/on Auto.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 390, 210));

        panelCabecera.setBackground(new java.awt.Color(255, 255, 255));
        panelCabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCabeceraMouseDragged(evt);
            }
        });
        panelCabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCabeceraMousePressed(evt);
            }
        });

        btnExtit.setBackground(new java.awt.Color(255, 255, 255));

        txtExit.setBackground(new java.awt.Color(255, 255, 255));
        txtExit.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txtExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtExit.setText("X");
        txtExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnExtitLayout = new javax.swing.GroupLayout(btnExtit);
        btnExtit.setLayout(btnExtitLayout);
        btnExtitLayout.setHorizontalGroup(
            btnExtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
            .addGroup(btnExtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
        );
        btnExtitLayout.setVerticalGroup(
            btnExtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
            .addGroup(btnExtitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtExit, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addComponent(btnExtit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 804, Short.MAX_VALUE))
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addComponent(btnExtit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(panelCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 50));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 134, 191));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/1176.png"))); // NOI18N
        jLabel5.setText("INICIAR SESION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 410, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 134, 190));
        jLabel4.setText("USUARIO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 100, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 134, 190));
        jLabel7.setText("CONTRASEÑA");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 100, -1));

        txtUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUsuarioMousePressed(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 420, 30));

        txtPassword.setForeground(new java.awt.Color(204, 204, 204));
        txtPassword.setText("********");
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 420, 30));

        btnEntrar.setBackground(new java.awt.Color(0, 134, 190));

        txtEntrar.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        txtEntrar.setForeground(new java.awt.Color(255, 255, 255));
        txtEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEntrar.setText("ENTRAR");
        txtEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEntrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnEntrarLayout = new javax.swing.GroupLayout(btnEntrar);
        btnEntrar.setLayout(btnEntrarLayout);
        btnEntrarLayout.setHorizontalGroup(
            btnEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        btnEntrarLayout.setVerticalGroup(
            btnEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void panelCabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelCabeceraMousePressed

    private void panelCabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCabeceraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_panelCabeceraMouseDragged

    private void txtExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseExited
        btnExtit.setBackground(Color.white);
        txtExit.setForeground(Color.black);
    }//GEN-LAST:event_txtExitMouseExited

    private void txtExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseEntered
        btnExtit.setBackground(Color.red);
        txtExit.setForeground(Color.white);
    }//GEN-LAST:event_txtExitMouseEntered

    private void txtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_txtExitMouseClicked

    private void txtEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEntrarMouseEntered
        btnEntrar.setBackground(new Color (0, 156, 223));
    }//GEN-LAST:event_txtEntrarMouseEntered

    private void txtEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEntrarMouseExited
         btnEntrar.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_txtEntrarMouseExited

    private void txtUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMousePressed
      if(txtUsuario.getText().equals("Ingrese su nombre de usuario")){
          txtUsuario.setText("");
          txtUsuario.setForeground(Color.black);}
      if(String.valueOf(txtPassword.getPassword()).isEmpty()){
            txtPassword.setText("********");
            txtPassword.setForeground(Color.gray);}
    }//GEN-LAST:event_txtUsuarioMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if(String.valueOf(txtPassword.getPassword()).equals("********")){
            txtPassword.setText("");
            txtPassword.setForeground(Color.black);}
        if(txtUsuario.getText().isEmpty()){
            txtUsuario.setText("Ingrese su nombre de usuario");
            txtUsuario.setForeground(Color.gray);}
    }//GEN-LAST:event_txtPasswordMousePressed

    private void txtEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEntrarMouseClicked
        controlarAcceso();
    }//GEN-LAST:event_txtEntrarMouseClicked

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
         if(oSesion.verificarEnter(evt)==true){
           txtPassword.requestFocus();
       }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
         if(oSesion.verificarEnter(evt)==true){
            controlarAcceso();}
        
    }//GEN-LAST:event_txtPasswordKeyPressed
    
     public void controlarAcceso(){
        
        String usuario = txtUsuario.getText();
        String pass = String.valueOf(txtPassword.getPassword());
        
        if(oSesion.verificarAcceso(usuario, pass) == true){
            oFrmMenu  = new frmMenuPrincipal(oSesion);
            oFrmMenu.setVisible(true);
            oFrmMenu.setExtendedState(oFrmMenu.MAXIMIZED_BOTH);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
    public static void main(String args[]) {
        

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNewLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnEntrar;
    private javax.swing.JPanel btnExtit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JLabel txtEntrar;
    private javax.swing.JLabel txtExit;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
