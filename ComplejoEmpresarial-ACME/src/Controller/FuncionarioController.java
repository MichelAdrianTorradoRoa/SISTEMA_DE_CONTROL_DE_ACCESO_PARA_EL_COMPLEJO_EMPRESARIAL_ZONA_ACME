package Controller;

import DAO.EmpresaDAO;
import DAO.PersonaDAO;
import DAO.VehiculoDAO;
import DTO.EmpresaDTO;
import DTO.PersonaDTO;
import DTO.ReporteDTO;
import Model.Persona;
import Model.Vehiculo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class FuncionarioController {

    private PersonaDAO persona;
    private EmpresaDAO empresa;
    private VehiculoDAO vehiculo;
    
    
    public List<Object> mostrarTrabajadores() throws SQLException {

        ReporteDTO reporte = null;
        List<Object> trabajadores = new ArrayList<>();

        List<EmpresaDTO> empresas = new ArrayList<>();

        List<PersonaDTO> personas = persona.filtrarPersonasPorRol("Trabajador");

        if (personas.isEmpty()) {
            return null;
        }

        for (PersonaDTO trabajador : personas) {

            EmpresaDTO empresaa = (EmpresaDTO) empresa.EmpresaPersona(trabajador.getDocumento());

            empresas.add(empresaa);

            reporte = new ReporteDTO(trabajador, empresas);

        }

        return trabajadores;

    }

    public List<Object> mostrarInvitados() throws SQLException {

        ReporteDTO reporte = null;
        List<Object> Invitados = new ArrayList<>();

        List<EmpresaDTO> empresas = new ArrayList<>();

        List<PersonaDTO> personas = persona.filtrarPersonasPorRol("Invitado");

        if (personas.isEmpty()) {
            return null;
        }

        for (PersonaDTO invitado : personas) {

            EmpresaDTO empresaa = (EmpresaDTO) empresa.EmpresaPersona(invitado.getDocumento());

            empresas.add(empresaa);

            List<Date> fechaPermiso = persona.obtenerFechasPermiso(invitado.getDocumento());

            reporte = new ReporteDTO(invitado, empresas, fechaPermiso);

            Invitados.add(reporte);

        }

        return Invitados;

    }

    public PersonaDTO crearTrabajador() {

        PersonaDTO trabajador = null;

        return trabajador;

    }
    
    public Vehiculo crearVehiculo(String matricula, String modelo, String documento, String categoria, String nombreVehiculo){
        
        Persona personaD = persona.obtenerPersonaPorDocumento(documento);
        
        return vehiculo.registrarVehiculo(matricula, modelo, personaD, categoria);
    }

}
