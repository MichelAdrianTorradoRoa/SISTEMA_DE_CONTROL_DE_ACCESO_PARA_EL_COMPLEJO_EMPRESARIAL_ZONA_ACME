package Controller;

import Proxy.ProxySesion;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class SesionController {
    
    public void Login(String username, String password){
        
        ProxySesion proxyLogin = new ProxySesion();
        
        if(proxyLogin.validarSesion(username, password)){
            proxyLogin.ingresarSesion();
        } else {
            JOptionPane.showMessageDialog(null,"Credenciales incorrectas.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
}
