package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Oficina {

    private int ID_Oficina;
    private String Nombre;

    private List<Piso> pisos;
    private List<Persona> personas;

    public Oficina(int ID_Oficina, String Nombre) {
        this.ID_Oficina = ID_Oficina;
        this.Nombre = Nombre;
        this.pisos = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public int getID_Oficina() {
        return ID_Oficina;
    }

    public String getNombre() {
        return Nombre;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public void agregarPiso(Piso piso) {
        this.pisos.add(piso);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void agregarPersona(Persona persona) {
        this.personas.add(persona);
    }

}
