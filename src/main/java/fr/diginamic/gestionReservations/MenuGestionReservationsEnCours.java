/**
 * 
 */
package fr.diginamic.gestionReservations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.entities.Reservation;
/**
 * @author Ness'ti
 *
 */
public class MenuGestionReservationsEnCours extends MenuService {

	@Override
	public void traitement() {
		// boutons

		console.clear();
		console.print(
				"<a class='btn-blue' href='affichageListeReservEnCours()'><img width=25 src='images/pencil-blue-xs.png'></a>");

	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'affichage de
	 * liste de réservations en cours
	 * 
	 */

	public void affichageListeReservEnCours() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		TypedQuery<Reservation> queryR = em.createQuery("SELECT r FROM Reservation r", Reservation.class);

		List<Reservation> reservations = queryR.getResultList();

		console.clear();
		console.print("<h1 class='bg-turquoise'><center>Liste des réservations en cours</center></h1>");

		String html = "<table cellspacing=0>" // ouverture d'un tableau
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td>"
				+ "<td>Date de début</td><td>Date de Fin</td><td>Kilométrage début</td><td>Kilométrage fin</td></tr>";

		for (Reservation r : reservations) {

			html += "<tr>" + "  <td><a class='btn-blue' href= 'modifierReservation(" + r.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href= 'supprimerReservation(" + r.getId()

					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + "  <td width='150px'>"
					+ r.getDate_de_debut() + "</td>" + "  <td width='150px'>" + r.getDate_de_fin() + "</td>"
					+ " <td width='150px'>" + r.getKilometrage_debut() + "</td>" + " <td width='150px'>"
					+ r.getKilometrage_fin() + "</td>" + "</tr>";

		}
		html += "</table>";

		console.print(html);

	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de réservation
	 * 
	 */

	public void reservation() {
		console.clear();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		// ================> FORMULAIRE AJOUT RESERVATIONS <================
		Form formReservation = new Form();

		formReservation.addInput(new TextField("Date de début :", "dateDebutResa"));
		formReservation.addInput(new TextField("Date de fin :", "dateFinResa"));

		boolean valide = console.input("Demande d'informations", formReservation, null);

	}

}
