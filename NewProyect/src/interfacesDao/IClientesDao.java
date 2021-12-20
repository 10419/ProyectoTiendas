package interfacesDao;

import valores.Cliente;
import java.util.ArrayList;
import valores.Persona;
import valores.Producto;

public interface IClientesDao {
    
    public int  registrarCliente(Cliente prod);
    public int  actualizaCliente(Cliente prod);
   //public int eliminarCliente(Cliente cliente);
    public ArrayList<Cliente> reporteClientes();
    public Persona BuscarCli(String dni); 
}
/*public List<Cliente> obtenerClientes();
	public Cliente obtenerCliente(int id);
	public void actualizarCliente(Cliente cliente);
	public void eliminarCliente(Cliente cliente);*/
