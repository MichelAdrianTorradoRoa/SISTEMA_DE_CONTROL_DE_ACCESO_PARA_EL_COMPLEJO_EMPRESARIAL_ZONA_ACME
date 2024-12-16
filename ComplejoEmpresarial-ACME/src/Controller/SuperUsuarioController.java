package Controller;

import DAO.EmpresaDAO;
import DAO.PersonaDAO;
import DAO.SuperUsuarioDAO;
import DTO.ConfiguracionDTO;
import DTO.ControlAccesoDTO;
import DTO.EmpresaDTO;
import DTO.PersonaDTO;
import DTO.ReporteDTO;
import DTO.UsuarioDTO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class SuperUsuarioController {

    private PersonaDAO persona;
    private SuperUsuarioDAO superUser;
    private EmpresaDAO empresa;

    public List<PersonaDTO> mostrarSupervisores() {

        List<PersonaDTO> supervisores = new ArrayList<>();

        try {

            List<UsuarioDTO> usuarios = superUser.listarPersonal();

            if (usuarios != null) {

                for (UsuarioDTO usuario : usuarios) {

                    PersonaDTO personal = persona.obtenerPersonaPorID(usuario.getIDPersona());

                    supervisores.add(personal);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return supervisores;
    }

    public List<Object> ingresoSalidaPorPersona() throws SQLException {

        ReporteDTO reporte = null;
        List<Object> ingresos = new ArrayList<>();

        List<PersonaDTO> listaPersonas = persona.obtenerPersonas();

        for (PersonaDTO personaa : listaPersonas) {

            String Rol = persona.obtenerRolIngreso(personaa.getRol());

            if (Rol == null) {
                return null;
            }

            List<EmpresaDTO> empresas = empresa.EmpresaPersona(personaa.getDocumento());

            List<ControlAccesoDTO> fechas = persona.obtenerFechas(personaa.getDocumento());

            List<Date> horasEntrada = new ArrayList<>();
            List<Date> horasSalida = new ArrayList<>();

            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            
            for (ControlAccesoDTO registro : fechas) {
                Date fechaIngreso = registro.getFechaIngreso();
                Date fechaSalida = registro.getFechaSalida();

                String horaIngreso = formatoHora.format(fechaIngreso);
                String horaSalida = formatoHora.format(fechaSalida);
                
                Date Ingreso = persona.convertirHora(horaIngreso);
                Date Salida = persona.convertirHora(horaSalida);

                horasEntrada.add(Ingreso);
                horasSalida.add(Salida);
            }

            reporte = new ReporteDTO(personaa, Rol, empresas, horasEntrada, horasSalida);

            if (reporte == null) {
                return null;
            }

            ingresos.add(reporte);

        }

        return ingresos;

    }

    //Cambiar Retorno
    public void ingresoSalidaPorVehiculo() {

        //Falta a YO
    }

    public List<Object> reportePorTrabajador() throws SQLException {

        ReporteDTO reporte = null;
        List<Object> Trabajador = new ArrayList<>();

        List<PersonaDTO> listaPersonas = persona.filtrarPersonasPorRol("Trabajador");

        for (PersonaDTO personaa : listaPersonas) {

            String Rol = persona.obtenerRolIngreso(personaa.getRol());

            if (Rol == null) {
                return null;
            }

            List<EmpresaDTO> empresas = empresa.EmpresaPersona(personaa.getDocumento());

            List<ControlAccesoDTO> fechas = persona.obtenerFechas(personaa.getDocumento());

            List<Date> horasEntrada = new ArrayList<>();
            List<Date> horasSalida = new ArrayList<>();

            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            
            for (ControlAccesoDTO registro : fechas) {
                Date fechaIngreso = registro.getFechaIngreso();
                Date fechaSalida = registro.getFechaSalida();

                String horaIngreso = formatoHora.format(fechaIngreso);
                String horaSalida = formatoHora.format(fechaSalida);
                
                Date Ingreso = persona.convertirHora(horaIngreso);
                Date Salida = persona.convertirHora(horaSalida);

                horasEntrada.add(Ingreso);
                horasSalida.add(Salida);
            }

            reporte = new ReporteDTO(personaa, empresas, horasEntrada, horasSalida);

            if (reporte == null) {
                return null;
            }

            Trabajador.add(reporte);

        }

        return Trabajador;

    }

    public List<Object> reportePorInvitado() throws SQLException {

        ReporteDTO reporte = null;
        List<Object> Invitado = new ArrayList<>();

        List<PersonaDTO> listaPersonas = persona.filtrarPersonasPorRol("Invitado");

        for (PersonaDTO personaa : listaPersonas) {

            String Rol = persona.obtenerRolIngreso(personaa.getRol());

            if (Rol == null) {
                return null;
            }

            List<EmpresaDTO> empresas = empresa.EmpresaPersona(personaa.getDocumento());

            List<ControlAccesoDTO> fechas = persona.obtenerFechas(personaa.getDocumento());
            
            List<Date> fechaPermiso =  persona.obtenerFechasPermiso(personaa.getDocumento());

            List<Date> horasEntrada = new ArrayList<>();
            List<Date> horasSalida = new ArrayList<>();
            
            
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            
            for (ControlAccesoDTO registro : fechas) {
                Date fechaIngreso = registro.getFechaIngreso();
                Date fechaSalida = registro.getFechaSalida();

                String horaIngreso = formatoHora.format(fechaIngreso);
                String horaSalida = formatoHora.format(fechaSalida);
                
                Date Ingreso = persona.convertirHora(horaIngreso);
                Date Salida = persona.convertirHora(horaSalida);

                horasEntrada.add(Ingreso);
                horasSalida.add(Salida);
            }

            reporte = new ReporteDTO(personaa, empresas, fechaPermiso, horasEntrada, horasSalida);

            if (reporte == null) {
                return null;
            }

            Invitado.add(reporte);

        }

        return Invitado;

    }

    public ConfiguracionDTO configuracionIP(String IP) {

        ConfiguracionDTO configura = null;

        return configura;

    }

}
