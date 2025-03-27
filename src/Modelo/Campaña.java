package Modelo;
import static Modelo.ConexionBD.conn;
import static Modelo.ConexionBD.stmt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Campaña extends ConexionBD{
    
    private Organizacion organizacion;
    private long ID;
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;

    
    //Constructores
    public Campaña(){
    }
    
    public Campaña(long ID, String nombre, String fecha_inicio, String fecha_fin, Organizacion organizacion) {
        
        this.ID = ID;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.organizacion = organizacion;
        
    }

    //Getters
    public long getID() {
        return ID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }
    
    
   

    //Setters
    public void setID(long ID) {
        this.ID = ID;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }
    
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
    
    
     public boolean guardar(){
        
        try {
            conectarMySQL();
            String sql = "INSERT INTO campaña VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, getID());
            ps.setString(2, getNombre());
            ps.setString(3, getFecha_inicio());
            ps.setString(4, getFecha_fin());
            ps.setLong(5, getOrganizacion().getID());
            ps.executeUpdate();
            ps.close();   
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar campaña: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    /*public boolean actualizar(long id){
        try {
            conectarMySQL();
            String sql = "UPDATE campaña SET = ? WHERE ID_Organizacion = ?";
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
    }*/
    
    public boolean eliminar(long id){
        try {
            conectarMySQL();
            String sql = "DELETE FROM campaña WHERE ID_Campaña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close(); 
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar campaña: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    public Campaña selectOrganizacion(long id){
        Campaña resultado = null;
        try {
            conectarMySQL();
            String sql = "SELECT * FROM campaña WHERE ID_Campaña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = new Campaña();
                resultado.setID(rs.getLong("ID_Campaña"));
                resultado.setNombre(rs.getString("Nombre"));
                resultado.setFecha_inicio(rs.getString("Fecha_Inicio"));
                resultado.setFecha_fin(rs.getString("Fecha_Fin"));
                
                Organizacion organizacion = new Organizacion();
                resultado.setOrganizacion(organizacion.selectOrganizacion(rs.getLong("ID_Organizacion")));
            }
            rs.close();
            ps.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar campaña: "+ e.getMessage());
        }
        finally{
            desconectar();
        }
        return resultado;
    }
    
    public List<Campaña> selectOrganizaciones(){
        List<Campaña> resultados = new ArrayList<>();
        try {
            conectarMySQL();
            String sql = "SELECT * FROM campaña";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Campaña camp = new Campaña();
                camp.setID(rs.getLong("ID_Campaña"));
                camp.setNombre(rs.getString("Nombre"));
                camp.setFecha_inicio(rs.getString("Fecha_Inicio"));
                camp.setFecha_fin(rs.getString("Fecha_Fin"));
                
                Organizacion organizacion = new Organizacion();
                camp.setOrganizacion(organizacion.selectOrganizacion(rs.getLong("ID_Organizacion")));
                
                resultados.add(camp);
            }
            rs.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar campañas: "+ e.getMessage());
        }
        finally{
            desconectar();
        }
        return resultados;
    }
}