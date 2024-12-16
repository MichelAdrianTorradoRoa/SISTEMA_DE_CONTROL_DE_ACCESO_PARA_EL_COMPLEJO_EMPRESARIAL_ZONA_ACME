package Model;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Empresa {
    
    private int ID_Empresa;
    private String NIT;
    private String Nombre;
    private String Telefono;

    public Empresa(int ID_Empresa, String NIT, String Nombre, String Telefono) {
        this.ID_Empresa = ID_Empresa;
        this.NIT = NIT;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
    }

    public int getID_Empresa() {
        return ID_Empresa;
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
    
}
