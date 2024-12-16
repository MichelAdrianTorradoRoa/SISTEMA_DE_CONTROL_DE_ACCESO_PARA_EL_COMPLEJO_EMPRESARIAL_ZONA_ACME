package Proxy;

import DAO.SesionDAO;
import DTO.UsuarioDTO;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class ProxySesion implements Sesion {

    private InicioSesion inicioSesion;
    private SesionDAO sesionDAO;
    private UsuarioDTO usuario;

    public ProxySesion() {
        this.inicioSesion = new InicioSesion();
        this.sesionDAO = new SesionDAO();
    }

    @Override
    public void ingresarSesion() {

        if (usuario == null) {
            throw new IllegalStateException("No se ha validado el usuario. "
                    + "Intente iniciar sesión nuevamente.");
        }

        inicioSesion.setEstrategia(usuario.getRol());
        inicioSesion.ingresarSesion();

    }

    public boolean validarSesion(String username, String password) {
        usuario = sesionDAO.verificarCredenciales(username, password);
        return usuario != null;
    }

}
