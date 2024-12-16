package DAO;

import Controller.ConexionMYSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class GuardaDAO {

    private final Connection conexion;

    public GuardaDAO() {
        this.conexion = ConexionMYSQL.getInstancia().getConexion();
    }

    public boolean validarIngreso(String identificador, String TipoEntrada) throws Exception {

        String persona = "SELECT Estado FROM Persona WHERE Documento = ?";
        String vehiculo = "SELECT * FROM Vehiculo WHERE Matricula = ?";

        switch (TipoEntrada) {
            case "Persona":

                PreparedStatement preparedStatement = conexion.prepareStatement(persona);
                preparedStatement.setString(1, identificador);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    boolean estado = resultSet.getBoolean("Estado");

                    if (estado) {

                        return true;
                    }
                }

                break;

            case "Vehiculo":

                PreparedStatement preparedStatement2 = conexion.prepareStatement(vehiculo);
                preparedStatement2.setString(1, identificador);

                ResultSet resultSet2 = preparedStatement2.executeQuery();

                if (resultSet2.next()) {
                    return true;
                }

                break;
            default:
                throw new Exception();
        }

        return false;

    }

    public boolean validarSalida(String identificador, String tipoSalida) {

        String persona = "SELECT ca.ID_Control_Acceso, ca.Fecha_Salida "
                + "FROM Control_Acceso ca "
                + "JOIN Control_Acceso_Persona cap ON ca.ID_Control_Acceso = "
                + "cap.ID_Control_Acceso JOIN Persona p ON cap.ID_Persona ="
                + " p.ID_Persona WHERE p.Documento = ? AND ca.Fecha_Salida IS NULL";

        String vehiculo = "SELECT ca.ID_Control_Acceso, ca.Fecha_Salida "
                + "FROM Control_Acceso ca "
                + "JOIN Control_Acceso_Vehiculo cav ON ca.ID_Control_Acceso ="
                + " cav.ID_Control_Acceso JOIN Vehiculo v ON cav.ID_Vehiculo"
                + " = v.ID_Vehiculo WHERE v.Matricula = ? AND"
                + " ca.Fecha_Salida IS NULL";

        String actualizarFechaSalida = "UPDATE Control_Acceso SET Fecha_Salida"
                + " = ? WHERE ID_Control_Acceso = ?";

        try {
            switch (tipoSalida) {
                case "Persona": {
                    PreparedStatement preparedStatement = conexion.prepareStatement(persona);
                    preparedStatement.setString(1, identificador);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        int idControlAcceso = resultSet.getInt("ID_Control_Acceso");

                        PreparedStatement actualizar = 
                                conexion.prepareStatement(actualizarFechaSalida);
                        
                        String fechaActual = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                .format(new java.util.Date());
                        actualizar.setString(1, fechaActual);
                        actualizar.setInt(2, idControlAcceso);

                        int rowsUpdated = actualizar.executeUpdate();
                        return rowsUpdated > 0;
                    } else {
                        return false; 
                    }
                }

                case "Vehiculo": {
                    PreparedStatement preparedStatement = conexion.prepareStatement(vehiculo);
                    preparedStatement.setString(1, identificador);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        int idControlAcceso = resultSet.getInt("ID_Control_Acceso");

                        PreparedStatement actualizar = conexion.prepareStatement(actualizarFechaSalida);
                         String fechaActual = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                                .format(new java.util.Date());
                        actualizar.setString(1, fechaActual);
                        actualizar.setInt(2, idControlAcceso);

                        int rowsUpdated = actualizar.executeUpdate();
                        return rowsUpdated > 0; 
                    } else {
                        return false; 
                    }
                }

                default:
                    throw new Exception("Tipo de entrada inválido");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
