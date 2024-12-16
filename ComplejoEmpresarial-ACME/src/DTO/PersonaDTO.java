package DTO;

import Model.Vehiculo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class PersonaDTO {

    private String Documento;
    private String Nombre;
    private String Telefono;
    private boolean Estado;
    private int Rol;

    private List<Vehiculo> vehiculos;

    public PersonaDTO(String Documento, String Nombre, String Telefono, boolean Estado, int Rol) {
        this.Documento = Documento;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.Rol = Rol;
        vehiculos = new ArrayList<>();
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

    public int getRol() {
        return Rol;
    }

    public void setRol(int Rol) {
        this.Rol = Rol;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

}
