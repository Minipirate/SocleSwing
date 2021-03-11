/**
 * 
 */
package fr.diginamic.gestionReservations;

import fr.diginamic.composants.MenuService;

/**
 * @author Ness'ti
 *
 */
public class MenuGestionReservationsTerminees extends MenuService {

	@Override
	public void traitement() {
		//boutons
		console.clear();
		console.print("<a class='btn-blue' href='affichageListeReservTerminees()'><img width=25 src='images/pencil-blue-xs.png'></a>");
	}

	
	
}
