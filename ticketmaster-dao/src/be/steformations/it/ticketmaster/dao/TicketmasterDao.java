package be.steformations.it.ticketmaster.dao;

import be.steformations.it.ticketmaster.beans.Client;
import be.steformations.it.ticketmaster.beans.Evenement;
import be.steformations.it.ticketmaster.beans.Reservation;
import be.steformations.it.ticketmaster.beans.Salle;

public interface TicketmasterDao {

	Client getClientById(int id);
	Evenement getEvenementById(int id);
	Evenement createEvenement(String nom, java.util.Date jour, java.util.Date heure, Salle salle);
	Evenement removeEvenement(int id);
	Reservation getReservationById(int id);
	Reservation createReservation(Evenement evenement, Client client);
	Salle getSalleById(int id);
	
}
