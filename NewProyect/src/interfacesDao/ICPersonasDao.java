/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDao;

import java.util.ArrayList;
import valores.Cliente;
import valores.Persona;
import valores.Producto;

/**
 *
 * @author INTEL
 */
public interface ICPersonasDao {
    public int  registrarPersona(Cliente p);
     public ArrayList<Persona> reportePersonas();
     public int eliminarRegistroPersona(String sid);
     //public ArrayList<Producto> reporteProductos();
     public int actualizarRegistroPersona(Persona p);
     public Persona reportePersonaUnico(String sid);
     public Persona reportePersonaUnico(String scodigo, String a);
      public Persona LoginReportePersonaUnico(String slogin, String spassword);
       
}
