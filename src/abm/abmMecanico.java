
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloMecanico;


public class abmMecanico extends config.conexion{
    
       sesion  oSesion;
    public abmMecanico (sesion pSesion){
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
            sql = "select * from mecanico" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[6];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_mecanico");
                filas[1] = datos.getString("nombre");
                filas[2] = datos.getString("documento_nro");
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
    
    
    
    public boolean cargarRegistro(modeloMecanico pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from mecanico where id_mecanico = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_mecanico"));
                pModelo.setnombre(resultado.getString("nombre"));
                pModelo.setDocumento_nro(resultado.getString("documento_nro"));
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
    public boolean eliminarRegistro(modelo.modeloMecanico modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from mecanico where id_mecanico = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
    }
    
    public boolean insertarRegistro(modelo.modeloMecanico modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into mecanico(nombre, documento_nro, telefono, direccion, estado) values (?,?,?,?,?)";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getnombre());
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
    
    public boolean actualizarRegistro(modelo.modeloMecanico modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update mecanico set nombre = ?, documento_nro = ?, telefono = ?, direccion = ?, estado = ? where id_mecanico = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setString(1,modelo.getnombre());
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
