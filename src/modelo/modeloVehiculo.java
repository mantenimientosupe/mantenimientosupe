
package modelo;

public class modeloVehiculo {
    
    private int estado , id, cliente_fk, marca_fk, categoria_fk ;
    private String Descripcion, modelo, año;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCliente_fk() {
        return cliente_fk;
    }

    public void setCliente_fk(int cliente_fk) {
        this.cliente_fk = cliente_fk;
    }

    public int getMarca_fk() {
        return marca_fk;
    }

    public void setMarca_fk(int marca_fk) {
        this.marca_fk = marca_fk;
    }

    public int getCategoria_fk() {
        return categoria_fk;
    }

    public void setCategoria_fk(int categoria_fk) {
        this.categoria_fk = categoria_fk;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
