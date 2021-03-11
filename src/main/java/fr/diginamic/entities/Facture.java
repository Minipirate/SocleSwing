/**
 * 
 */
package fr.diginamic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "FACTURE")
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUMERO_DE_FACTURE")
	private int numero_de_facture;

	@Column(name = "TYPE_DE_REGLEMENT")
	private String type_de_reglement;

	@OneToOne
	@JoinColumn(name = "facture_id")
	private Reservation reservation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_de_facture() {
		return numero_de_facture;
	}

	public void setNumero_de_facture(int numero_de_facture) {
		this.numero_de_facture = numero_de_facture;
	}

	public String getType_de_reglement() {
		return type_de_reglement;
	}

	public void setType_de_reglement(String type_de_reglement) {
		this.type_de_reglement = type_de_reglement;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
