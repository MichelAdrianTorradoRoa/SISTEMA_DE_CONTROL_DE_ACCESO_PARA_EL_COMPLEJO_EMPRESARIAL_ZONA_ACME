package Controller;

import DAO.EmpresaDAO;
import DAO.GuardaDAO;
import DAO.PersonaDAO;
import DTO.ControlAccesoDTO;
import DTO.EmpresaDTO;
import DTO.PersonaDTO;
import DTO.ReporteDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class GuardaController {

    private GuardaDAO guarda;
    private PersonaDAO Persona;
    private EmpresaDAO empresa;

    public List<Object> mostrarTodo() {

        ReporteDTO reporte = null;
        List<Object> todo = new ArrayList<>();

        List<EmpresaDTO> empresas = new ArrayList<>();

        try {

            List<PersonaDTO> personal = Persona.obtenerPersonas();

            for (PersonaDTO persona : personal) {

                String Rol = Persona.obtenerRolIngreso(persona.getRol());

                List<ControlAccesoDTO> fechas = Persona.obtenerFechas(persona.getDocumento());

                List<Date> horasEntrada = new ArrayList<>();
                List<Date> horasSalida = new ArrayList<>();

                empresas = empresa.EmpresaPersona(persona.getDocumento());

                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

                for (ControlAccesoDTO registro : fechas) {
                    Date fechaIngreso = registro.getFechaIngreso();
                    Date fechaSalida = registro.getFechaSalida();

                    String horaIngreso = formatoHora.format(fechaIngreso);
                    String horaSalida = formatoHora.format(fechaSalida);

                    Date Ingreso = Persona.convertirHora(horaIngreso);
                    Date Salida = Persona.convertirHora(horaSalida);

                    horasEntrada.add(Ingreso);
                    horasSalida.add(Salida);
                }

                reporte = new ReporteDTO(persona, Rol, empresas, horasEntrada, horasSalida);

                if (reporte == null) {
                    return null;
                }

                todo.add(reporte);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return todo;

    }

    public boolean validarDocumentoIngreso(String Documento) throws Exception {

        return guarda.validarIngreso(Documento, "Persona");

    }

    public boolean validarDocumentoSalida(String Documento) {

        return guarda.validarSalida(Documento, "Persona");

    }

    public boolean validarMatriculaIngreso(String Matricula) throws Exception {

        return guarda.validarIngreso(Matricula, "Vehiculo");

    }

    public boolean validarMatriculaSalida(String Matricula) {

        return guarda.validarSalida(Matricula, "Vehiculo");

    }

}
