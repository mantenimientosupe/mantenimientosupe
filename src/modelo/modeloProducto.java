
package modelo;


public class modeloProducto {
    
    private int id, estado, iva, categoria_fk, marca_fk, proveedor_fk;
    private String barra, descripcion, imagen;
    private float costo, costo_medio, precio_unitario, precio_mayorista, stock, stock_minimo;
    
    public modeloProducto(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getCategoria_fk() {
        return categoria_fk;
    }

    public void setCategoria_fk(int categoria_fk) {
        this.categoria_fk = categoria_fk;
    }

    public int getMarca_fk() {
        return marca_fk;
    }

    public void setMarca_fk(int marca_fk) {
        this.marca_fk = marca_fk;
    }

    public int getProveedor_fk() {
        return proveedor_fk;
    }

    public void setProveedor_fk(int proveedor_fk) {
        this.proveedor_fk = proveedor_fk;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getCosto_medio() {
        return costo_medio;
    }

    public void setCosto_medio(float costo_medio) {
        this.costo_medio = costo_medio;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getPrecio_mayorista() {
        return precio_mayorista;
    }

    public void setPrecio_mayorista(float precio_mayorista) {
        this.precio_mayorista = precio_mayorista;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(float stock_minimo) {
        this.stock_minimo = stock_minimo;
    }
    
    
   
    
    public modeloProducto(int id, int estado, int iva, int categoria_fk, int marca_fk, int proveedor_fk, String barra, String descripcion, String imagen, float costo, float costo_medio, float precio_unitario, float precio_mayorista, float stock, float stock_minimo) {
        this.id = id;
        this.estado = estado;
        this.iva = iva;
        this.categoria_fk = categoria_fk;
        this.marca_fk = marca_fk;
        this.proveedor_fk = proveedor_fk;
        this.barra = barra;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.costo = costo;
        this.costo_medio = costo_medio;
        this.precio_unitario = precio_unitario;
        this.precio_mayorista = precio_mayorista;
        this.stock = stock;
        this.stock_minimo = stock_minimo;
    }
    
    
    
    
    
}
 