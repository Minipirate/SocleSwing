/**
 * 
 */
package fr.diginamic.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Ness'ti
 *
 */
@Entity
public class Voiture extends Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOMBRE_PLACES")
	private int nombre_places;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "voiture_id")
	private Type type;

	

	public Voiture(int id, String marque, String modele, String immatriculation, String statut, int kilometrage,
			String commentaire, List<Maintenance> maintenances, List<Reservation> reservations, int id2,
			int nombre_places, Type type) {
		super(id, marque, modele, immatriculation, statut, kilometrage, commentaire, maintenances, reservations);
		id = id2;
		this.nombre_places = nombre_places;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombre_places() {
		return nombre_places;
	}

	public void setNombre_places(int nombre_places) {
		this.nombre_places = nombre_places;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
