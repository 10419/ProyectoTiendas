package implementacion;

import conexion.ConexionDB;

import valores.*;
import interfacesDao.IProductosDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.Generator;

public class ImplDaoProducto implements IProductosDao{
    
    ConexionDB cx= new ConexionDB();
    ArrayList<Producto> listaProductos= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
    ResultSet rset=null;    
    Producto ps = new Producto();
    Generator gn= new Generator();
    
    public int registrarProducto(Producto prod){
        
         int i=0;
        String idpersona=gn.generatorId();
        try {
            query=" insert into productos (productos_id, productos_nombre,productos_marca,productos_modelo,productos_precio, productos_talla, producto_stock) "+
                  " values('"+idpersona+"','"+prod.getNombre()+"','"+prod.getMarca()+"','"+prod.getModelo()+"','"+prod.getPrecio()+"','"+prod.getTalla()+"','"+prod.getStock()+"') ";
            System.out.println("ssss"+query);
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage()); 
        }       
        
        
                      
        
        return i;
    }
    
    public int  actualizaProducto(Producto p){
                int i=0;
        try {
            sql=" update  productos " +
                " set productos_nombre='"+p.getNombre()+"', productos_marca='"+p.getMarca()+"', productos_modelo='"+p.getModelo()+"', productos_precio='"+p.getPrecio()+"', productos_talla='"+p.getTalla()+"', producto_stock='"+p.getStock()+"'  "+
                " where productos_id  ='"+p.getId()+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("imprim "+sql);
            
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return 1;
    }
    
    public ArrayList<Producto> reporteProductos(){
        
        try {
            sql=" select * from productos ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                
                Producto ps = new Producto();
                ps.setId( rset.getString("productos_id") );
                ps.setNombre( rset.getString("productos_nombre") );
                ps.setMarca( rset.getString("productos_marca") );
                ps.setModelo( rset.getString("productos_modelo"));
                ps.setTalla( rset.getString("productos_talla"));
                ps.setPrecio( rset.getDouble("productos_precio"));
                ps.setStock( rset.getInt("producto_stock") );
                System.out.println("sql"+sql);
                                
                listaProductos.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaProductos;
    }
    public Producto reporteProductosnom(String nom){
          Producto ps = new Producto();
        
        try {
            sql=" select * from productos where productos_nombre='"+nom+"' "; 
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
              
                ps.setId( rset.getString("productos_id") );
                ps.setNombre( rset.getString("productos_nombre") );
                ps.setMarca( rset.getString("productos_marca") );
                ps.setModelo( rset.getString("productos_modelo"));
                ps.setTalla( rset.getString("productos_talla"));
                ps.setPrecio( rset.getDouble("productos_precio"));
                ps.setStock( rset.getInt("producto_stock") );
                System.out.println("sql"+sql);
                                
                //listaProductos.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return ps;
    }
        public int eliminarRegistroProductos(String id){
        
        int i=0;
        try {
            sql=" delete from productos where productos_id='"+id+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            System.out.println("Se elimino el registro");
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return i;
    }
        public int actuStock(String id, String Cantidad){
            int i=0;             
            try {
                sql=" update  productos "+
                " set producto_stock= producto_stock - '"+Cantidad+"'"+
                " where productos_id='"+id+"'" ;
                System.out.println(" imprim "+sql);
                stmt=cx.conectaMysql().createStatement();
                i=stmt.executeUpdate(sql);
                
            } catch (SQLException e) {
                e.getMessage();
            }
            return i;
        }
}
