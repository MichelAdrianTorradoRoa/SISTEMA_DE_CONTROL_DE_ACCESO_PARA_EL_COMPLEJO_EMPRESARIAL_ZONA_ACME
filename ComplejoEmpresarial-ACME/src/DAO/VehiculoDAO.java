/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.ConexionMYSQL;
import Model.Persona;
import Model.Categoria_Vehiculo;
import Model.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class VehiculoDAO {

    private Connection conexion;

    public VehiculoDAO() {
        this.conexion = ConexionMYSQL.getInstancia().getConexion();
    }

    public Vehiculo registrarVehiculo(String matricula, String modelo, Persona persona, String categoria) {
        Vehiculo vehiculoNuevo = null;

        try {
            Categoria_Vehiculo vehiculoCategoria = obtenerCategoria(categoria);
            
            String query = "INSERT INTO Vehiculo (Matricula, ID_Categoria, Modelo, ID_Persona) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, matricula);
            preparedStatement.setInt(2, vehiculoCategoria.getID_Categoria()); 
            preparedStatement.setString(3, modelo);
            preparedStatement.setInt(4, persona.getID_Persona()); 
            
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idVehiculo = generatedKeys.getInt(1);
                    vehiculoNuevo = new Vehiculo(idVehiculo, matricula, modelo, persona, vehiculoCategoria);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }

        return vehiculoNuevo;
    }
    
    public Categoria_Vehiculo obtenerCategoria(String categoria){
        String query = "SELECT * FROM Categoria_Vehiculo WHERE Nombre = ?";
        
        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, categoria);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                Categoria_Vehiculo vehiculo = new Categoria_Vehiculo(
                        resultSet.getInt("ID_Categoria"),
                        resultSet.getString("Nombre"));
                
                return vehiculo;
            } 
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

}

