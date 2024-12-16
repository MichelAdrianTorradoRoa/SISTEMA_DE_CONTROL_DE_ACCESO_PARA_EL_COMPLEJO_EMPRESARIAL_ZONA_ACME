package Model;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Piso {
    
    private int ID_Piso;
    private int Num_Piso;
    
    private Torre torre;

    public Piso(int ID_Piso, int Num_Piso, Torre torre) {
        this.ID_Piso = ID_Piso;
        this.Num_Piso = Num_Piso;
        this.torre = torre;
    }

    public int getID_Piso() {
        return ID_Piso;
    }

    public int getNum_Piso() {
        return Num_Piso;
    }

    public Torre getTorre() {
        return torre;
    }
    
}
