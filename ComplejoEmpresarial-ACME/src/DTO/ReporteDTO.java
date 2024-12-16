package DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class ReporteDTO {

    private PersonaDTO persona;
    private String Rol;
    private List<EmpresaDTO> empresa;
    private List<Date> Fecha;
    private List<Date> HoraEntrada;
    private List<Date> HoraSalida;
    
    //SuperUsuario && Guarda

    public ReporteDTO(PersonaDTO persona, String Rol, List<EmpresaDTO> empresa,
            List<Date> HoraEntrada, List<Date> HoraSalida) {
        this.persona = persona;
        this.Rol = Rol;
        this.empresa = empresa;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida =  HoraSalida;
    }

    public ReporteDTO(PersonaDTO persona, List<EmpresaDTO> empresa,
            List<Date> HoraEntrada, List<Date> HoraSalida) {
        this.persona = persona;
        this.empresa = empresa;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
    }

    public ReporteDTO(PersonaDTO persona, List<EmpresaDTO> empresa,
            List<Date> Fecha, List<Date> HoraEntrada, List<Date> HoraSalida) {
        this.persona = persona;
        this.empresa = empresa;
        this.Fecha = Fecha;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
    }

    //Supervisor

    public ReporteDTO(PersonaDTO persona, String Rol, List<EmpresaDTO> empresa,
            List<Date> HoraEntrada) {
        this.persona = persona;
        this.Rol = Rol;
        this.empresa = empresa;
        this.HoraEntrada = HoraEntrada;
    }

    public ReporteDTO(PersonaDTO persona, String Rol) {
        this.persona = persona;
        this.Rol = Rol;
    }

    public ReporteDTO(PersonaDTO persona, List<EmpresaDTO> empresa) {
        this.persona = persona;
        this.empresa = empresa;
    }

    //Funcionario

    public ReporteDTO(PersonaDTO persona, List<EmpresaDTO> empresa, List<Date> Fecha) {
        this.persona = persona;
        this.empresa = empresa;
        this.Fecha = Fecha;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public List<EmpresaDTO> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<EmpresaDTO> empresa) {
        this.empresa = empresa;
    }

    public List<Date> getFecha() {
        return Fecha;
    }

    public void setFecha(List<Date> Fecha) {
        this.Fecha = Fecha;
    }

    public List<Date> getHoraEntrada() {
        return HoraEntrada;
    }

    public void setHoraEntrada(List<Date> horasEntrada) {
        this.HoraEntrada = horasEntrada;
    }

    public List<Date> getHorasSalida() {
        return HoraSalida;
    }

    public void setHorasSalida(List<Date> horasSalida) {
        this.HoraSalida = horasSalida;
    }
    
}
