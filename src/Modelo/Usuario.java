package Modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario extends ConexionBD{
    
    private long ID;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String tipo_usuario;

    
    //Constructores
    public Usuario(){
    }
    
    public Usuario(String nombre, String apellido, String correo, String contraseña, String tipo_usuario) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipo_usuario = tipo_usuario;
        this.contraseña = contraseña;
    }

    //Getters
    public long getID() {
        return ID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

   

    //Setters
    public void setID(long ID) {
        this.ID = ID;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
     public boolean guardar(){
        
        try {
            conectarMySQL();
            String sql = "INSERT INTO usuario (`Nombre`, `Apellido`, `Correo`, `Contraseña`) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, getNombre());
            ps.setString(2, getApellido());
            ps.setString(3, getCorreo());
            ps.setString(4, getContraseña());
            ps.executeUpdate();
            ps.close();   
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar usuario: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    public boolean actualizar(String Correo){
        try {
            conectarMySQL();
            String sql = "UPDATE usuario SET Nombre = ?, Apellido = ?, Contraseña = ? WHERE Correo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, getNombre());
            ps.setString(2, getApellido());
            ps.setString(3, getContraseña());
            ps.setString(4, getCorreo());
            ps.executeUpdate();
            ps.close(); 
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: "+ e.getMessage());
            return false;
        }
        finally{
            desconectar();
        }
    }
    
    public Usuario selectUsuario(String correo){
        Usuario resultado = null;
        try {
            conectarMySQL();
            String sql = "SELECT * FROM usuario WHERE Correo = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                resultado = new Usuario();
                resultado.setID(rs.getLong("ID_Usuario"));
                resultado.setNombre(rs.getString("Nombre"));
                resultado.setApellido(rs.getString("Apellido"));
                resultado.setCorreo(rs.getString("Correo"));
                resultado.setContraseña(rs.getString("Contraseña"));
                resultado.setTipo_usuario(rs.getString("Tipo de Usuario"));
            }
            rs.close();
            ps.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuario: "+ e.getMessage());
        }
        finally{
            desconectar();
        }
        return resultado;
    }
    
    public List<Usuario> selectUsuarios(){
        List<Usuario> resultados = new ArrayList<>();
        try {
            conectarMySQL();
                String sql = "SELECT * FROM usuario";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Usuario user = new Usuario();
                user.setID(rs.getLong("ID_Usuario"));
                user.setNombre(rs.getString("Nombre"));
                user.setApellido(rs.getString("Apellido"));
                user.setCorreo(rs.getString("Correo"));
                user.setContraseña(rs.getString("Contraseña"));
                user.setTipo_usuario(rs.getString("Tipo de Usuario"));
                resultados.add(user);
            }
            rs.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuarios: "+ e.getMessage());
        }
        finally{
            desconectar();
        }
        return resultados;
    }
}