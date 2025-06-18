
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCategoria;


public class abmCategoria extends config.conexion{
    
       sesion  oSesion;
    public abmCategoria (sesion pSesion){
        oSesion = pSesion;
    }
    public DefaultComboBoxModel cargarCombo(){
    
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); 
        
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from categoria";
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            
            while(datos.next() == true){
                String valor = datos.getInt("id_categoria")+"-"+ datos.getString("descripcion");
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
            sql = "select * from categoria" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[3];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_categoria");
                filas[1] = datos.getString("descripcion");
                filas[2] = datos.getInt("estado");
                modelo.addRow(filas);
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }finally{
            setCerrarConexion(conex);
        }
                        
        return modelo;
        
        }
    
    
    
    public boolean cargarRegistro(modeloCategoria pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from categoria where id_categoria = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_categoria"));
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
        }finally{
            setCerrarConexion(conex);
        }
    } 
    public boolean eliminarRegistro(modelo.modeloCategoria modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from categoria where id_categoria = ?";
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
    
    public boolean insertarRegistro(modelo.modeloCategoria modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into categoria(Descripcion, estado) values (?,?)";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getDescripcion());
            preparaConsulta.setInt(2,modelo.getEstado());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }finally{
            setCerrarConexion(conex);
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloCategoria modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update categoria set descripcion = ?, estado = ? where id_categoria = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setString(1,modelo.getDescripcion());
            preparaConsulta.setInt(2,modelo.getEstado());
            preparaConsulta.setInt(3,modelo.getId());
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
