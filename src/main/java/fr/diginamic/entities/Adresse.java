/**
 * 
 */
package fr.diginamic.entities;

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
@Table(name = "ADRESSE")
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NUMERO_RUE")
	private int numero_rue;

	@Column(name = "LIBELLE_RUE")
	private String libelle_rue;

	@Column(name = "CODE_POSTAL")
	private int code_postal;

	@Column(name = "VILLE")
	private String ville;

	@Column(name = "NUMERO_TELEPHONE")
	private int numero_telephone;

	@Column(name = "EMAIL")
	private String email;


	public Adresse() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_rue() {
		return numero_rue;
	}

	public void setNumero_rue(int numero_rue) {
		this.numero_rue = numero_rue;
	}

	public String getLibelle_rue() {
		return libelle_rue;
	}

	public void setLibelle_rue(String libelle_rue) {
		this.libelle_rue = libelle_rue;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNumero_telephone() {
		return numero_telephone;
	}

	public void setNumero_telephone(int numero_telephone) {
		this.numero_telephone = numero_telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
