/**
 * 
 */
package ec.edu.ups.EvaluacionWSChuchuca.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.inject.Inject;
import ec.edu.ups.EvaluacionWSChuchuca.on.GestionTituloOn;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@WebService
public class ServicesSOAP {
	
	@Inject
	private GestionTituloOn on;
	
	@WebMethod
	public String guardar(String cedula, String nombreT, String nombreU){
		try {
			on.guardarTitulo(cedula, nombreT, nombreU);
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "ERROR";
		}
		
	}
	

}
