/**
 * 
 */
package fr.diginamic.gestionmaintenance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.DateField;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.entities.Adresse;
import fr.diginamic.entities.Client;
import fr.diginamic.entities.Maintenance;
import fr.diginamic.entities.Permis;
import fr.diginamic.gestionclients.ValidatorClient;

/**
 * @author Ness'ti
 *
 */
public class MenuGestionMaintenance extends MenuService {

	@Override
	public void traitement() {
		// boutons

		console.clear();

		console.print(
				"<a class='btn-blue' href='affichageVehiculesMaintenance()'><img width=25 src='images/pencil-blue-xs.png'></a>");

	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'affichage de
	 * liste des véhicules en maintenance 
	 * 
	 */
	
	public void affichageListeMaintenance() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();
		
		TypedQuery<Maintenance> queryM = em.createQuery("SELECT m FROM Maintenance", Maintenance.class);
		
		List<Maintenance> vehiculesMaintenance = queryM.getResultList();
		
		console.clear();
		console.print("<h1 class='bg-turquoise'><center>Liste des véhicules en maintenance</center></h1>");

		String html = "<table cellspacing=0>" // ouverture d'un tableau
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td>"
				+ "<td>Coût maintenance</td><td>Début maintenance</td><td>Fin maintenance</td></tr>";
		
		/*for (Maintenance m : vehiculesMaintenance) {
			html += "<tr>" + "  <td><a class='btn-blue' href= 'modifierVehicule(" + v.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href= 'supprimerVehicule(" + v.getId()
					
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + "  <td width='150px'>"
					+ v.getMarque() + "</td>" + "  <td width='150px'>" + v.getModele() + "</td>" + " <td width='150px'>"
					+ v.getImmatriculation() + "</td>" + " <td width='150px'>" + v.getKilometrage() + "</td>" + " <td width='150px'>" 
					+ v.getStatut() + "</td>" + "</tr>";
		}*/
		html += "</table>";

		console.print(html);
	}
	
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'ajout d'un véhicule en maintenance
	 * 
	 */

	public void ajouterVehiculeMaintenance() {
		console.clear();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		// ================> FORMULAIRE AJOUT D'UN VEHICULE EN MAINTENANCE <================
		Form formAjoutVehiculeMaintenance = new Form();

		formAjoutVehiculeMaintenance.addInput(new TextField("Date de début :", "dateDebutMaintenance"));
		

		ValidatorMaintenance validatorMaintenance = new ValidatorMaintenance();

		boolean valide = console.input("Demande d'ajout d'un véhicule en maintenance", formAjoutVehiculeMaintenance, validatorMaintenance);

		
	}

}
