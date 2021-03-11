/**
 * 
 */
package fr.diginamic.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ness'ti
 *
 */
@Entity
public class Camion extends Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "VOLUME")
	private double volume;

	public Camion(int id, String marque, String modele, String immatriculation, String statut, int kilometrage,
			String commentaire, List<Maintenance> maintenances, List<Reservation> reservations, int id2,
			double volume) {
		super(id, marque, modele, immatriculation, statut, kilometrage, commentaire, maintenances, reservations);
		id = id2;
		this.volume = volume;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}
