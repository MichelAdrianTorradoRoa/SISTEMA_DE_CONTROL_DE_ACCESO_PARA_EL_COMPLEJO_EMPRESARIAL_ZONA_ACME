package Proxy;

import Strategy.EstrategiaInicioSesion;
import Strategy.FuncionarioEstrategia;
import Strategy.GuardiaEstrategia;
import Strategy.SuperusuarioEstrategia;
import Strategy.SupervisorEstrategia;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class InicioSesion implements Sesion{
    
    private EstrategiaInicioSesion estrategia;
    
    public void setEstrategia(String tipoUsuario){
        switch (tipoUsuario) {
            case "Superusuario":
                this.estrategia = new SuperusuarioEstrategia();
                break;
                
            case "Supervisor":
                this.estrategia = new SupervisorEstrategia();
                break;
                
            case "Guardia":
                this.estrategia = new GuardiaEstrategia();
                break;
                
            case "Funcionario":
                this.estrategia = new FuncionarioEstrategia();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }
    }

    @Override
    public void ingresarSesion() {
        if(estrategia == null) {
            throw new IllegalStateException("No se ha establecido un buen inicio de sesión");
        }
        this.estrategia.inicioSesion();
    }
    
}
