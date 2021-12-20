/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDao;

import java.util.ArrayList;
import valores.Detalle;
import valores.venta;

/**
 *
 * @author INTEL
 */
public interface VentaDao {
    public int  registrarVenta(venta v,ArrayList<Detalle> listaD);
    public int  actualizaVenta(venta v);
    public int eliminarRegistroVenta(String nom);
    public ArrayList<Detalle> reporteProductos();
    public ArrayList<Detalle> reporteProducto();
}
