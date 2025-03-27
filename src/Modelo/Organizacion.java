package Modelo;
import static Modelo.ConexionBD.conn;
import static Modelo.ConexionBD.stmt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Organizacion extends ConexionBD{
    
    private long ID;
    private String nombre;
    private String contacto;

    
    //Constructores
    public Organizacion(){
    }
    
    public Organizacion(long ID, String nombre, String contacto) {
        
        this.ID = ID;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    //Getters
    public long getID() {
        return ID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getContacto() {
        return contacto;
    }

   

    //Setters
    public void setID(long ID) {
        this.ID = ID;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
     public boolean guardar(){
        
        try {
            conectarMySQL();
            String sql = "INSERT INTO organizacion VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, getID());
            ps.setString(2, getNombre());
            ps.setString(3, getContacto());
            ps.executeUpdate();
            ps.close();   
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar organizacion: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    public boolean actualizar(long id){
        try {
            conectarMySQL();
            String sql = "UPDATE organizacion SET Nombre = ? WHERE ID_Organizacion = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, getID());
            ps.setString(2, getNombre());
            ps.setString(3, getContacto());
            ps.executeUpdate();
            ps.close(); 
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar organizacion: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    public boolean eliminar(long id){
        try {
            conectarMySQL();
            String sql = "DELETE FROM organizacion WHERE ID_Organizacion = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close(); 
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar organizacion: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    public Organizacion selectOrganizacion(long id){
        Organizacion resultado = null;
        try {
            conectarMySQL();
            String sql = "SELECT * FROM organizacion WHERE ID_Organizacion = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = new Organizacion();
                resultado.setID(rs.getLong("ID_Organizacion"));
                resultado.setNombre(rs.getString("Nombre"));
                resultado.setContacto(rs.getString("Contacto"));
            }
            rs.close();
            ps.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar organizacion: "+ e.getMessage());
        }
        finally{
            desconectar();
        }
        return resultado;
    }
    
    public List<Organizacion> selectOrganizaciones(){
        List<Organizacion> resultados = new ArrayList<>();
        try {
            conectarMySQL();
            String sql = "SELECT * FROM organizacion";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Organizacion org = new Organizacion();
                org.setID(rs.getLong("ID_Organizacion"));
                org.setNombre(rs.getString("Nombre"));
                org.setContacto(rs.getString("Contacto"));
                resultados.add(org);
            }
            rs.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar contacto: "+ e.getMessage());
        }
        finally{
            desconectar();
        }
        return resultados;
    }
}