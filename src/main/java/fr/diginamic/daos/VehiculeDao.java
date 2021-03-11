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
public class VehiculeDao {
	private EntityManager em;

	public VehiculeDao(EntityManager em) {
		super();
		this.em = em;
	}

	public VehiculeDao() {
		super();
	}

	public void deleteVehicule(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		EntityTransaction transac = em.getTransaction();

		transac.begin();

		Query queryV = em.createQuery("DELETE FROM Vehicule v WHERE v.id = ?1");
		queryV.setParameter(1, id);

		queryV.executeUpdate();

		transac.commit();
	}
}
