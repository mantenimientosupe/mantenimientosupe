
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloProveedor;


public class abmProveedor extends config.conexion{
    
       sesion  oSesion;
    public abmProveedor (sesion pSesion){
        oSesion = pSesion;
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
            sql = "select * from proveedor" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[6];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_proveedor");
                filas[1] = datos.getString("razon_social");
                filas[2] = datos.getString("documento_numero");
                filas[3] = datos.getString("telefono");
                filas[4] = datos.getString("direccion");
                filas[5] = datos.getInt("estado");
                modelo.addRow(filas);
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
                        
        return modelo;
        
        }
    
    
    
    public boolean cargarRegistro(modeloProveedor pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from proveedor where id_proveedor = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_proveedor"));
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
        }
    } 
    public boolean eliminarRegistro(modelo.modeloProveedor modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from proveedor where id_proveedor = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
    }
    
    public boolean insertarRegistro(modelo.modeloProveedor modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into proveedor(razon_social, documento_numero, telefono, direccion, estado) values (?,?,?,?,?)";
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
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloProveedor modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update proveedor set razon_social = ?, documento_numero = ?, telefono = ?, direccion = ?, estado = ? where id_proveedor = ?";
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
        }
        
    }
}
