package Model;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Restriccion {
    
    private int ID_Restriccion;
    private boolean Estado;
    
    private Incidente incidente;

    public Restriccion(int ID_Restriccion, boolean Estado) {
        this.ID_Restriccion = ID_Restriccion;
        this.Estado = Estado;
    }

    public int getID_Restriccion() {
        return ID_Restriccion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setID_Restriccion(int ID_Restriccion) {
        this.ID_Restriccion = ID_Restriccion;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Incidente getIncidente() {
        return incidente;
    }
            
}
