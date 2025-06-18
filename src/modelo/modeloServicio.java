package modelo;

import config.sesion;

public class modeloServicio {

    sesion oSesion;
    private int id_operacion, id_cliente, user, estado, id_vehiculo;
    private String factura_nro, tipo_venta;
    private float total_costo, subtotal, iva0, iva5, iva10, totalneto, ttl_pago, ttl_descuento, ttl_saldo;
    private String fecha;

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }
   

    public modeloServicio(sesion pSesion) {
        oSesion = pSesion;
    }

    public sesion getoSesion() {
        return oSesion;
    }

    public void setoSesion(sesion oSesion) {
        this.oSesion = oSesion;
    }

    public int getId_operacion() {
        return id_operacion;
    }

    public void setId_operacion(int id_operacion) {
        this.id_operacion = id_operacion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getFactura_nro() {
        return factura_nro;
    }

    public void setFactura_nro(String factura_nro) {
        this.factura_nro = factura_nro;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public float getTotal_costo() {
        return total_costo;
    }

    public void setTotal_costo(float total_costo) {
        this.total_costo = total_costo;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva0() {
        return iva0;
    }

    public void setIva0(float iva0) {
        this.iva0 = iva0;
    }

    public float getIva5() {
        return iva5;
    }

    public void setIva5(float iva5) {
        this.iva5 = iva5;
    }

    public float getIva10() {
        return iva10;
    }

    public void setIva10(float iva10) {
        this.iva10 = iva10;
    }

    public float getTotalneto() {
        return totalneto;
    }

    public void setTotalneto(float totalneto) {
        this.totalneto = totalneto;
    }

    public float getTtl_pago() {
        return ttl_pago;
    }

    public void setTtl_pago(float ttl_pago) {
        this.ttl_pago = ttl_pago;
    }

    public float getTtl_descuento() {
        return ttl_descuento;
    }

    public void setTtl_descuento(float ttl_descuento) {
        this.ttl_descuento = ttl_descuento;
    }

    public float getTtl_saldo() {
        return ttl_saldo;
    }

    public void setTtl_saldo(float ttl_saldo) {
        this.ttl_saldo = ttl_saldo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

}
