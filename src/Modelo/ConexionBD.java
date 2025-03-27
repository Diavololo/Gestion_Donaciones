package Modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    
    public static Connection conn; // Objeto para la conexion
    public static Statement stmt;// Objeto para ejecutar la consulta
    public String bd = "gestion_donaciones_bd";
    public String login = "root";
    public String password = "";
    public String host = "127.0.0.1";
    
    public boolean conectarMySQL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + bd, login, password);
            stmt = conn.createStatement();
            System.out.println("Conectado...");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la BD "+ sqle.getMessage());
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            
            System.out.println("Desconectado.");
            
            return true;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al tratar de desconectarse con la base de datos 'ferreteriabd' "+ sqle.getMessage());
            return false;
        }
    }
}
