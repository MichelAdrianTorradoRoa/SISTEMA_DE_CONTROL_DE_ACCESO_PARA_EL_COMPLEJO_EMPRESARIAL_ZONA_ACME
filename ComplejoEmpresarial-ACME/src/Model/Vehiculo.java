package Model;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Vehiculo {

    private int ID_Vehiculo;
    private String Matricula;
    private String Modelo;

    private Persona persona;
    private Categoria_Vehiculo categoria;

    public Vehiculo(int ID_Vehiculo, String Matricula, String Modelo,
            Persona persona, Categoria_Vehiculo categoria_Vehiculo) {
        this.ID_Vehiculo = ID_Vehiculo;
        this.Matricula = Matricula;
        this.Modelo = Modelo;
        this.persona = persona;
        this.categoria = categoria_Vehiculo;
    }

    public int getID_Vehiculo() {
        return ID_Vehiculo;
    }

    public void setID_Vehiculo(int ID_Vehiculo) {
        this.ID_Vehiculo = ID_Vehiculo;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public Categoria_Vehiculo getCategoria() {
        return categoria;
    }

}
