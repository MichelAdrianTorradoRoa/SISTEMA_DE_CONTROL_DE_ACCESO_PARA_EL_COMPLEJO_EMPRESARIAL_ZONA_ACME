package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Persona {

    private int ID_Persona;
    private String Documento;
    private String Nombre;
    private String Telefono;
    private boolean Estado;
    private int Rol;

    private List<Oficina> oficinas;

    public Persona(int ID_Persona, String Documento, String Nombre,
            String Telefono, boolean Estado, int Rol) {
        this.ID_Persona = ID_Persona;
        this.Documento = Documento;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.Rol = Rol;
        this.oficinas = new ArrayList<>();
    }

    public int getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(int ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public List<Oficina> getOficinas() {
        return oficinas;
    }

    public void agregarOficina(Oficina oficina) {
        this.oficinas.add(oficina);
    }

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

}
