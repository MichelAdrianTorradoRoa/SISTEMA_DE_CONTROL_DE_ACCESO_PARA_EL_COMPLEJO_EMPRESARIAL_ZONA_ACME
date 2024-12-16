package DTO;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class VehiculoDTO {

    private String Matricula;
    private String Modelo;
    private String Categoria;
    private PersonaDTO persona;

    public VehiculoDTO(String Matricula, String Modelo, String Categoria, PersonaDTO persona) {
        this.Matricula = Matricula;
        this.Modelo = Modelo;
        this.Categoria = Categoria;
        this.persona = persona;
    }

    public String getMatricula() {
        return Matricula;
    }

    public String getModelo() {
        return Modelo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

}
