/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valores;

/**
 *
 * @author INTEL
 */
public class Detalle {
    private String cantidad ;
    private String id ;
    private String descripcion ;
    private String id_pi ;
    private String precio ;
    private String precio_uni ;
    public String getId_pi() {
        return id_pi;
    }

    public void setId_pi(String id_pi) {
        this.id_pi = id_pi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPrecio_uni() {
        return precio_uni;
    }

    public void setPrecio_uni(String precio_uni) {
        this.precio_uni = precio_uni;
    }
}
