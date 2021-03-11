/**
 * 
 */
package fr.diginamic.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.daos.ClientDao;

/**
 * @author Ness'ti
 *
 */
public class IntegrationLocation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		// ------------------> CLIENTS <------------------

		ClientDao clientA = new ClientDao(em);

		//clientA.ajouterClient("Simba");

		// méthode persist pour envoyer vers la bdd
		em.persist(clientA);

		transac.commit();

	}

}
