package DAO;

import Controller.ConexionMYSQL;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class SesionDAO {

    private final Connection conexion;

    public SesionDAO() {
        this.conexion = (Connection) ConexionMYSQL.getInstancia().getConexion();
    }

    public UsuarioDTO verificarCredenciales(String username, String password) {
        UsuarioDTO usuario = null;
        
        PersonaDAO persona = null;
        
        try {
            String query = "SELECT Usuario, ID_Persona FROM Usuario WHERE Usuario = ? AND"
                    + " Password = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usuario = new UsuarioDTO(
                        resultSet.getString("Usuario"),
                        persona.obtenerRol(username),
                        resultSet.getInt("ID_Persona")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

}
