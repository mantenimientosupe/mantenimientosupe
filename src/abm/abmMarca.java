
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloMarca;


public class abmMarca extends config.conexion{
    
       sesion  oSesion;
    public abmMarca (sesion pSesion){
        oSesion = pSesion;
    }
    public DefaultTableModel cargarTabla(String condicion){
        //ahora cargar el objeto encabezado a default
        
        DefaultTableModel modelo = new DefaultTableModel();
       
        Object encabezado[] = new Object[3];
        encabezado[0] = "CODIGO";
        encabezado[1] = "DESCRIPCION";
        encabezado[2] = "ESTADO";
        modelo.setColumnIdentifiers(encabezado);
               
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from marca" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[3];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_marca");
                filas[1] = datos.getString("descripcion");
                filas[2] = datos.getInt("estado");
                modelo.addRow(filas);
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
                        
        return modelo;
        
        }
    
    
    
    public boolean cargarRegistro(modeloMarca pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from marca where id_marca = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_marca"));
                pModelo.setDescripcion(resultado.getString("descripcion"));
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
    public boolean eliminarRegistro(modelo.modeloMarca modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from marca where id_marca = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
    }
    
    public boolean insertarRegistro(modelo.modeloMarca modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into marca(Descripcion, estado) values (?,?)";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getDescripcion());
            preparaConsulta.setInt(2,modelo.getEstado());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloMarca modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update marca set descripcion = ?, estado = ? where id_marca = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setString(1,modelo.getDescripcion());
            preparaConsulta.setInt(2,modelo.getEstado());
            preparaConsulta.setInt(3,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    }
}
