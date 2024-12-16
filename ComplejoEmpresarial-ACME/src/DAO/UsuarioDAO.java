package DAO;

import DTO.UsuarioDTO;
import Model.Persona;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public interface UsuarioDAO {
    UsuarioDTO CrearPersonal(String usuario, String password, Persona persona, String Rol);
    UsuarioDTO obtenerPersonal(String usuario);
    List<UsuarioDTO> listarPersonal();
    boolean crearUsuario(String usuario, String password, String Rol);
    boolean asignarRol(String username, String rol);
}
