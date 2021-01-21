/**
 * 
 */
package ec.edu.ups.EvaluacionWSChuchuca.on;

import java.util.Date;
import java.util.Random;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.EvaluacionWSChuchuca.dao.PersonaDAO;
import ec.edu.ups.EvaluacionWSChuchuca.dao.TitulosDAO;
import ec.edu.ups.EvaluacionWSChuchuca.modelo.Persona;
import ec.edu.ups.EvaluacionWSChuchuca.modelo.Titulos;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Stateless
public class GestionTituloOn implements GestionTituloOnLocal {

	@Inject
	private PersonaDAO personaDAO;

	@Inject
	private TitulosDAO titulosDAO;

	public String guardarTitulo(String cedula, String nombreTitulo, String nombreUniversidad) {
		Persona p = personaDAO.read(cedula);
		if(p != null) {
			Titulos t = new Titulos();
			t.setPersona(p);
			t.setNumerotitulo(mostrarAlfa());
			t.setNombre(nombreTitulo);
			t.setUniversidad(nombreUniversidad);
			t.setFechaDeRegistro(new Date());
			try {
				guardarTitulo(t);
				return "Hecho";
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}
		}else {
			return "ERROR";
		}
		return "exito";
	}
	
	public void guardarTitulo(Titulos t) throws Exception {

		try {
			titulosDAO.insert(t);
		} catch (Exception e) {
			throw new Exception(e.toString());
		}
	}
	
	public static String mostrarAlfa(){
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";    //Inicializamos la Variable//
        int numero;
        int forma;
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        numero=(int)(aleatorio.nextDouble() * 99+100);
        cadena=cadena+alfa.charAt(forma)+numero;
        return cadena; 
    }

}
