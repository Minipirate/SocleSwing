/**
 * 
 */
package fr.diginamic.gestionvehicules;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.composants.MenuService;
import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.ui.TextField;
import fr.diginamic.daos.VehiculeDao;
import fr.diginamic.entities.Vehicule;

/**
 * @author Ness'ti
 *
 */
public class MenuGestionVehicules extends MenuService {

	public void traitement() {
		// boutons

		console.clear();

		console.print(
				"<a class='btn-blue' href='affichageListeVehicules()'><img width=25 src='images/pencil-blue-xs.png'></a>");

		console.print(
				"<a class='btn-green' href='ajouterVehicule()'><img width=25 src='images/pencil-green-xs.png'></a>");

	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'affichage de
	 * liste de véhicules
	 * 
	 */

	public void affichageListeVehicules() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		TypedQuery<Vehicule> queryV = em.createQuery("SELECT v FROM Vehicule v", Vehicule.class);

		List<Vehicule> vehicules = queryV.getResultList();

		console.clear();
		console.print("<h1 class='bg-turquoise'><center>Liste de véhicules</center></h1>");

		String html = "<table cellspacing=0>" // ouverture d'un tableau
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td>"
				+ "<td>Marque</td><td>Modèle</td><td>Immatriculation</td><td>Kilométrage</td><td>Statut</td></tr>";
		
		
		for (Vehicule v : vehicules) {
			html += "<tr>" + "  <td><a class='btn-blue' href= 'modifierVehicule(" + v.getId()
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href= 'supprimerVehicule(" + v.getId()
					
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + "  <td width='150px'>"
					+ v.getMarque() + "</td>" + "  <td width='150px'>" + v.getModele() + "</td>" + " <td width='150px'>"
					+ v.getImmatriculation() + "</td>" + " <td width='150px'>" + v.getKilometrage() + "</td>" + " <td width='150px'>" 
					+ v.getStatut() + "</td>" + "</tr>";

		}
		html += "</table>";

		console.print(html);

	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'ajout de
	 * véhicule
	 * 
	 */

	public void ajouterVehicule() {
		console.clear();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		// ================> FORMULAIRE AJOUT CLIENTS <================
		Form formAjoutVehicule = new Form();

		formAjoutVehicule.addInput(new TextField("Marque :", "marque"));
		formAjoutVehicule.addInput(new TextField("Modèle :", "modele"));
		formAjoutVehicule.addInput(new TextField("Immatriculation :", "immatriculation"));
		formAjoutVehicule.addInput(new TextField("Kilométrage :", "kilometrage"));
		formAjoutVehicule.addInput(new TextField("Statut :", "statut"));

		
	
		ValidatorVehicule validatorVehicules = new ValidatorVehicule();

		boolean valide = console.input("Demande d'informations", formAjoutVehicule, validatorVehicules);

		// Pour récupérer
		String modele = formAjoutVehicule.getValue("modele");
		
		Vehicule vehicule1 = new Vehicule();

		// Pour stocker
		vehicule1.setMarque(formAjoutVehicule.getValue("marque")); // ici on passe en param le retour de l'input
		vehicule1.setModele(formAjoutVehicule.getValue("modele")); 
		vehicule1.setImmatriculation(formAjoutVehicule.getValue("immatriculation"));
		vehicule1.setKilometrage(Integer.parseInt(formAjoutVehicule.getValue("kilometrage")));
		vehicule1.setStatut(formAjoutVehicule.getValue("statut"));


		em.persist(vehicule1);

		transac.commit();
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de modification d'un véhicule
	 */

	public void modifierVehicule(Long id) {
		
		int idInt = id.intValue();


		console.clear();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		Vehicule modifVehicule = em.find(Vehicule.class, idInt);

		// Formulaire vide
		Form formModifVehicule = new Form();

		formModifVehicule.addInput(new TextField("Nouvelle marque :", "marque"));
		formModifVehicule.addInput(new TextField("Nouveau modèle :", "modele"));
		formModifVehicule.addInput(new TextField("Nouvelle immatriculation :", "immatriculation"));
		formModifVehicule.addInput(new TextField("Nouveau kilometrage :", "kilometrage"));
		//formModifVehicule.addInput(new TextField("Nouveau statut :", "statut"));
		

		ValidatorVehicule validatorVehicules = new ValidatorVehicule();

		boolean valide = console.input("Modification du véhicule " + modifVehicule.getMarque() + " " + modifVehicule.getModele() + " " + 
		modifVehicule.getImmatriculation() + " " +modifVehicule.getKilometrage() + " " + modifVehicule.getStatut(),
				formModifVehicule, validatorVehicules);

		if (valide) {
			String newMarqueVehicule = formModifVehicule.getValue("marque");
			String newModeleVehicule = formModifVehicule.getValue("modele");
			String newImmatVehicule = formModifVehicule.getValue("immatriculation");
			String newKilomVehicule = formModifVehicule.getValue("kilometrage");
			String newStatutVehicule = formModifVehicule.getValue("statut");
			
			
			modifVehicule.setMarque(newMarqueVehicule);
			modifVehicule.setModele(newModeleVehicule);
			modifVehicule.setImmatriculation(newImmatVehicule);
			modifVehicule.setKilometrage(idInt);
			modifVehicule.setStatut(newStatutVehicule);
	
			transac.commit();
		}
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de suppression d'un véhicule
	 */
	
	public void supprimerVehicule(Long id) {
		
		int idInt = id.intValue();
		
		boolean result = console.confirm("Suppression du véhicule " + idInt,
				"Confirmez-vous la suppression du véhicule n°" + idInt + " ?");
		if (result == true) {
			
			VehiculeDao vehiculeDaoSupp = new VehiculeDao();
			vehiculeDaoSupp.deleteVehicule(idInt);
			
			console.print("La suppression du véhicule n°" +idInt+ " a bien été réalisée");
		
		}
	}
}