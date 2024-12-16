package DTO;

import Model.Oficina;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class EmpresaDTO {

    private String NIT;
    private String Nombre;
    private String Telefono;
    
     private List<Oficina> oficinas;

    public EmpresaDTO(String NIT, String Nombre, String Telefono) {
        this.NIT = NIT;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public List<Oficina> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public void agregarOficina(Oficina oficina){
        oficinas.add(oficina);
    }

}
