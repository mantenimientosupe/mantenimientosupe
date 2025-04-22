
package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.modeloCliente;
import modelo.modeloProducto;



public class abmProducto extends config.conexion{
    
       sesion  oSesion;
    public abmProducto (sesion pSesion){
        oSesion = pSesion;
    }
    public DefaultTableModel cargarTabla(String condicion){
        //ahora cargar el objeto encabezado a default
        DefaultTableModel modelo = new DefaultTableModel();
       
        Object encabezado[] = new Object[14];
        encabezado[0] = "Codigo";
        encabezado[1] = "Barra";
        encabezado[2] = "Descripcion";
        encabezado[3] = "IVA";
        encabezado[4] = "Costo";
        encabezado[5] = "Costo Medio";
        encabezado[6] = "Precio unitario";
        encabezado[7] = "Precio Mayorista";
        encabezado[8] = "Stock";
        encabezado[9] = "Stock Minimo";
        encabezado[10] = "Estado";
        encabezado[11] = "Categoria";
        encabezado[12] = "Marca";
        encabezado[13] = "Proveedor";
 
        modelo.setColumnIdentifiers(encabezado);
               
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select * from producto" + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
            Object filas[] = new Object[14];
            while(datos.next() == true){
                filas[0] = datos.getInt("id_producto");
                filas[1] = datos.getString("barra");
                filas[2] = datos.getString("descripcion");
                filas[3] = datos.getInt("iva");
                filas[4] = datos.getDouble("costo");
                filas[5] = datos.getDouble("costomedio");
                filas[6] = datos.getDouble("precio_unitario");
                filas[7] = datos.getDouble("precio_mayorista");
                filas[8] = datos.getDouble("stock");
                filas[9] = datos.getDouble("stock_minimo");
                filas[10] = datos.getInt("estado");
                filas[11] = datos.getInt("id_categoria_fk");
                filas[12] = datos.getInt("id_marca_fk");
                filas[13] = datos.getInt("id_proveedor_fk");
                
               
                modelo.addRow(filas);
            }  
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
                        
        return modelo;
        
        }
    
   /* public DefaultComboBoxModel CargarCategoria(){
        DefaultComboBoxModel categoria = new DefaultComboBoxModel();
        
        PreparedStatement preparaConsulta = null;
        ResultSet datos = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "select id_producto, descripcion from producto";
            preparaConsulta = conex.prepareStatement(sql);
            datos = preparaConsulta.executeQuery();
           // String[] filas = new String[2];
            while(datos.next() == true){
                String codigo = String.valueOf(datos.getInt("id_producto"));
                String descripcion = datos.getString("descripcion");
                categoria.addElement(codigo+descripcion);            
             //   cat.addRow(filas);
            }  
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
        return categoria;
    }*/
    
    public boolean cargarRegistro(modeloProducto pModelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "select * from producto where id_producto = ? ";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1, pModelo.getId());
            resultado = preparaConsulta.executeQuery();

            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id_producto"));
                pModelo.setBarra(resultado.getString("barra"));
                pModelo.setDescripcion(resultado.getString("descripcion"));
                pModelo.setIva(resultado.getInt("iva"));
                pModelo.setCosto(resultado.getDouble("costo"));
                pModelo.setCosto_medio(resultado.getDouble("costomedio"));
                pModelo.setPrecio_unitario(resultado.getDouble("precio_unitario"));
                pModelo.setPrecio_mayorista(resultado.getDouble("precio_mayorista"));
                pModelo.setStock(resultado.getDouble("stock"));
                pModelo.setStock_minimo(resultado.getDouble("stock_minimo"));
                pModelo.setEstado(resultado.getInt("estado"));
                pModelo.setCategoria_fk(resultado.getInt("id_categoria_fk"));
                pModelo.setMarca_fk(resultado.getInt("id_marca_fk"));
                pModelo.setProveedor_fk(resultado.getInt("id_proveedor_fk"));
                             
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
    
    public boolean eliminarRegistro(modelo.modeloProducto modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "delete from producto where id_producto = ?";
            preparaConsulta = conex.prepareStatement(sql);
            preparaConsulta.setInt(1,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
    }
    
    public boolean insertarRegistro(modelo.modeloProducto modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "insert into producto(barra, descripcion, iva, costo, costomedio, precio_unitario, precio_mayorista, "
                    + "stock, stock_minimo, estado, id_categoria_fk, id_marca_fk, id_proveedor_fk) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparaConsulta = conex.prepareStatement(sql);
                preparaConsulta.setString(1,modelo.getBarra());
                preparaConsulta.setString(2,modelo.getDescripcion());
                preparaConsulta.setInt(3,modelo.getIva());
                preparaConsulta.setDouble(4,modelo.getCosto());
                preparaConsulta.setDouble(5,modelo.getCosto_medio());
                preparaConsulta.setDouble(6,modelo.getPrecio_unitario());
                preparaConsulta.setDouble(7,modelo.getPrecio_mayorista());
                preparaConsulta.setDouble(8,modelo.getStock());
                preparaConsulta.setDouble(9,modelo.getStock_minimo());
                preparaConsulta.setInt(10,modelo.getEstado());
                preparaConsulta.setInt(11,modelo.getCategoria_fk());
                preparaConsulta.setInt(12,modelo.getMarca_fk());
                preparaConsulta.setInt(13,modelo.getProveedor_fk());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    } 
    
    public boolean actualizarRegistro(modelo.modeloProducto modelo){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        
        try {
            sql = "update producto set barra = ?, descripcion = ?, iva = ?, costo = ?, costomedio = ?, precio_unitario = ?, precio_mayorista = ?, stock = ?, stock_minimo = ?, estado =? where id_producto = ?";
            preparaConsulta = conex.prepareStatement(sql);
            
            preparaConsulta.setString(1,modelo.getBarra());
            preparaConsulta.setString(2,modelo.getDescripcion());
            preparaConsulta.setInt(3,modelo.getIva());
            preparaConsulta.setDouble(4,modelo.getCosto());
            preparaConsulta.setDouble(5,modelo.getCosto_medio());
            preparaConsulta.setDouble(6,modelo.getPrecio_unitario());
            preparaConsulta.setDouble(7,modelo.getPrecio_mayorista());
            preparaConsulta.setDouble(8,modelo.getStock());
            preparaConsulta.setDouble(9,modelo.getStock_minimo());
            preparaConsulta.setInt(10,modelo.getEstado());
           // preparaConsulta.setInt(11,modelo.getCategoria_fk());
           // preparaConsulta.setInt(12,modelo.getMarca_fk());
           // preparaConsulta.setInt(13,modelo.getProveedor_fk());
            preparaConsulta.setInt(11,modelo.getId());
            preparaConsulta.execute();
            return true;
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
            return false;
        }
        
    }
    
    
        
}
