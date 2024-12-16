package Strategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class FuncionarioEstrategia implements EstrategiaInicioSesion{

    @Override
    public void inicioSesion() {
        JOptionPane.showMessageDialog(null, "Bienvenid@ ");
        /*Aquí pones el JFrame del Funcionario*/
    }
    
}
