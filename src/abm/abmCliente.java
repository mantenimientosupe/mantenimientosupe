
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCliente;


public class abmCliente extends config.conexion{
    
       sesion  oSesion;
    public abmCliente (sesion pSesion){
        oSesion = pSesion;
    }
    
    public DefaultComboBoxModel cargarCombo(){
    
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from Cliente";
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            
            while(datos.next() == true){
                String valor = datos.getInt("id_cliente")+"-"+ datos.getString("razon_social");
                modelo.addElement(valor);
            }     
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }finally{
            setCerrarConexion(conex);
        }
                        
        return modelo;
    
    }
    public DefaultTableModel cargarTabla(String condicion){
        //ahora cargar el objeto encabezado a default
        
        DefaultTableModel modelo = new DefaultTableModel();
       
        Object encabezado[] = new Object[6];
        encabezado[0] = "CODIGO";
        encabezado[1] = "RAZON SOCIAL";
        encabezado[2] = "RUC";
        encabezado[3] = "TELEFONO";
        encabezado[4] = "DIRECCION";
        encabezado[5] = "ESTADO";
        modelo.setColumnIdentifiers(encabezado);
               
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from cliente" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[6];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_cliente");
                filas[1] = datos.getString("razon_social");
                filas[2] = datos.getString("documento_numero");
                filas[3] = datos.getString("telefono");
                filas[4] = datos.getString("direccion");
                filas[5] = datos.getInt("estado");
                modelo.addRow(filas);
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }finally{
            setCerrarConexion(conex);
        }
                        
        return modelo;
        
        }
    
    
    
    public boolean cargarRegistro(modeloCliente pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from cliente where id_cliente = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_cliente"));
                pModelo.setRazon_social(resultado.getString("razon_social"));
                pModelo.setDocumento_nro(resultado.getString("documento_numero"));
                pModelo.setTelefono(resultado.getString("telefono"));
                pModelo.setDireccion(resultado.getString("direccion"));
                pModelo.setEstado(resultado.getInt("estado"));
                conex.close();
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }finally{
            setCerrarConexion(conex);
        }
    } 
    public boolean eliminarRegistro(modelo.modeloCliente modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from cliente where id_cliente = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }finally{
            setCerrarConexion(conex);
        }
    }
    
    public boolean insertarRegistro(modelo.modeloCliente modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into cliente(razon_social, documento_numero, telefono, direccion, estado) values (?,?,?,?,?)";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getRazon_social());
            preparaConsulta.setString(2,modelo.getDocumento_nro());
            preparaConsulta.setString(3,modelo.getTelefono());
            preparaConsulta.setString(4,modelo.getDireccion());
            preparaConsulta.setInt(5,modelo.getEstado());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }finally{
            setCerrarConexion(conex);
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloCliente modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update cliente set razon_social = ?, documento_numero = ?, telefono = ?, direccion = ?, estado = ? where id_cliente = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setString(1,modelo.getRazon_social());
            preparaConsulta.setString(2,modelo.getDocumento_nro());
            preparaConsulta.setString(3,modelo.getTelefono());
            preparaConsulta.setString(4,modelo.getDireccion());
            preparaConsulta.setInt(5,modelo.getEstado());
            preparaConsulta.setInt(6,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }finally{
            setCerrarConexion(conex);
        }
        
    }
}
