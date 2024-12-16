package Model;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Categoria_Vehiculo {
    
    private int ID_Categoria;
    private String Categoria;

    public Categoria_Vehiculo(int ID_Categoria, String Categoria) {
        this.ID_Categoria = ID_Categoria;
        this.Categoria = Categoria;
    }

    public int getID_Categoria() {
        return ID_Categoria;
    }

    public void setID_Categoria(int ID_Categoria) {
        this.ID_Categoria = ID_Categoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
}
