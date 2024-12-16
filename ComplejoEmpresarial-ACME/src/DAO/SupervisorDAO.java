package DAO;

import Controller.ConexionMYSQL;
import DTO.UsuarioDTO;
import Model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class SupervisorDAO implements UsuarioDAO {

    private final Connection conexion;

    private PersonaDAO rolPersona;

    public SupervisorDAO() {
        this.conexion = (Connection) ConexionMYSQL.getInstancia().getConexion();
    }

    @Override
    public UsuarioDTO CrearPersonal(String usuario, String password,
            Persona persona, String Rol) {
        UsuarioDTO usuarioNuevo = null;

        try {

            String query = "INSERT INTO Usuario (Usuario, Password, ID_Persona)"
                    + " VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, persona.getID_Persona());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                if (!crearUsuario(usuario, password, Rol)) {
                    return null;
                }

                if (asignarRol(usuario, Rol)) {

                    usuarioNuevo = new UsuarioDTO(
                            usuario,
                            Rol,
                            persona.getID_Persona()
                    );

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarioNuevo;

    }

    @Override
    public UsuarioDTO obtenerPersonal(String usuario) {

        UsuarioDTO usuarioEncontrado = null;

        try {

            String query = "SELECT Usuario, ID_Persona FROM Usuario"
                    + " WHERE Usuario = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, usuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String Rol = rolPersona.obtenerRol(usuario);

                if (Rol != null && Rol.equals("Guarda") || Rol.equals("Funcionario")) {

                    usuarioEncontrado = new UsuarioDTO(
                            resultSet.getString("Usuario"),
                            Rol,
                            resultSet.getInt("ID_Persona")
                    );

                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return usuarioEncontrado;
    }

    @Override
    public boolean crearUsuario(String usuario, String password, String Rol) {

        String queryCrearUsuario = "CREATE USER ? IDENTIFIED BY ?";

        try (PreparedStatement CreaccionUsuario = conexion.prepareStatement(queryCrearUsuario)) {

            CreaccionUsuario.setString(1, usuario);
            CreaccionUsuario.setString(2, password);

            CreaccionUsuario.executeUpdate();

            return asignarRol(usuario, Rol);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean asignarRol(String username, String rol) {

        String queryAsignarRol = "GRANT ? TO ?";

        try (PreparedStatement pstmtRol = conexion.prepareStatement(queryAsignarRol)) {

            pstmtRol.setString(1, rol);
            pstmtRol.setString(2, username);

            pstmtRol.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public List<UsuarioDTO> listarPersonal() {

        String query = "SELECT Usuario, Password FROM Usuario";

        List<UsuarioDTO> supervisores = new ArrayList<>();
        UsuarioDTO supervisor = null;

        try (PreparedStatement stmt = conexion.prepareStatement(query); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {

                supervisor = new UsuarioDTO(
                        resultSet.getString("Usuario"),
                        rolPersona.obtenerRol(resultSet.getString("Usuario")),
                        resultSet.getInt("ID_Persona")
                );
                supervisores.add(supervisor);

            }

        } catch (Exception e) {
        }

        return supervisores;
    }
    
    public List<UsuarioDTO> listaPersonalSubGrupos(String Rol) throws NullPointerException{
        
        List<UsuarioDTO> personal = listarPersonal();
        
        return (List<UsuarioDTO>) personal.stream()
                .filter(Guarda -> Guarda.getRol().equals(Rol))
                .collect(Collectors.toList());
        
    }

}
