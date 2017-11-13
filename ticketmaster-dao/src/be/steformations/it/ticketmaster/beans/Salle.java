package be.steformations.it.ticketmaster.beans;

import javax.persistence.*;

@Entity(name="Salle")
@Table(name="salles")
@NamedQueries({
	@NamedQuery(name="getSalleById",
				query="select s from Salle s where s.id = :id")
})
public class Salle implements java.io.Serializable{

	private static final long serialVersionUID = 2350502046306352808L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String nom;
	protected Integer capacite;
	
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
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacite == null) ? 0 : capacite.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Salle other = (Salle) obj;
		if (capacite == null) {
			if (other.capacite != null)
				return false;
		} else if (!capacite.equals(other.capacite))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Salle [id=" + id + ", nom=" + nom + ", capacite=" + capacite + "]";
	}
	
	
}
