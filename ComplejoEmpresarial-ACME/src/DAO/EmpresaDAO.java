package DAO;

import Controller.ConexionMYSQL;
import DTO.EmpresaDTO;
import DTO.PersonaDTO;
import Model.Empresa;
import Model.Oficina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class EmpresaDAO {

    private final Connection conexion;

    private PersonaDAO persona;

    public EmpresaDAO() {
        this.conexion = (Connection) ConexionMYSQL.getInstancia().getConexion();
    }

    public EmpresaDTO EmpresaConOficina(int idEmpresa, int idOficina) throws SQLException {
        String sql = "SELECT e.NIT, e.Nombre AS EmpresaNombre, e.Telefono, "
                + "o.ID_Oficina, o.Nombre AS OficinaNombre "
                + "FROM Empresa e "
                + "JOIN Oficina o ON o.ID_Empresa = e.ID_Empresa "
                + "WHERE e.ID_Empresa = ? AND o.ID_Oficina = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa);
            stmt.setInt(2, idOficina);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    EmpresaDTO empresa = new EmpresaDTO(
                            rs.getString("NIT"),
                            rs.getString("EmpresaNombre"),
                            rs.getString("Telefono")
                    );

                    Oficina oficina = new Oficina(
                            rs.getInt("ID_Oficina"),
                            rs.getString("OficinaNombre")
                    );

                    empresa.agregarOficina(oficina);

                    return empresa;
                }
            }
        }
        return null;
    }

    public List<Oficina> listarOficinasPorEmpresa(int idEmpresa) throws SQLException {
        String sql = "SELECT o.ID_Oficina, o.Nombre "
                + "FROM Oficina o "
                + "WHERE o.ID_Empresa = ?";

        List<Oficina> oficinas = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idEmpresa);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Oficina oficina = new Oficina(
                            rs.getInt("ID_Oficina"),
                            rs.getString("Nombre")
                    );
                    oficinas.add(oficina);
                }
            }
        }
        return oficinas;
    }

    public List<Empresa> listarEmpresas() throws SQLException {
        String sql = "SELECT ID_Empresa, NIT, Nombre, Telefono FROM Empresa";

        List<Empresa> empresas = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Empresa empresa = new Empresa(
                        rs.getInt("ID_Empresa"),
                        rs.getString("NIT"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono")
                );
                empresas.add(empresa);
            }
        }
        return empresas;
    }

    public EmpresaDTO EmpresaConOficinas(int idEmpresa) throws SQLException {
        String sqlEmpresa = "SELECT ID_Empresa, NIT, Nombre, Telefono FROM"
                + " Empresa WHERE ID_Empresa = ?";
        String sqlOficinas = "SELECT ID_Oficina, Nombre FROM Oficina WHERE"
                + " ID_Empresa = ?";

        EmpresaDTO empresa = null;

        try (PreparedStatement stmtEmpresa = conexion.prepareStatement(sqlEmpresa)) {
            stmtEmpresa.setInt(1, idEmpresa);

            try (ResultSet rsEmpresa = stmtEmpresa.executeQuery()) {
                if (rsEmpresa.next()) {
                    empresa = new EmpresaDTO(
                            rsEmpresa.getString("NIT"),
                            rsEmpresa.getString("Nombre"),
                            rsEmpresa.getString("Telefono")
                    );
                }
            }
        }

        if (empresa != null) {
            List<Oficina> oficinas = new ArrayList<>();
            try (PreparedStatement stmtOficinas = conexion.prepareStatement(sqlOficinas)) {
                stmtOficinas.setInt(1, idEmpresa);

                try (ResultSet rsOficinas = stmtOficinas.executeQuery()) {
                    while (rsOficinas.next()) {
                        Oficina oficina = new Oficina(
                                rsOficinas.getInt("ID_Oficina"),
                                rsOficinas.getString("Nombre")
                        );
                        oficinas.add(oficina);
                    }
                }
            }
            empresa.setOficinas(oficinas);
        }
        return empresa;
    }

    public List<EmpresaDTO> EmpresaPersona(String Documento) throws SQLException {

        List<EmpresaDTO> empresas = new ArrayList<>();

        String query = "SELECT e.ID_Empresa FROM Empresa e JOIN Oficina"
                + " o ON e.ID_Empresa = o.ID_Empresa JOIN Persona_Oficina"
                + " po ON o.ID_Oficina = po.ID_Oficina JOIN Persona p ON"
                + " po.ID_Persona = p.ID_Persona WHERE p.Documento = ?";

        try {

            PreparedStatement preparedStatement = conexion.prepareStatement(query);

            preparedStatement.setString(1, Documento);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                EmpresaDTO empresa = EmpresaConOficinas(resultSet.getInt("ID_Empresa"));

                empresas.add(empresa);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return empresas;

    }

    public boolean agregarPersonaEmpresa(String Documento, String NombreEmpresa, String NombreOficina) {


        try {
            PersonaDTO personaDTO = null;
            String queryPersona = "SELECT * FROM Persona WHERE Documento = ?";
            PreparedStatement preparedStatementPersona = conexion.prepareStatement(queryPersona);
            preparedStatementPersona.setString(1, Documento);

            ResultSet resultSetPersona = preparedStatementPersona.executeQuery();
            
            int idPersona = -1;
            
            if (resultSetPersona.next()) {
                
                idPersona = resultSetPersona.getInt("ID_Persona");
                
                personaDTO = new PersonaDTO(
                        resultSetPersona.getString("Documento"),
                        resultSetPersona.getString("Nombre"),
                        resultSetPersona.getString("Telefono"),
                        resultSetPersona.getBoolean("Estado"),
                        resultSetPersona.getInt("ID_Rol")
                );
            } else {
                throw new Exception("La persona no existe.");
            }

            String queryEmpresa = "SELECT ID_Empresa FROM Empresa WHERE Nombre = ?";
            PreparedStatement preparedStatementEmpresa = conexion.prepareStatement(queryEmpresa);
            preparedStatementEmpresa.setString(1, NombreEmpresa);

            ResultSet resultSetEmpresa = preparedStatementEmpresa.executeQuery();
            int idEmpresa = -1;

            if (resultSetEmpresa.next()) {
                idEmpresa = resultSetEmpresa.getInt("ID_Empresa");
            } else {
                throw new Exception("La empresa no existe.");
            }

            String queryOficina = "SELECT ID_Oficina FROM Oficina WHERE"
                    + " Nombre = ? AND ID_Empresa = ?";
            PreparedStatement preparedStatementOficina = conexion.prepareStatement(queryOficina);
            preparedStatementOficina.setString(1, NombreOficina);
            preparedStatementOficina.setInt(2, idEmpresa);

            ResultSet resultSetOficina = preparedStatementOficina.executeQuery();
            int idOficina = -1;

            if (resultSetOficina.next()) {
                idOficina = resultSetOficina.getInt("ID_Oficina");
            } else {
                throw new Exception("La oficina no existe.");
            }

            
            String insertarRelacion = "INSERT INTO Persona_Oficina"
                    + "(ID_Oficina, ID_Persona) VALUES (?, ?)";
            PreparedStatement preparedStatementInsert = conexion.prepareStatement(insertarRelacion);
            preparedStatementInsert.setInt(1, idEmpresa);
            preparedStatementInsert.setInt(3, idOficina);

            int rowsAffected = preparedStatementInsert.executeUpdate();

            if (rowsAffected > 0) {
               
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
