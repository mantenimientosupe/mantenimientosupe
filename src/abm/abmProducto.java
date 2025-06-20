
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
        encabezado[5] = "C.Medio";
        encabezado[6] = "P.Unitario";
        encabezado[7] = "P.Mayorista";
        encabezado[8] = "Stock";
        encabezado[9] = "S.Minimo";
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
                filas[4] = datos.getFloat("costo");
                filas[5] = datos.getFloat("costomedio");
                filas[6] = datos.getFloat("precio_unitario");
                filas[7] = datos.getFloat("precio_mayorista");
                filas[8] = datos.getFloat("stock");
                filas[9] = datos.getFloat("stock_minimo");
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
    public boolean verProductoVenta(modeloProducto pModelo) {
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            if (pModelo.getId() == 0) {
                sql = "select * from producto where estado = 1 and barra = ? ";
                preparaConsulta = conex.prepareStatement(sql);
                preparaConsulta.setString(1, pModelo.getBarra());
            } else {
                sql = "select * from producto where estado = 1 and (barra = ?  or id_producto = ?) ";
                preparaConsulta = conex.prepareStatement(sql);
                preparaConsulta.setString(1, pModelo.getBarra());
                preparaConsulta.setInt(2, pModelo.getId());
            }

            resultado = preparaConsulta.executeQuery();
            if (resultado.next() == true) {
                //se carga en el modelo los datos obtenidos de la db-----------------------------------
                pModelo.setId(resultado.getInt("id"));
                pModelo.setBarra(resultado.getString("barra"));
                pModelo.setDescripcion(resultado.getString("descripcion"));
                pModelo.setIva(resultado.getByte("iva"));
                pModelo.setCosto(resultado.getFloat("costo"));
                pModelo.setCosto_medio(resultado.getFloat("costomedio"));
                pModelo.setPrecio_unitario(resultado.getFloat("precio_unitario"));
                pModelo.setPrecio_mayorista(resultado.getFloat("precio_mayorista"));
                pModelo.setStock(resultado.getFloat("stock"));
                pModelo.setEstado(resultado.getByte("estado"));
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
                pModelo.setCosto(resultado.getFloat("costo"));
                pModelo.setCosto_medio(resultado.getFloat("costomedio"));
                pModelo.setPrecio_unitario(resultado.getFloat("precio_unitario"));
                pModelo.setPrecio_mayorista(resultado.getFloat("precio_mayorista"));
                pModelo.setStock(resultado.getFloat("stock"));
                pModelo.setStock_minimo(resultado.getFloat("stock_minimo"));
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
                preparaConsulta.setFloat(4,modelo.getCosto());
                preparaConsulta.setFloat(5,modelo.getCosto_medio());
                preparaConsulta.setFloat(6,modelo.getPrecio_unitario());
                preparaConsulta.setFloat(7,modelo.getPrecio_mayorista());
                preparaConsulta.setFloat(8,modelo.getStock());
                preparaConsulta.setFloat(9,modelo.getStock_minimo());
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
            preparaConsulta.setFloat(4,modelo.getCosto());
            preparaConsulta.setFloat(5,modelo.getCosto_medio());
            preparaConsulta.setFloat(6,modelo.getPrecio_unitario());
            preparaConsulta.setFloat(7,modelo.getPrecio_mayorista());
            preparaConsulta.setFloat(8,modelo.getStock());
            preparaConsulta.setFloat(9,modelo.getStock_minimo());
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
    
    public DefaultTableModel cargarTablaSeleccion(String condicion) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(new Object[]{"Id_producto", "Barra", "Descripcion", "Precio May.", "Precio Unit.", "Stock"});

        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;
        try {
            sql = "select * from producto " + condicion;
            preparaConsulta = conex.prepareStatement(sql);
            resultado = preparaConsulta.executeQuery();

            while (resultado.next() == true) {
                modeloTabla.addRow(new Object[]{
                    resultado.getInt("id_producto"),
                    resultado.getString("barra"),
                    resultado.getString("descripcion"),
                    resultado.getFloat("precio_mayorista"),
                    resultado.getFloat("precio_unitario"),
                    resultado.getFloat("stock")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, oSesion.getTituloMensaje(), 1);
        }
        return modeloTabla;
    }
    
        
}
