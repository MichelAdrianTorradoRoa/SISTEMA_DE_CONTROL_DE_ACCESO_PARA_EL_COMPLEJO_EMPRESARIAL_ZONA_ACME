package Model;

import java.util.Date;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class Permiso {
    
    private int ID_Permiso;
    private Date Fecha;
    
    private Persona persona;

    public Permiso(int ID_Permiso, Date Fecha) {
        this.ID_Permiso = ID_Permiso;
        this.Fecha = Fecha;
    }

    public int getID_Permiso() {
        return ID_Permiso;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setID_Permiso(int ID_Permiso) {
        this.ID_Permiso = ID_Permiso;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Persona getPersona() {
        return persona;
    }
       
}
