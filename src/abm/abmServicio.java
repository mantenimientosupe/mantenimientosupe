

package abm;

import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.modeloServicio;



public class abmServicio extends config.conexion{
    
    sesion  oSesion;
    public abmServicio (sesion pSesion){
        oSesion = pSesion;
        
    
    }
    
    public boolean generarServicio(modeloServicio pModelo){
        PreparedStatement ps = null;
        Connection con = getAbrirConexion();
        ResultSet rs = null;
        String sql  ="";
        
        try {
            //SQL PARA VERIFICAR SI HAY VENTA PENDIENTE O SIN GUARDAR, 
            sql = "select * from venta where user = ? and estado = 0";
            ps = con.prepareStatement(sql);
            ps.setInt(1, oSesion.getIdUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()==false){
                //CREAR NUEVA VENTA
                sql = "INSERT INTO venta(factura_nro, id_cliente, tipo_venta,user,estado)"
                        + "values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1,pModelo.getFactura_nro() );
                ps.setInt(2,pModelo.getId_cliente());
                ps.setString(3,pModelo.getTipo_venta());
                ps.setInt(4,pModelo.getUser());
                ps.setInt(5,pModelo.getEstado() );
                ps.execute();
                
                //CAPTURAR REGISTRO INSERTADO
                sql = "select * from venta where user = ? and estado = 0";
                ps = con.prepareStatement(sql);
                ps.setInt(1, oSesion.getIdUsuario());
                rs = ps.executeQuery();
                rs.next();
            }
            
            if(rs.getRow() >= 1){
                //se carga resultado en el modelo
                pModelo.setId_operacion(rs.getInt("id_operacion"));
                pModelo.setFactura_nro(rs.getString("factura_nro"));
                pModelo.setId_cliente(rs.getInt("id_cliente"));
                pModelo.setTipo_venta(rs.getString("tipo_venta"));
                pModelo.setFecha(rs.getString("fecha"));
                pModelo.setTotalneto(0);
                pModelo.setSubtotal(0);
                pModelo.setIva0(0);
                pModelo.setIva5(0);
                pModelo.setIva10(0);
                pModelo.setTtl_descuento(0);
                pModelo.setTtl_pago(0);
                pModelo.setTtl_saldo(0);
                pModelo.setUser(rs.getInt("user"));
                pModelo.setEstado(rs.getInt("estado"));
                
                con.close();
                return true;
            }else{
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+ e,oSesion.getTituloMensaje(),1);
            return false;
        }finally{
            setCerrarConexion(con);
        }
        
        
        
    }
    
    
}
