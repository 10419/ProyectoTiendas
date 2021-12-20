                            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import conexion.ConexionDB;
import interfacesDao.*;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utils.Generator;
import valores.*;

public class ImplVentasDao implements VentaDao{
    ConexionDB cx= new ConexionDB();
   ArrayList<venta> listaVenta= new ArrayList<>();
   IProductosDao impl=new ImplDaoProducto();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;    
    ArrayList<Detalle> listaD=new ArrayList<>();
    
   
    Generator gn= new Generator();
    
    public int registrarVenta(venta vet,ArrayList<Detalle> listaD ){
          int i=0;
        String idventa=gn.generatorId();
        try {
            query=" insert into venta (venta_id, venta_nombre,venta_total,venta_fecha) "+
                  " values('"+idventa+"','"+vet.getNombre()+"','"+vet.getTotal()+"',now()) ";
            System.out.println("ssss"+query);
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            System.out.println("implementacion.ImplVentasDao.registrarVenta()"+i);
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        } 
        
        System.out.println("implementacion.ImplVentasDao.registrarVenta()"+vet.getNombre());
        System.out.println("implementacion.ImplVentasDao.registrarVenta()"+this.listaD.size());
        String idventaD=gn.generatorId();
        int x=0;
        for (Detalle d:listaD) {
           try {
               query=" insert into detalle_vent (detalle_id ,	detalle_id_venta ,	detalle_id_catidad ,	detalle_id_precio_uni 	,detalle_id_producto ,	detalle_id_precio) "+
                  " values('"+idventaD+"','"+idventa+"','"+d.getCantidad()+"','"+d.getPrecio_uni()+"','"+d.getDescripcion()+"','"+d.getPrecio()+"') ";
            System.out.println("ssss"+query);
            stmt= cx.conectaMysql().createStatement();
            x   = stmt.executeUpdate(query);
            System.out.println("implementacion.ImplVentasDao.registrarDetalle()"+x);
            
           
            impl.actuStock(d.getId(),d.getCantidad());
            
            
            } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        } 
            /*System.out.println("implementacion.ImplVentasDao.registrarVenta()"+d.getDescripcion());
            System.out.println("implementacion.ImplVentasDao.registrarVenta()"+d.getCantidad());
            System.out.println("implementacion.ImplVentasDao.registrarVenta()"+d.getPrecio_uni());
            System.out.println("implementacion.ImplVentasDao.registrarVenta()"+d.getPrecio());*/
            
        }
       
       
        
             
        
        
                      
        
        return i;
    }
    
    public int  actualizaVenta(venta v){
                int i=0;
        try {
            sql=" update  venta " +
                " set venta_nombre='"+v.getNombre()+"', venta_total='"+v.getTotal()+"', venta_fecha='"+v.getFecha()+"'  " +
                " where venta_id  ='"+v.getId()+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("imprim "+sql);
            
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return 1;
    }
    
 public ArrayList<Detalle> reporteProductos(){
        
        try {
            sql=" select * from detalle_vent ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                
                Detalle ps = new Detalle();
                    ps.setId( rset.getString("detalle_id_principal") );
                    ps.setDescripcion(rset.getString("detalle_id_producto") );
                    ps.setPrecio_uni(rset.getString("detalle_id_precio_uni" ));                   
                    ps.setCantidad(rset.getString("detalle_id_catidad"));
                    ps.setPrecio(rset.getString("detalle_id_precio") );
                
                System.out.println("sql"+sql);
                                
                listaD.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaD;
    }
  public ArrayList<Detalle> reporteProducto(){
        
        try {
            sql=" select * from detalle_vent ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                
                Detalle ps = new Detalle();
                    ps.setId( rset.getString("detalle_id") );
                    ps.setId_pi(rset.getString("detalle_id_principal") );
                    ps.setDescripcion(rset.getString("detalle_id_producto") );
                    ps.setPrecio_uni(rset.getString("detalle_id_precio_uni" ));                   
                    ps.setCantidad(rset.getString("detalle_id_catidad"));
                    ps.setPrecio(rset.getString("detalle_id_precio") );
                
                System.out.println("sql"+sql);
                                
                listaD.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaD;
    }

        public int eliminarRegistroVenta(String id){
        
        int i=0;
        try {
            sql=" delete from detalle_vent where detalle_id='"+id+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("Se elimino el registro");
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
    }
   
}