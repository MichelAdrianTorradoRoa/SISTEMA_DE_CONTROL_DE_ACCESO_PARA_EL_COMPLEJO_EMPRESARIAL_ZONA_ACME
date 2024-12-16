package DTO;

import java.util.Date;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class ControlAccesoDTO {
    
     private Date fechaIngreso; 
    private Date fechaSalida;

    public ControlAccesoDTO(Date fechaIngreso, Date fechaSalida) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public ControlAccesoDTO(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
}
