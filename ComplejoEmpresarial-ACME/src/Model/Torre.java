package Model;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Torre {
    
    private int ID_Torre;
    private String Nombre;

    public Torre(int ID_Torre, String Nombre) {
        this.ID_Torre = ID_Torre;
        this.Nombre = Nombre;
    }

    public int getID_Torre() {
        return ID_Torre;
    }

    public String getNombre() {
        return Nombre;
    }
    
}
