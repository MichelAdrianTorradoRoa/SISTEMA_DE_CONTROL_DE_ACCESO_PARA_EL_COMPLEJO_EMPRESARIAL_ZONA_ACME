package Controller;

import DAO.PersonaDAO;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alvaro, Conde, Michel
 */
public class RolController {

    public static String generarPassword() {

        String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
        String NUMEROS = "0123456789";
        String ESPECIALES = "!@#$%^&*()_+-=[]{}|;:,.<>?";

        String fusion = MAYUSCULAS + MINUSCULAS + NUMEROS + ESPECIALES;

        SecureRandom random = new SecureRandom();

        int longitudContrasena = 8;

        StringBuilder password = new StringBuilder(longitudContrasena);

        password.append(MAYUSCULAS.charAt(random.nextInt(MAYUSCULAS.length())));
        password.append(MINUSCULAS.charAt(random.nextInt(MINUSCULAS.length())));
        password.append(NUMEROS.charAt(random.nextInt(NUMEROS.length())));
        password.append(ESPECIALES.charAt(random.nextInt(ESPECIALES.length())));

        for (int i = 4; i < longitudContrasena; i++) {
            password.append(fusion.charAt(random.nextInt(fusion.length())));
        }

        String passwordGenerada = password.toString();
        char[] caracteres = passwordGenerada.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            int indiceAleatorio = random.nextInt(caracteres.length);
            char temp = caracteres[i];
            caracteres[i] = caracteres[indiceAleatorio];
            caracteres[indiceAleatorio] = temp;
        }

        return new String(caracteres);

    }

    public String generadorUsuario(String Nombre, String Documento) throws SQLException {

        PersonaDAO persona = null;

        String[] nombreSinEspacios = Nombre.split(" ");

        StringBuilder inicialesNombre = new StringBuilder();

        for (String letra : nombreSinEspacios) {
            if (!letra.isEmpty()) {
                inicialesNombre.append(Character.toLowerCase(letra.charAt(0)));
            }
        }

        String ultimosDigitos = Documento.length() >= 4
                ? Documento.substring(Documento.length() - 4)
                : Documento;

        String baseUsuario = inicialesNombre + ultimosDigitos;

        String usuarioGenerado = baseUsuario;

        int intento = 1;

        while (persona.usuarioExiste(usuarioGenerado)) {

            usuarioGenerado = baseUsuario + intento;
            intento++;

        }

        return usuarioGenerado;
    }

}
