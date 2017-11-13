package be.steformations.it.ticketmaster.beans;

import java.util.Date;

import javax.persistence.*;

@Entity(name="Evenement")
@Table(name="evenements")
@NamedQueries({
	@NamedQuery(name="getEvenementById",
				query="select e from Evenement e where e.id = :id"),
})
public class Evenement implements java.io.Serializable{

	private static final long serialVersionUID = 8047846264529086061L;
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String nom;
	@Basic
	@Temporal(TemporalType.DATE)
	protected Date jour;
	@Basic
	@Temporal(TemporalType.TIME)
	protected Date heure;
	@ManyToOne
	@JoinColumn(name="salle")
	protected Salle salle;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getJour() {
		return jour;
	}
	public void setJour(Date jour) {
		this.jour = jour;
	}
	public Date getHeure() {
		return heure;
	}
	public void setHeure(Date heure) {
		this.heure = heure;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heure == null) ? 0 : heure.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jour == null) ? 0 : jour.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evenement other = (Evenement) obj;
		if (heure == null) {
			if (other.heure != null)
				return false;
		} else if (!heure.equals(other.heure))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jour == null) {
			if (other.jour != null)
				return false;
		} else if (!jour.equals(other.jour))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nom=" + nom + ", jour=" + jour + ", heure=" + heure + "]";
	}

	
	
	
}
