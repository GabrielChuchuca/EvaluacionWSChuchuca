/**
 * 
 */
package ec.edu.ups.EvaluacionWSChuchuca.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.EvaluacionWSChuchuca.modelo.Titulos;

/**
 * @author Gabriel Leonardo Chu
 *
 */

@Stateless
public class TitulosDAO {
	
	@PersistenceContext(name = "EvaluacionWSChuchucaPersistenceUnit") 
	private EntityManager em;
	
	
	public void insert(Titulos t) {
		em.persist(t);
	}
	
	public void update(Titulos t) {
		em.merge(t);
	}
	
	public Titulos read(String numeroTitulo) {
		return em.find(Titulos.class, numeroTitulo);
	}
	
	public void delete(String numeroTitulo) {
		Titulos t = read(numeroTitulo);
		em.remove(t);
	}
	
	public List<Titulos> getTitulos() {
		String jpql = "SELECT t FROM Titulos t ";
		Query q = em.createQuery(jpql, Titulos.class);
		return q.getResultList();
	}  

}
