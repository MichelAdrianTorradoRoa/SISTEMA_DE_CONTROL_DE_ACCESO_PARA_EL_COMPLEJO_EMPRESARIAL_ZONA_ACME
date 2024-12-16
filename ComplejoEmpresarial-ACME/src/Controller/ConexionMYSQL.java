package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class ConexionMYSQL {

    private static ConexionMYSQL instancia;
    private Connection conexion;
    
    private String host = "localhost";
    private int puerto = 3306;
    private String bd = "acme.sql"; 
    private String user = "root";
    private String password = "1234";

    private ConexionMYSQL() {
        try {
            conexion = DriverManager.getConnection(
                "jdbc:mysql://"+host+":"+puerto+"/"+bd,
                user,
                password
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConexionMYSQL getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMYSQL();
        }
        return instancia;
    }

    
    public Connection getConexion() {
        return conexion;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
}
