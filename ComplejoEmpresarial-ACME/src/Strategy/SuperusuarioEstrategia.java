package Strategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class SuperusuarioEstrategia implements EstrategiaInicioSesion{

    @Override
    public void inicioSesion() {
        JOptionPane.showMessageDialog(null, "Bienvenid@ ");
        /*Aquí pones el JFrame del Superusuario*/
    }
    
}
