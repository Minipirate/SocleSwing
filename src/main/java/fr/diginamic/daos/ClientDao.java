/**
 * 
 */
package fr.diginamic.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author Ness'ti
 *
 */
public class ClientDao {

	private EntityManager em;

	public ClientDao(EntityManager em) {
		super();
		this.em = em;
	}

	public ClientDao() {
		super();
	}

	public void deleteClient(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		EntityTransaction transac = em.getTransaction();

		transac.begin();

		Query queryC = em.createQuery("DELETE FROM Client c WHERE c.id = ?1");
		queryC.setParameter(1, id);

		queryC.executeUpdate();

		transac.commit();
	}
}
