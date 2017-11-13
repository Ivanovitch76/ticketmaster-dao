package be.steformations.it.ticketmaster.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Reservation")
@Table(name="reservations")
@NamedQueries({
	@NamedQuery(name="getReservationById",
				query="select r from Reservation r where r.id = :id")
})
public class Reservation implements java.io.Serializable{

	private static final long serialVersionUID = 4453764045218532864L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;	
	@ManyToOne
	@JoinColumn(name="evenement")
	protected Evenement evenement;
	@ManyToOne
	@JoinColumn(name="client")
	protected Client client;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Evenement getEvenement() {
		return evenement;
	}
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((evenement == null) ? 0 : evenement.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Reservation other = (Reservation) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (evenement == null) {
			if (other.evenement != null)
				return false;
		} else if (!evenement.equals(other.evenement))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", evenement=" + evenement + ", client=" + client + "]";
	}
	
	
	
}
