
package modelo;

    
public class modeloUsuario {
   private int Id, Nivel, Stock_insuficiente;   
   private String Nombre, Usuario, Password, Cargo, Vender_hasta;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public int getStock_insuficiente() {
        return Stock_insuficiente;
    }

    public void setStock_insuficiente(int Stock_insuficiente) {
        this.Stock_insuficiente = Stock_insuficiente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getVender_hasta() {
        return Vender_hasta;
    }

    public void setVender_hasta(String Vender_hasta) {
        this.Vender_hasta = Vender_hasta;
    }
      
    
}
