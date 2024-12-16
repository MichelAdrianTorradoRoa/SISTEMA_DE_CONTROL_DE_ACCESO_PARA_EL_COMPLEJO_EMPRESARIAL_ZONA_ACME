package Model;


/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Usuario {
    
    private int ID_Usuario;
    private String Usuario;
    private String Password;

    public Usuario(int ID_Usuario, String usuario, String password) {
        this.ID_Usuario = ID_Usuario;
        this.Usuario = usuario;
        this.Password = password;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getPassword() {
        return Password;
    }
    
}
