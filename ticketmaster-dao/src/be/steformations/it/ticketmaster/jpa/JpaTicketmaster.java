package be.steformations.it.ticketmaster.jpa;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.NoResultException;

import be.steformations.it.ticketmaster.beans.Client;
import be.steformations.it.ticketmaster.beans.Evenement;
import be.steformations.it.ticketmaster.beans.Reservation;
import be.steformations.it.ticketmaster.beans.Salle;
import be.steformations.it.ticketmaster.dao.TicketmasterDao;

public class JpaTicketmaster implements TicketmasterDao{

	protected javax.persistence.EntityManager em;
	
	public JpaTicketmaster(javax.persistence.EntityManager em) {
		super();
		System.out.println("JpaTicketmaster.JpaTicketmaster()");
		this.em = em;
	}

	@Override
	public Client getClientById(int id) {
		System.out.println("JpaTicketmaster.getClientById()");
		Client client = null;
		if (id > 0){
			client = this.em.find(Client.class, id);
		}
		return client;
	}

	@Override
	public Evenement getEvenementById(int id) {
		System.out.println("JpaTicketmaster.getEvenementById()");
		Evenement evenement = null;
		if (id > 0){
			evenement = this.em.find(Evenement.class, id);
		}
		return evenement;
	}

	@Override
	public Evenement createEvenement(String nom, Date jour, Date heure, Salle salle) {
		System.out.println("JpaTicketmaster.createEvenement()");
		System.out.println("event nom = " + nom);
		System.out.println("event jour = " + jour);
		System.out.println("event heure = " + heure);
		System.out.println("event salle = " + salle);
		Evenement evenement = null;
		if (nom != null && jour != null && heure != null && salle.getId() != null){
			System.out.println("JpaTicketmaster.createEvenement() in the loop TEST");
			evenement = new Evenement();
			evenement.setNom(nom);
			evenement.setJour(jour);
			evenement.setHeure(heure);
			evenement.setSalle(salle);
			em.persist(evenement);
			em.flush();
		}
		return evenement;
	}

	@Override
	public Evenement removeEvenement(int id) {
		System.out.println("JpaTicketmaster.removeEvenement()");
		Evenement evenement = this.getEvenementById(id);
		if (evenement != null){
			try{
				if (this.em.isJoinedToTransaction()){
					this.em.remove(evenement);
				} else {
					this.em.getTransaction().begin();
					this.em.remove(evenement);
					this.em.getTransaction().commit();
				}
			} catch (NoResultException e){
				e.printStackTrace();
			}
		}
		return evenement;
	}

	@Override
	public Reservation getReservationById(int id) {
		System.out.println("JpaTicketmaster.getReservationById()");
		Reservation reservation = null;
		if (id > 0){
			reservation = this.em.find(Reservation.class, id);
		}
		return reservation;
	}

	@Override
	public Reservation createReservation(Evenement evenement, Client client) {
		System.out.println("JpaTicketmaster.createReservation()");
		Reservation reservation = null;
		if (this.getEvenementById(evenement.getId()) != null && this.getClientById(client.getId()) != null){
			reservation = new Reservation();
			reservation.setEvenement(evenement);
			reservation.setClient(client);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(reservation);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(reservation);
				this.em.getTransaction().commit();
			}
		}
		return reservation;
	}

	@Override
	public Salle getSalleById(int id) {
		System.out.println("JpaTicketmaster.getSalleById()");
		Salle salle = null;
		if (id > 0){
			salle = this.em.find(Salle.class, id);
		}
		return salle;
	}

}
