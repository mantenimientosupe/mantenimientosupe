package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloUsuario;


public class abmUsuario extends config.conexion{
    
       sesion  oSesion;
    public abmUsuario(sesion pSesion){
        oSesion = pSesion;
    }
    public DefaultTableModel cargarTabla(String condicion){
        //ahora cargar el objeto encabezado a default
        
        DefaultTableModel modelo = new DefaultTableModel();
       
        Object encabezado[] = new Object[7];
        encabezado[0] = "CODIGO";
        encabezado[1] = "NOMBRE";
        encabezado[2] = "USUARIO";
        encabezado[3] = "NIVEL";
        encabezado[4] = "CARGO";
        encabezado[5] = "VENDER HASTA";
        encabezado[6] = "STOCK_INSUFICIENTE";
        
        modelo.setColumnIdentifiers(encabezado);
               
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from usuario" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[7];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_usuario");
                filas[1] = datos.getString("nombre");
                filas[2] = datos.getString("usuario");
                filas[3] = datos.getString("nivel");
                filas[4] = datos.getString("cargo");
                filas[5] = datos.getString("vender_hasta");
                filas[6] = datos.getInt("stock_insuficiente");
                modelo.addRow(filas);
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
                        
        return modelo;
        
        }
    
    
    
    public boolean cargarRegistro(modeloUsuario pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from usuario where id_usuario = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_usuario"));
                pModelo.setNombre(resultado.getString("nombre"));
                pModelo.setUsuario(resultado.getString("usuario"));
                pModelo.setPassword(resultado.getString("password"));
                pModelo.setNivel(resultado.getInt("nivel"));
                pModelo.setCargo(resultado.getString("cargo"));
                pModelo.setVender_hasta(resultado.getString("vender_hasta"));
                pModelo.setStock_insuficiente(resultado.getInt("Stock_insuficiente"));
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
    public boolean eliminarRegistro(modelo.modeloUsuario modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from usuario where id_usuario = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
    }
    
    public boolean insertarRegistro(modelo.modeloUsuario modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into usuario(nombre, usuario, password, nivel, cargo, vender_hasta, stock_insuficiente) values (?,?,?,?,?,?,?)";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getNombre());
            preparaConsulta.setString(2,modelo.getUsuario());
            preparaConsulta.setString(3,modelo.getPassword());
            preparaConsulta.setInt(4,modelo.getNivel());
            preparaConsulta.setString(5,modelo.getCargo());
            preparaConsulta.setString(6,modelo.getVender_hasta());
            preparaConsulta.setInt(7,modelo.getStock_insuficiente());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloUsuario modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update usuario set  nombre = ?, usuario = ?, password = ?, nivel = ?, cargo = ?, vender_hasta = ?, stock_insuficiente=? where id_usuario = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setString(1,modelo.getNombre());
            preparaConsulta.setString(2,modelo.getUsuario());
            preparaConsulta.setString(3,modelo.getPassword());
            preparaConsulta.setInt(4,modelo.getNivel());
            preparaConsulta.setString(5,modelo.getCargo());
            preparaConsulta.setString(6,modelo.getVender_hasta());
            preparaConsulta.setInt(7,modelo.getStock_insuficiente());
            preparaConsulta.setInt(8,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    }
}
