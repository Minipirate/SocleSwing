/**
 * 
 */
package fr.diginamic.gestionclients;

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
import fr.diginamic.daos.ClientDao;
import fr.diginamic.entities.Adresse;
import fr.diginamic.entities.Client;
import fr.diginamic.entities.Permis;

/**
 * @author Ness'ti
 *
 */

public class MenuGestionClients extends MenuService {

	// ===========> LISTE CLIENTS DANS L'APPLI <======================

	public void traitement() {
		// boutons

		console.clear();

		console.print("<a class='btn-blue' href='affichageListeClient()'><img width=25 src='images/pencil-blue-xs.png'></a>");

		console.print("<a class='btn-green' href='ajouterClient()'><img width=25 src='images/pencil-green-xs.png'></a>");

	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'affichage de
	 * liste de clients
	 * 
	 */

	public void affichageListeClient() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);

		List<Client> clients = query.getResultList();

		console.clear();
		console.print("<h1 class='bg-turquoise'><center>Liste de clients</center></h1>");

		String html = "<table cellspacing=0>" // ouverture d'un tableau
				+ "<tr class='bg-green'><td>&nbsp;</td><td>&nbsp;</td><td>Nom du Client</td><td>Prénom</td><td>Ville</td><td>Email</td><td>Numéro de Téléphone</td></tr>";
		for (Client c : clients) {
			html += "<tr>" + "  <td><a class='btn-blue' href= 'modifierClient(" + c.getId() // récupération ID pour
																							// client courant dans la
																							// boucle
					+ ")'><img width=25 src='images/pencil-blue-xs.png'></a></td>"
					+ "  <td><a class='btn-red' href= 'supprimerClient(" + c.getId()
					+ ")'><img width=25 src='images/trash-red-xs.png'></a></td>" + "  <td width='150px'>" + c.getNom()
					+ "</td>" + "  <td width='150px'>" + c.getPrenom() 
					+ "</td>" + " <td width='150px'>" + c.getAdresse().getVille() 
					+ "</td>" + " <td width='150px'>" + c.getAdresse().getEmail() 
					+ "</td>" + " <td width='150px'>" + c.getAdresse().getNumero_telephone()
					+ "</td>" + "</tr>";
					
		}
		html += "</table>";

		console.print(html);


	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone d'ajout
	 * 
	 */

	public void ajouterClient() {
		console.clear();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		// ================> FORMULAIRE AJOUT CLIENTS <================
		Form formAjoutClient = new Form();

		formAjoutClient.addInput(new TextField("Nom :", "nomClient"));
		formAjoutClient.addInput(new TextField("Prénom :", "prenomClient"));
		formAjoutClient.addInput(new TextField("Numéro Rue :", "numeroRue"));
		formAjoutClient.addInput(new TextField("Libellé rue :", "libelleRue"));
		formAjoutClient.addInput(new TextField("Code Postal :", "codePostal"));
		formAjoutClient.addInput(new TextField("Ville :", "nomVille"));
		formAjoutClient.addInput(new TextField("Numéro de téléphone :", "numeroTelephone"));
		formAjoutClient.addInput(new TextField("Email :", "email"));
		formAjoutClient.addInput(new TextField("Type permis de conduire :", "typeDePermis"));
		formAjoutClient.addInput(new TextField("Numéro de permis de conduire :", "numeroPermis"));
		formAjoutClient.addInput(new DateField("Date d'obtention du permis de conduire :", "dateObtentionPermis"));

		ValidatorClient validatorClients = new ValidatorClient();

		boolean valide = console.input("Demande d'informations", formAjoutClient, validatorClients);

		// Pour récupérer le nom du Clt et le prénom
		String prenom = formAjoutClient.getValue("prenomClient");
		Client client1 = new Client();

		// Pour récupérer l'adresse du Clt
		Adresse adresse1 = new Adresse();

		// Pour récupérer le permis du Clt
		Permis permis1 = new Permis();

		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            Date date;
            
			try {
				
				// Pour stocker le nom du Clt et le prénom
				client1.setNom(formAjoutClient.getValue("nomClient")); // ici on passe en param le retour de l'input
				client1.setPrenom(prenom);

				// Pour stocker l'adresse du Clt
				adresse1.setNumero_rue(Integer.parseInt(formAjoutClient.getValue("numeroRue")));
				adresse1.setLibelle_rue(formAjoutClient.getValue("libelleRue"));
				adresse1.setCode_postal(Integer.parseInt(formAjoutClient.getValue("codePostal")));
				adresse1.setVille(formAjoutClient.getValue("nomVille"));
				adresse1.setNumero_telephone(Integer.parseInt(formAjoutClient.getValue("numeroTelephone")));
				adresse1.setEmail(formAjoutClient.getValue("email"));

				// Pour stocker le permis du Clt
				permis1.setType(formAjoutClient.getValue("typeDePermis"));
				permis1.setNumero(Integer.parseInt(formAjoutClient.getValue("numeroPermis")));
				
				date = formatter.parse(formAjoutClient.getValue("dateObtentionPermis"));
				// Lier permis1 et date
				permis1.setDate_obtention(date);
				
				// Lier client1 et adresse1
				client1.setAdresse(adresse1);

				// Lier client1 et permis1
				client1.setPermis(permis1);
				
				em.persist(client1);

				transac.commit();
				
			} catch (ParseException e) {
				e.printStackTrace();
			}


	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de modification
	 * 
	 * @param id identifiant du client à modifier
	 */

	public void modifierClient(Long id) {
		
		int idInt = id.intValue();


		console.clear();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity-essai-location");
		EntityManager em = factory.createEntityManager();

		// Pour encapsuler les opérations de la bdd dans une transaction
		EntityTransaction transac = em.getTransaction();

		transac.begin();

		Client clientModif = em.find(Client.class, idInt);

		// Formulaire vide
		Form formModifClient = new Form();

		formModifClient.addInput(new TextField("Nouveau Nom :", "nomClient"));
		formModifClient.addInput(new TextField("Nouveau Prénom :", "prenomClient"));
		
		

		ValidatorClient validatorClients = new ValidatorClient();

		boolean valide = console.input("Modification du client " + clientModif.getNom() + " " + clientModif.getPrenom(),
				formModifClient, validatorClients);

		if (valide) {
			String newNomClient = formModifClient.getValue("nomClient");
			String newPrenomClient = formModifClient.getValue("prenomClient");
			clientModif.setNom(newNomClient);
			clientModif.setPrenom(newPrenomClient);
			transac.commit();
		}
	}

	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de suppression
	 * 
	 * @param id identifiant du client à supprimer.
	 */
	
	public void supprimerClient(Long id) {
		
		int idInt = id.intValue();
		
		boolean result = console.confirm("Suppression du client " + idInt,
				"Confirmez-vous la suppression du client n°" + idInt + " ?");
		if (result == true) {
			
			ClientDao clientDaoSupp = new ClientDao();
			clientDaoSupp.deleteClient(idInt);
			
			console.print("La suppression du client n°" +idInt+ " a bien été réalisée");
		
		}
	}
}
