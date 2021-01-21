/**
 * 
 */
package ec.edu.ups.EvaluacionWSChuchuca.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * @author Gabriel Leonardo Chu
 *
 */

@Entity
public class Titulos implements Serializable{
	//private static  final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "numero_titulo")
	private String numerotitulo;
	private String nombre;
	private String Universidad;
	private Date fechaDeRegistro;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "cedula_persona")
	private Persona persona;

	public String getNumerotitulo() {
		return numerotitulo;
	}

	public void setNumerotitulo(String numerotitulo) {
		this.numerotitulo = numerotitulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUniversidad() {
		return Universidad;
	}

	public void setUniversidad(String universidad) {
		Universidad = universidad;
	}

	public Date getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(Date fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
