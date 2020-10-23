package practica01servidor;

import Interfaces.IPersona;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Persona extends UnicastRemoteObject implements IPersona {

    private int id;
    private String nombre;
    private String telefono;
    private String email;

    
    public Persona() throws RemoteException {
       
    }
    public Persona(int id, String nombre, String telefono, String email) throws RemoteException {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public int getId() throws RemoteException{
        return id;
    }

    @Override
    public void setId(int id) throws RemoteException{
        this.id = id;
    }

    @Override
    public String getNombre() throws RemoteException{
        return nombre;
    }

    public void setNombre(String nombre) throws RemoteException{
        this.nombre = nombre;
    }

    @Override
    public String getTelefono() throws RemoteException{
        return telefono;
    }

    public void setTelefono(String telefono) throws RemoteException{
        this.telefono = telefono;
    }

    @Override
    public String getEmail() throws RemoteException{
        return email;
    }

    public void setEmail(String email) throws RemoteException{
        this.email = email;
    }

    public String getString(){
        return String.format("ID: %d, Nombre: %s, Telefono: %s, Email: %s",id, nombre, telefono, email);
    }       

    public static IPersona fromMap ( Map<String, Object> map ) throws RemoteException{
       IPersona persona = new Persona();
       
       if (map.containsKey("IdPersona"))
            persona.setId((Integer)map.get("IdPersona"));
            
        if (map.containsKey("Nombre"))
            persona.setNombre((String)map.get("Nombre"));
            
        if (map.containsKey("Telefono") && map.get("Telefono") != null )
            persona.setTelefono((String)map.get("Telefono"));
            
        if (map.containsKey("Email"))
            persona.setEmail((String)map.get("Email"));
            
        return persona;
    }
    
    
    public static Map<String, Object> toMap( IPersona persona) throws RemoteException{
        
        Map<String, Object> datos = new HashMap<>();
        
        
         if (persona.getId() != 0 ){
             datos.put("IdPersona", persona.getId());
         }
         
         if (persona.getNombre() != null ){
             datos.put("Nombre", persona.getNombre());
         }
         
         if (persona.getTelefono() != null ){
             datos.put("Telefono", persona.getTelefono());
         }
         
         if (persona.getEmail() != null ){
             datos.put("Email", persona.getEmail());
         }
         
         return datos;
    }
}
