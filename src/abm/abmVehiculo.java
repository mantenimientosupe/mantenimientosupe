
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloVehiculo;


public class abmVehiculo extends config.conexion{
    
       sesion  oSesion;
    public abmVehiculo (sesion pSesion){
        oSesion = pSesion;
    }
    
    
    public DefaultTableModel cargarTabla(String condicion){
        //ahora cargar el objeto encabezado a default
        
        DefaultTableModel modelo = new DefaultTableModel();
       
        Object encabezado[] = new Object[7];
        encabezado[0] = "CODIGO";
        encabezado[1] = "DESCRIPCION";
        encabezado[2] = "MODELO";
        encabezado[3] = "AÑO";
        encabezado[4] = "CLIENTE";
        encabezado[5] = "MARCA";
        encabezado[6] = "CATEGORIA";
        modelo.setColumnIdentifiers(encabezado);
               
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from vehiculo" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[7];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_vehiculo");
                filas[1] = datos.getString("descripcion");
                filas[2] = datos.getString("modelo");
                filas[3] = datos.getString("anho");
                filas[4] = datos.getInt("id_cliente_fk");
                filas[5] = datos.getInt("id_marca_fk");
                filas[6] = datos.getInt("id_categoria_fk");
                modelo.addRow(filas);
            }                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
                        
        return modelo;
        
        }
    
    
    
    public boolean cargarRegistro(modeloVehiculo pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from vehiculo where id_vehiculo = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_vehiculo"));
                pModelo.setDescripcion(resultado.getString("descripcion"));
                pModelo.setModelo(resultado.getString("modelo"));
                pModelo.setAño(resultado.getString("anho"));
                pModelo.setCliente_fk(resultado.getInt("id_cliente_fk"));
                pModelo.setMarca_fk(resultado.getInt("id_marca_fk"));
                pModelo.setCategoria_fk(resultado.getInt("id_categoria_fk"));
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
    public boolean eliminarRegistro(modelo.modeloVehiculo modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from vehiculo where id_vehiculo = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
    }
    
    public boolean insertarRegistro(modelo.modeloVehiculo modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into vehiculo(Descripcion, modelo, anho, id_cliente_fk, id_marca_fk, id_categoria_fk) values (?,?,?,?,?,?)";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getDescripcion());
            preparaConsulta.setString(2,modelo.getModelo());
            preparaConsulta.setString(3,modelo.getAño());
            preparaConsulta.setInt(4,modelo.getCliente_fk());
            preparaConsulta.setInt(5,modelo.getMarca_fk());
            preparaConsulta.setInt(6,modelo.getCategoria_fk());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloVehiculo modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update vehiculo set descripcion = ?, modelo = ?, anho = ?, id_cliente_fk = ?, id_marca_fk = ?, id_categoria_fk = ? where id_vehiculo = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setString(1,modelo.getDescripcion());
            preparaConsulta.setString(2,modelo.getModelo());
            preparaConsulta.setString(3,modelo.getAño());
            preparaConsulta.setInt(4,modelo.getCliente_fk());
            preparaConsulta.setInt(5,modelo.getMarca_fk());
            preparaConsulta.setInt(6,modelo.getCategoria_fk());
            preparaConsulta.setInt(7,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    }
}
