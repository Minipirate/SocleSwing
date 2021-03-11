/**
 * 
 */
package fr.diginamic.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DATE_DE_DEBUT")
	private Date date_de_debut;

	@Column(name = "DATE_DE_FIN")
	private Date date_de_fin;

	@Column(name = "KILOMETRAGE_DEBUT")
	private int kilometrage_debut;

	@Column(name = "KILOMETRAGE_FIN")
	private int kilometrage_fin;

	public Reservation(int id, Date date_de_debut, Date date_de_fin, int kilometrage_debut, int kilometrage_fin,
			Vehicule vehicule, Client client, Facture facture) {

	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "vehicule_id")
	private Vehicule vehicule;

	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToOne
	@JoinColumn(name = "facture_id")
	private Facture facture;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_de_debut() {
		return date_de_debut;
	}

	public void setDate_de_debut(Date date_de_debut) {
		this.date_de_debut = date_de_debut;
	}

	public Date getDate_de_fin() {
		return date_de_fin;
	}

	public void setDate_de_fin(Date date_de_fin) {
		this.date_de_fin = date_de_fin;
	}

	public int getKilometrage_debut() {
		return kilometrage_debut;
	}

	public void setKilometrage_debut(int kilometrage_debut) {
		this.kilometrage_debut = kilometrage_debut;
	}

	public int getKilometrage_fin() {
		return kilometrage_fin;
	}

	public void setKilometrage_fin(int kilometrage_fin) {
		this.kilometrage_fin = kilometrage_fin;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

}
