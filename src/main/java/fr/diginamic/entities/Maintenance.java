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
import javax.persistence.Table;

/**
 * @author Ness'ti
 *
 */
@Entity
@Table(name = "MAINTENANCE")
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DEBUT_MAINTENANCE")
	private Date debut_maintenance;

	@Column(name = "FIN_MAINTENANCE")
	private Date fin_maintenance;

	@Column(name = "COUT_MAINTENANCE")
	private int cout_maintenance;

	public Maintenance(int id, Date debut_maintenance, Date fin_maintenance, int cout_maintenance) {

	}

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "maintenance_id")
	private Vehicule vehicule;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDebut_maintenance() {
		return debut_maintenance;
	}

	public void setDebut_maintenance(Date debut_maintenance) {
		this.debut_maintenance = debut_maintenance;
	}

	public Date getFin_maintenance() {
		return fin_maintenance;
	}

	public void setFin_maintenance(Date fin_maintenance) {
		this.fin_maintenance = fin_maintenance;
	}

	public int getCout_maintenance() {
		return cout_maintenance;
	}

	public void setCout_maintenance(int cout_maintenance) {
		this.cout_maintenance = cout_maintenance;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

}
