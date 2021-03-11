/**
 * 
 */
package fr.diginamic.gestionvehicules;

import fr.diginamic.composants.ui.Form;
import fr.diginamic.composants.validator.FormValidator;

/**
 * @author Ness'ti
 *
 */
public class ValidatorVehicule extends FormValidator {

	@Override
	public boolean validate(Form formAjoutVehicule) {

		String marque = formAjoutVehicule.getValue("marque");
		String modele = formAjoutVehicule.getValue("modele");
		String immatriculation = formAjoutVehicule.getValue("immatriculation");
		String kilometrage = formAjoutVehicule.getValue("kilometrage");
		String statut = formAjoutVehicule.getValue("statut");

		if (marque.trim().isEmpty()) {

			console.alert("La marque du véhicule est obligatoire !");
			return false;
		} else if (modele.trim().isEmpty()) {
			console.alert("Le modèle du véhicule est obligatoire !");
			return false;
		} else if (immatriculation.trim().isEmpty()) {
			console.alert("L'immatriculation du véhicule est obligatoire !");
			return false;
		} else if (kilometrage.trim().isEmpty()) {
			console.alert("Le kilométrage du véhicule est obligatoire !");
			return false;
		} else if (statut.trim().isEmpty()) {
			console.alert("Le statut du véhicule est obligatoire !");
			return false;
		} else if (statut != "disponible") {
			console.alert("Un nouveau véhicule doit être au statut disponible");
			return false;
		} else if (immatriculation.matches("^[A-Z]{2}[-][0-9]{3}[-][A-Z]{2}$")) {
			console.alert("L'immatriculation doit être au format XX-XXX-XX");
			return false;
		}

		return true;

	}
}
