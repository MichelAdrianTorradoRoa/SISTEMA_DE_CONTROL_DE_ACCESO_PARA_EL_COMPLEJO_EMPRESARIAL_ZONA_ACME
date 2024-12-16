package Model;

import java.util.Date;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Incidente {
    
    private int ID_Incidente;
    private String Asunto;
    private String Descripcion;
    private Date Fecha;
    
    private Persona persona;

    public Incidente(int ID_Incidente, String Asunto, String Descripcion, Date Fecha) {
        this.ID_Incidente = ID_Incidente;
        this.Asunto = Asunto;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
    }

    public int getID_Incidente() {
        return ID_Incidente;
    }

    public void setID_Incidente(int ID_Incidente) {
        this.ID_Incidente = ID_Incidente;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
        public Persona getPersona() {
        return persona;
    }
    
}
