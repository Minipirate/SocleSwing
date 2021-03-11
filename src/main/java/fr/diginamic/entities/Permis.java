/**
 * 
 */
package fr.diginamic.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "PERMIS")
public class Permis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "NUMERO")
	private int numero;

	@Column(name = "DATE_OBTENTION")
	private Date date_obtention;

	public Permis() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDate_obtention() {
		return date_obtention;
	}

	public void setDate_obtention(Date date_obtention) {
		this.date_obtention = date_obtention;
	}

}
