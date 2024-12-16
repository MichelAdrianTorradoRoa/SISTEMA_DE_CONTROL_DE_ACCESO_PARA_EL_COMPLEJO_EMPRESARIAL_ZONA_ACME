/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Controller.ConexionMYSQL;
import Model.Empresa;
import Model.Persona;
import Model.Incidente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class IncidenteDAO {
    
    private Connection conexion;

    public IncidenteDAO() {
        this.conexion = ConexionMYSQL.getInstancia().getConexion();
    }
    
    public Incidente crearIncidente(String asunto, String descripcion, Date fecha, int idCategoria, int idPersona, int idUsuario) {
        Incidente incidenteNuevo = null;

        try {
            String query = "INSERT INTO Incidente (ID_Categoria, ID_Persona, ID_Usuario, Asunto, Descripcion, Fecha) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, idCategoria);   
            preparedStatement.setInt(2, idPersona);     
            preparedStatement.setInt(3, idUsuario);     
            preparedStatement.setString(4, asunto);     
            preparedStatement.setString(5, descripcion);
            preparedStatement.setDate(6, new java.sql.Date(fecha.getTime())); 

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idIncidente = generatedKeys.getInt(1);

                    incidenteNuevo = new Incidente(idIncidente, asunto, descripcion, fecha);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return incidenteNuevo;
    }

    public List<Object[]> obtenerIncidentes() {
        List<Object[]> listaIncidentes = new ArrayList<>();
        
        String query = "SELECT i.Fecha, i.Asunto, c.Tipo, p.Nombre AS Responsable, p.Documento " +
                       "FROM Incidente i " +
                       "JOIN Categoria c ON i.ID_Categoria = c.ID " +
                       "JOIN Persona p ON i.ID_Persona = p.ID";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Date fecha = rs.getDate("Fecha");
                String asunto = rs.getString("Asunto");
                String tipo = rs.getString("Tipo");
                String responsable = rs.getString("Responsable");
                String documento = rs.getString("Documento");

                Object[] fila = {fecha, asunto, tipo, responsable, documento};

                listaIncidentes.add(fila);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listaIncidentes;
    }
}
