package Controller;

import DAO.EmpresaDAO;
import DAO.IncidenteDAO;
import DAO.PersonaDAO;
import DAO.SupervisorDAO;
import DTO.ControlAccesoDTO;
import DTO.EmpresaDTO;
import DTO.PersonaDTO;
import DTO.ReporteDTO;
import DTO.UsuarioDTO;
import Model.Incidente;
import Model.Persona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class SupervisorController {

    private SupervisorDAO supervisor;

    private PersonaDAO usuarioS;

    private EmpresaDAO empresaS;
    
    private IncidenteDAO incidente;

    public List<Object> mostrarEntradas() {

        ReporteDTO reporte = null;

        List<EmpresaDTO> empresas = new ArrayList<>();

        List<PersonaDTO> funcionarios = new ArrayList<>();

        List<Object> Personal = new ArrayList<>();

        try {

            List<UsuarioDTO> usuarios = supervisor.listarPersonal();

            if (usuarios != null) {

                for (UsuarioDTO usuario : usuarios) {

                    PersonaDTO personal = usuarioS.obtenerPersonaPorID(usuario.getIDPersona());

                    funcionarios.add(personal);

                    String Rol = usuarioS.obtenerRolIngreso(personal.getRol());

                    List<ControlAccesoDTO> fechas = usuarioS.obtenerFechas(personal.getDocumento());

                    List<Date> horasEntrada = new ArrayList<>();

                    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

                    for (ControlAccesoDTO registro : fechas) {
                        Date fechaIngreso = registro.getFechaIngreso();

                        String horaIngreso = formatoHora.format(fechaIngreso);

                        Date Ingreso = usuarioS.convertirHora(horaIngreso);

                        horasEntrada.add(Ingreso);
                    }

                    for (PersonaDTO persona : funcionarios) {

                        empresas = empresaS.EmpresaPersona(persona.getDocumento());

                    }

                    reporte = new ReporteDTO(personal, Rol, empresas, horasEntrada);

                    if (reporte == null) {
                        return null;
                    }

                    Personal.add(reporte);

                }

                return Personal;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public UsuarioDTO crearGuarda(String usuario, String password,
            Persona persona, String Rol) {

        return supervisor.CrearPersonal(usuario, password, persona, Rol);

    }

    public List<PersonaDTO> mostrarGuardas() {

        List<UsuarioDTO> guardas = supervisor.listaPersonalSubGrupos("Guarda");
        List<PersonaDTO> personas = new ArrayList<>();

        if (guardas.isEmpty()) {
            return null;
        }

        for (UsuarioDTO guarda : guardas) {

            PersonaDTO persona = usuarioS.obtenerPersonaporUsuario(guarda.getUsuario());

            personas.add(persona);

        }

        return personas;

    }

    public boolean crearFuncionario(String usuario, String password,
            Persona persona, String Rol, String empresa, String Oficina) {

        UsuarioDTO funcionario = supervisor.CrearPersonal(usuario, password, persona, Rol);

        if (funcionario == null) {
            return false;
        }
        
        return empresaS.agregarPersonaEmpresa(Oficina, empresa, Oficina);

    }

    public List<PersonaDTO> mostrarFuncionario() {

        List<UsuarioDTO> funcionarios = supervisor.listaPersonalSubGrupos("Funcionario");
        List<PersonaDTO> personas = new ArrayList<>();

        if (funcionarios.isEmpty()) {
            return null;
        }

        for (UsuarioDTO funcionario : funcionarios) {

            PersonaDTO persona = usuarioS.obtenerPersonaporUsuario(funcionario.getUsuario());

            personas.add(persona);

        }

        return personas;

    }

    public Incidente CrearIncidente(String asunto, String descripcion, Date fecha, int idCategoria, int idPersona, int idUsuario) {
        
        Incidente incidente = new IncidenteDAO().crearIncidente(asunto, descripcion, fecha, idCategoria, idPersona, idUsuario);
        
        return incidente;
        
    }

    public List<Object[]> mostrarIncidentes() {
        
        return incidente.obtenerIncidentes();
        
    }

}
