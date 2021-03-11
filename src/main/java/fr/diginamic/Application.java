package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.composants.AbstractApplication;
import fr.diginamic.gestionReservations.MenuGestionReservationsEnCours;
import fr.diginamic.gestionReservations.MenuGestionReservationsTerminees;
import fr.diginamic.gestionclients.MenuGestionClients;
import fr.diginamic.gestionmaintenance.MenuGestionMaintenance;
import fr.diginamic.gestionvehicules.MenuGestionVehicules;
import fr.diginamic.services.exemples.AideService;
import fr.diginamic.services.exemples.Exemple1Service;
import fr.diginamic.services.exemples.Exemple2Service;
import fr.diginamic.services.exemples.Exemple3Service;
import fr.diginamic.services.exemples.Exemple4Service;
import fr.diginamic.services.exemples.Exemple5Service;
import fr.diginamic.services.exemples.Exemple6Service;

/**
 * Fenêtre principale qui porte les principaux composants graphiques de
 * l'application:<br>
 * - les boutons du menu,<br>
 * - le panneau d'affichage des résultats<br>
 * 
 * @author RichardBONNAMY
 *
 */
public class Application extends AbstractApplication {

	/** serialVersionUID */
	private static final long serialVersionUID = 6755835482616236832L;
	
	/** Constructeur
	 * @param title titre
	 */
	public Application(String title) {
		super(title);
	}

	/**
	 * Code principal
	 * 
	 */
	
	public void main() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();
		
		addMenu(1, "File");
		addMenu(2, "Gestion clients");
		addMenu(3, "Gestion des véhicules");
		addMenu(4, "Gestion des réservations en cours");
		addMenu(5, "Gestion des réservations terminées");
		addMenu(6, "Gestion de la maintenance");
		/*addMenu(7, "Exemples");*/
		
		addMenuOption(1, "Aide", new AideService());
		
		addMenuOption(2, "Liste des clients", new MenuGestionClients());
		
		addMenuOption(3, "Liste des véhicules", new MenuGestionVehicules());
		
		addMenuOption(4, "Liste des réservations en cours", new MenuGestionReservationsEnCours());
		
		addMenuOption(5, "Liste des réservations terminées", new MenuGestionReservationsTerminees());
		
		addMenuOption(6, "Liste des véhicules en maintenance", new MenuGestionMaintenance());
		
		
		/*addMenuOption(7, "Exemple 1 - Titres", new Exemple1Service());
		addMenuOption(7, "Exemple 2 - Textes de couleur", new Exemple2Service());
		addMenuOption(7, "Exemple 3 - Table", new Exemple3Service());
		addMenuOption(7, "Exemple 4 - Table avec liens vers méthodes", new Exemple4Service());
		addMenuOption(7, "Exemple 5 - Table dynamique", new Exemple5Service());
		addMenuOption(7, "Exemple 6 - Formulaire", new Exemple6Service());*/
	}
}