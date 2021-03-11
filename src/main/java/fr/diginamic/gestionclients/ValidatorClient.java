/**
 * 
 */
package fr.diginamic.gestionclients;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

/**
 * @author Ness'ti
 *
 */
public class ValidatorClient extends FormValidator {

	@Override
	public boolean validate(Form formAjoutClient) {
		String nomClient = formAjoutClient.getValue("nomClient");
		String prenomClient = formAjoutClient.getValue("prenomClient");
		String numeroRueClient = formAjoutClient.getValue("numeroRue");
		String libelleRueClient = formAjoutClient.getValue("libelleRue");
		String codePostalClient = formAjoutClient.getValue("codePostal");
		String villeClient = formAjoutClient.getValue("nomVille");
		String numeroTelephoneClient = formAjoutClient.getValue("numeroTelephone");
		String emailClient = formAjoutClient.getValue("email");
		String typePermisClient = formAjoutClient.getValue("typeDePermis");
		String numeroPermisClient = formAjoutClient.getValue("numeroPermis");
		String dateObtentionPermisClient = formAjoutClient.getValue("dateObtentionPermis");

		if (nomClient.trim().isEmpty()) { // méthode trim() permet de retirer les caractères d'espacement et de voir si
											// autre chose est entré par l'utilisateur
			console.alert("Le nom du client est obligatoire !");
			return false;
		} else if (prenomClient.trim().isEmpty()) {
			console.alert("Le prénom du client est obligatoire !");
			return false;
		} else if (numeroRueClient.trim().isEmpty()) {
			console.alert("Le numéro de rue du client est obligatoire !");
			return false;
		} else if (libelleRueClient.trim().isEmpty()) {
			console.alert("Le libellé de la rue du Client est obligatoire !");
			return false;
		} else if (codePostalClient.trim().isEmpty()) {
			console.alert("Le code postal du Client est obligatoire !");
			return false;
		} else if (villeClient.trim().isEmpty()) {
			console.alert("La ville du Client est obligatoire !");
			return false;
		} else if (numeroTelephoneClient.trim().isEmpty()) {
			console.alert("Le numéro de téléphone du Client est obligatoire !");
			return false;
		} else if (numeroTelephoneClient.length() < 10 || numeroTelephoneClient.length() > 10) { 
			return false;
		} else if (emailClient.trim().isEmpty()) {
			console.alert("L'adresse e-mail du Client est obligatoire !");
			return false;
		} else if (emailClient.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
			return false;
		} else if (typePermisClient.trim().isEmpty()) {
			console.alert("Le type de permis du Client est obligatoire !");
			return false;
		} else if (numeroPermisClient.trim().isEmpty()) {
			console.alert("Le numéro de permis du Client est obligatoire !");
			return false;
		} else if (dateObtentionPermisClient.trim().isEmpty()) {
			console.alert("La date d'obtention de permis du Client est obligatoire !");
			return false;
		}

		return true; // si true alors il retourne la tâche demandée
	}
}
