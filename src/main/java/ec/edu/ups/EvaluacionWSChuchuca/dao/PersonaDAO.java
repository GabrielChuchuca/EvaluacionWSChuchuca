/**
 * 
 */
package ec.edu.ups.EvaluacionWSChuchuca.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EvaluacionWSChuchuca.modelo.Persona;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Stateless
public class PersonaDAO {
	
	@PersistenceContext(name = "EvaluacionWSChuchucaPersistenceUnit") 
	private EntityManager em;
	
	public void insert(Persona p) {
		em.persist(p);
	}
	
	public void update(Persona p) {
		em.merge(p);
	}
	
	public Persona read(String cedulaPersona) {
		return em.find(Persona.class, cedulaPersona);
	} 
	
	public void delete(String cedulaPersona) {
		Persona p = read(cedulaPersona);
		em.remove(p);
	}
	
	public List<Persona> getPersona() {
		String jpql = "SELECT p FROM Persona p ";
		Query q = em.createQuery(jpql, Persona.class);
		return q.getResultList();
	} 
	
}
