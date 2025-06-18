
package abm;

import config.conexion;
import config.sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.modeloCotizacion;


public class abmCotizacion extends conexion{
    
    sesion oSesion;
    public abmCotizacion(sesion pSesion){
        oSesion = pSesion;
    }
    
    public boolean cargarCotizacion(modeloCotizacion pMod){
        PreparedStatement preparaConsulta = null;
        Connection conex = getAbrirConexion();
        String sql = "";
        ResultSet resultado = null;

        try {
            sql = "SELECT * FROM cotizacion order by fecha desc limit 1";
            preparaConsulta = conex.prepareStatement(sql);
            resultado = preparaConsulta.executeQuery();
            if (resultado.next() == true) {
                pMod.setGs(resultado.getFloat("gs"));
                pMod.setUs(resultado.getFloat("us"));
                pMod.setRs(resultado.getFloat("rs"));
                pMod.setPs(resultado.getFloat("ps"));
                pMod.setTj(resultado.getFloat("tj"));
                pMod.setCr(resultado.getFloat("cr"));
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
    
}
