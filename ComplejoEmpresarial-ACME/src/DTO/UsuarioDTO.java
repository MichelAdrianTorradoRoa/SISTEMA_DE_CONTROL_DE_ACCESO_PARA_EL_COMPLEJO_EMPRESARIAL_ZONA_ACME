package DTO;

import Model.Incidente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class UsuarioDTO {

    private String Usuario;
    private String Rol;
    private int ID_persona;

    private List<Incidente> incidentes = new ArrayList<>();

    public UsuarioDTO(String Usuario, String Rol, int persona) {
        this.Usuario = Usuario;
        this.Rol = Rol;
        this.ID_persona = persona;
        this.incidentes = new ArrayList<>();
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public int getIDPersona() {
        return ID_persona;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void agregarIncidente(Incidente incidente) {
        this.incidentes.add(incidente);
    }

}
