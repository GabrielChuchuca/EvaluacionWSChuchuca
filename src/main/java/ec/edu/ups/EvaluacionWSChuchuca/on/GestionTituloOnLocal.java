/**
 * 
 */
package ec.edu.ups.EvaluacionWSChuchuca.on;

import javax.ejb.Local;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Local
public interface GestionTituloOnLocal {
	
	public String guardarTitulo(String cedula, String nombreTitulo, String nombreUniversidad);

}
