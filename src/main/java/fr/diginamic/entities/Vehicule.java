/**
 * 
 */
package fr.diginamic.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */

@Entity
@Table(name = "VEHICULE")
public class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "MARQUE")
	private String marque;

	@Column(name = "MODELE")
	private String modele;

	@Column(name = "IMMATRICULATION")
	private String immatriculation;

	@Column(name = "STATUT")
	private String statut;

	@Column(name = "KILOMETRAGE")
	private int kilometrage;

	@Column(name = "COMMENTAIRE")
	private String commentaire;

	@OneToMany(mappedBy = "vehicule")
	private List<Maintenance> maintenances = new ArrayList<>();

	@OneToMany(mappedBy = "vehicule")
	private List<Reservation> reservations = new ArrayList<>();

	public Vehicule(int id, String marque, String modele, String immatriculation, String statut, int kilometrage,
			String commentaire, List<Maintenance> maintenances, List<Reservation> reservations) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.statut = statut;
		this.kilometrage = kilometrage;
		this.commentaire = commentaire;
		this.maintenances = maintenances;
		this.reservations = reservations;
	}

	public Vehicule() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public List<Maintenance> getMaintenances() {
		return maintenances;
	}

	public void setMaintenances(List<Maintenance> maintenances) {
		this.maintenances = maintenances;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
