package implementacion;

import conexion.ConexionDB;
import interfacesDao.IClientesDao;
import valores.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplCliente implements IClientesDao {
    
    ConexionDB cx= new ConexionDB();
    ArrayList<Cliente> listaClientes= new ArrayList<>();
    String sql="";
    String query="";
    Statement stmt= null;
   
    ResultSet rset=null;    
    
    
    public int  registrarCliente(Cliente c){
        
            int i=0;        
            try {
            query=" insert into cliente (cliente_id,tipo, cliente_persona_id) "+
                  " values('"+c.getCliente_id()+"','"+c.getCliente_tipo()+"','"+c.getCliente_persona_id()+"') ";
            stmt= cx.conectaMysql().createStatement();
            i   = stmt.executeUpdate(query);
            } catch (SQLException ex) {
                ex.getMessage();
            }
        
        return i;
    }
    public int  actualizaCliente(Cliente c){
                int i=0;
        try {
            sql=" update  productos " +
                " set tipo='"+c.getCliente_tipo()+"', cliente_persona_id='"+c.getCliente_persona_id() +
                " where cliente_id  ='"+c.getCliente_id()+"' ";
            stmt=cx.conectaMysql().createStatement();
            i=stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return 1;
    }
      public ArrayList<Cliente> reporteClientes(){
        
        try {
            sql=" select * from productos ";
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            while(rset.next()){
                
                Cliente cs = new Cliente();
                cs.setCliente_id(rset.getString("cliente_id") );
                cs.setCliente_tipo(rset.getString("cliente_tipo") );
                cs.setCliente_persona_id(rset.getString("cliente_persona_id") );
                         
                listaClientes.add(cs);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return listaClientes;
    }
        public Persona BuscarCli(String dni){
          Persona ps = new Persona();
        
        try {
            sql=" select * from persona where persona_codigo='"+dni+"' "; 
            System.out.println("sql"+sql);
            stmt=cx.conectaMysql().createStatement();
            rset=stmt.executeQuery(sql);
            if(rset.next()){
                
              
                
                ps.setNombre( rset.getString("persona_nombre"));
               
                //System.out.println("sql"+sql);
                
                                
                //listaProductos.add(ps);            
            }
        } catch (SQLException ex) {
                ex.getMessage();
        }
        return ps;
    }
    
}
