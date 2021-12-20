package interfacesDao;

        
import valores.Producto;
import java.util.ArrayList;


public interface IProductosDao {
    public int  registrarProducto(Producto prod);
    public int  actualizaProducto(Producto prod);
    public int eliminarRegistroProductos(String id);
    public ArrayList<Producto> reporteProductos();
    public Producto reporteProductosnom(String nom);  
    public int actuStock(String id, String Cantidad);
}
