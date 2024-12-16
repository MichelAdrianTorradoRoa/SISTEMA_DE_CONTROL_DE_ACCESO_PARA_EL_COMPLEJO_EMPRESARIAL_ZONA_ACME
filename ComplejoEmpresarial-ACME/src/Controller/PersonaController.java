package Controller;

import DAO.PersonaDAO;
import DTO.PersonaDTO;
import Model.Persona;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class PersonaController {

    private PersonaDAO persona;

    public Persona CrearInvitado(String Documento, String Nombre,
            String Telefono, boolean Estado, int Rol) {

        return persona.crearPersona(Documento, Nombre, Telefono, Estado, Rol);

    }
    
    public PersonaDTO editarInvitado(String Documento){
        
        PersonaDTO invitado = null;
        
        String query = "";
        
        return invitado;
        
    }

}
