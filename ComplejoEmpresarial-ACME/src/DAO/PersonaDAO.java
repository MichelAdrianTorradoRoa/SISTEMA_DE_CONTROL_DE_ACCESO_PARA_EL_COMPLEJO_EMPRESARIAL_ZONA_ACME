package DAO;

import Controller.ConexionMYSQL;
import DTO.ControlAccesoDTO;
import DTO.PersonaDTO;
import Model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class PersonaDAO {

    private final Connection conexion;

    public PersonaDAO() {
        this.conexion = ConexionMYSQL.getInstancia().getConexion();
    }

    public Persona crearPersona(String Documento, String Nombre,
            String Telefono, boolean Estado, int Rol) {

        Persona personaNueva = null;

        try {

            String query = "INSERT INTO Persona(Documento, Nombre, Telefono,"
                    + " Estado, ID_ROL) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.prepareStatement(
                    query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, Documento);
            preparedStatement.setString(2, Nombre);
            preparedStatement.setString(3, Telefono);
            preparedStatement.setBoolean(4, Estado);
            preparedStatement.setInt(5, Rol);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {

                    int idPersona = generatedKeys.getInt(1);

                    personaNueva = new Persona(
                            idPersona,
                            Documento,
                            Nombre,
                            Telefono,
                            Estado,
                            Rol
                    );
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personaNueva;

    }

    public PersonaDTO obtenerPersonaPorID(int id) {

        PersonaDTO persona = null;

        try {
            String query = "SELECT Documento, Nombre, Telefono, Estado, ID_Rol"
                    + " FROM Persona WHERE ID_Persona = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                persona = new PersonaDTO(
                        resultSet.getString("Documento"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Telefono"),
                        resultSet.getBoolean("Estado"),
                        resultSet.getInt("ID_ROl")
                );

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return persona;

    }

    public Persona obtenerPersonaPorDocumento(String Documento) {

        Persona persona = null;

        try {
            String query = "SELECT ID_Persona, Documento, Nombre, Telefono, Estado, ID_Rol"
                    + " FROM Persona WHERE Documento = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, Documento);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                persona = new Persona(
                        resultSet.getInt("ID_Persona"),
                        resultSet.getString("Documento"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Telefono"),
                        resultSet.getBoolean("Estado"),
                        resultSet.getInt("ID_ROl")
                );

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return persona;

    }

    public List<PersonaDTO> obtenerPersonas() {

        List<PersonaDTO> personas = new ArrayList<>();

        String query = "SELECT ID_Persona, Documento, Nombre, Telefono, Estado, Rol"
                + " FROM Persona";

        try (PreparedStatement stmt = conexion.prepareStatement(query); ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {

                PersonaDTO persona = new PersonaDTO(
                        resultSet.getString("DOcumento"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Telefono"),
                        resultSet.getBoolean("Estado"),
                        resultSet.getInt("Rol")
                );

                personas.add(persona);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personas;

    }

    public boolean usuarioExiste(String usuario) throws SQLException {
        String query = "SELECT COUNT(*) FROM Usuarios WHERE Usuario = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean validarUsuario(String usuario) {
        String query = "SELECT COUNT(*) AS total FROM mysql.user WHERE user = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int total = resultSet.getInt("total");
                    return total > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String obtenerRol(String usuario) {

        if (!validarUsuario(usuario)) {
            return "Usuario no existe";
        }

        String queryHosts = "SELECT Host FROM mysql.user WHERE User = ?";
        StringBuilder roles = new StringBuilder();

        try (PreparedStatement stmtHosts = conexion.prepareStatement(queryHosts)) {
            stmtHosts.setString(1, usuario);

            try (ResultSet resultSetHosts = stmtHosts.executeQuery()) {
                while (resultSetHosts.next()) {
                    String host = resultSetHosts.getString("Host");
                    String queryGrants = "SHOW GRANTS FOR '" + usuario + "'@'" + host + "'";

                    try (PreparedStatement stmtGrants
                            = conexion.prepareStatement(queryGrants); ResultSet resultSetGrants = stmtGrants.executeQuery()) {

                        while (resultSetGrants.next()) {
                            roles.append(resultSetGrants.getString(1)).append("\n");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roles.length() > 0 ? roles.toString() : "No tiene roles definidos";
    }

    public String obtenerRolIngreso(int Rol) {

        String query = "SELECT Nombre FROM Rol WHERE ID_ROL = ?";

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setInt(1, Rol);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getString("Nombre");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<ControlAccesoDTO> obtenerFechas(String documento) throws SQLException {

        List<ControlAccesoDTO> fechas = new ArrayList<>();

        String query = "SELECT ca.Fecha_Ingreso, ca.Fecha_Salida "
                + "FROM Control_Acceso ca "
                + "JOIN Control_Acceso_Persona cap ON ca.ID_Control_Acceso"
                + " = cap.ID_Control_Acceso "
                + "JOIN Persona p ON cap.ID_Persona = p.ID_Persona "
                + "WHERE p.Documento = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {

            preparedStatement.setString(1, documento);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    ControlAccesoDTO controlAcceso = new ControlAccesoDTO(
                            resultSet.getTimestamp("Fecha_Ingreso"),
                            resultSet.getTimestamp("Fecha_Salida")
                    );

                    fechas.add(controlAcceso);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return fechas;
    }

    public List<ControlAccesoDTO> obtenerHoraEntrada(String documento) throws SQLException {

        List<ControlAccesoDTO> horaIngreso = new ArrayList<>();

        String query = "SELECT ca.Fecha_Ingreso "
                + "FROM Control_Acceso ca "
                + "JOIN Control_Acceso_Persona cap ON ca.ID_Control_Acceso"
                + " = cap.ID_Control_Acceso "
                + "JOIN Persona p ON cap.ID_Persona = p.ID_Persona "
                + "WHERE p.Documento = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {

            preparedStatement.setString(1, documento);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    ControlAccesoDTO controlAcceso = new ControlAccesoDTO(
                            resultSet.getTimestamp("Fecha_Ingreso")
                    );

                    horaIngreso.add(controlAcceso);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return horaIngreso;

    }

    public Date convertirHora(String fecha) {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        try {
            return formatoHora.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PersonaDTO> filtrarPersonasPorRol(String nombreRol) {

        if (!nombreRol.equalsIgnoreCase("Trabajador")
                && !nombreRol.equalsIgnoreCase("Invitado")) {
            throw new IllegalArgumentException("El rol debe ser 'Trabajador'"
                    + " o 'Invitado'.");
        }

        List<PersonaDTO> todasLasPersonas = obtenerPersonas();

        List<PersonaDTO> personasFiltradas = new ArrayList<>();

        for (PersonaDTO persona : todasLasPersonas) {

            String nombreRolPersona = obtenerRolIngreso(persona.getRol());
            if (nombreRolPersona.equalsIgnoreCase(nombreRol)) {
                personasFiltradas.add(persona);
            }

        }

        return personasFiltradas;

    }

    public List<Date> obtenerFechasPermiso(String Documento) {

        List<Date> fechas = new ArrayList<>();

        String query = "SELECT p.Fecha FROM Permiso p JOIN Persona pe ON"
                + " p.ID_Persona = pe.ID_Persona WHERE p.Documento = ?";

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, Documento);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                fechas.add(resultSet.getDate("Fecha"));

            }

            return fechas;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public PersonaDTO obtenerPersonaporUsuario(String usuario) {

        PersonaDTO persona = null;

        String query = "SELECT p.Nombre, p.Documento, p.Telefono, p.Estado, r.Nombre AS ROL "
                + "FROM Persona p "
                + "INNER JOIN Usuario u ON p.ID_Persona = u.ID_Persona "
                + "INNER JOIN Rol r ON p.ID_Rol = r.ID_Rol "
                + "WHERE u.Usuario = ?";

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                if(!obtenerRol(usuario).equals(resultSet.getString("ROL"))){
                    return null;
                }

                persona = new PersonaDTO(
                        resultSet.getString("Documento"),
                        resultSet.getString("Nombre"),
                        resultSet.getString("Telefono"),
                        resultSet.getBoolean("Estado"),
                        resultSet.getInt("ID_Rol")
                );

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return persona;

    }

}
