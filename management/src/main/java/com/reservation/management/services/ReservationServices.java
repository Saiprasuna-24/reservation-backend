package com.reservation.management.services;

import java.util.List;
import java.util.Optional;

import com.reservation.management.entity.ReservationDocs;
import com.reservation.management.entity.ReservationTypes;
import com.reservation.management.entity.Reservations;

public interface ReservationServices {
	public List<Reservations> getAllReservations();
	
	public Reservations getReservationsbyId(int id);
	
	public Reservations createReservation(Reservations reservations);
	
	public List<Reservations> findbyTravelrequestid(int  travelRequestId);
	
	public List<ReservationTypes> getAllReservationsTypes();
	
	public ReservationDocs save(ReservationDocs reservationDocs);
	
	//public Optional<ReservationDocs> getFile(int  reservationid) ;
	
	// public String getdocumentUrl(int reservationId);

}
