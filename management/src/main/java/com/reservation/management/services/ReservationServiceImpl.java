package com.reservation.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.management.entity.ReservationDocs;
import com.reservation.management.entity.ReservationTypes;
import com.reservation.management.entity.Reservations;
import com.reservation.management.repository.DocsRepository;
import com.reservation.management.repository.ReservationTypesRepo;
import com.reservation.management.repository.ReservationsRepository;

@Service
public class ReservationServiceImpl implements ReservationServices  {
	
	@Autowired
	private ReservationsRepository reservationsRepository;
	
	 @Autowired
	 private ReservationTypesRepo reservationTypesRepo;
	 
	 @Autowired
	 private DocsRepository docs;
	
	
	public List<Reservations> getAllReservations(){
		
		
		return reservationsRepository.findAll();
		
	}

	public Reservations getReservationsbyId(int id) {
		return reservationsRepository.findById(id).get();
	}
	
	public Reservations createReservation(Reservations reservations) {
		return reservationsRepository.save(reservations);
	}
	
	//public List<Reservations> findbyTravelrequestid(Integer id){
//		List<Reservations> reservations=reservationsRepository.findbyTravelrequest(id);
//		return reservations;
//	}
//	
//	public Optional<Reservations> findbyTravelrequestid(int travelRequestId){
//		return  reservationsRepository.findById(travelRequestId);
//	}
	
	public ReservationDocs save(ReservationDocs reservationDocs) {
		return docs.save(reservationDocs);
	}
	
	public List<ReservationTypes> getAllReservationsTypes(){
		
		return reservationTypesRepo.findAll();
		
	}


	@Override
	public List<Reservations> findbyTravelrequestid(int travelRequestId) {
		
		return reservationsRepository.findbyTravelrequestid(travelRequestId);
	}
	
	
//	public String getdocumentUrl(int reservationId) {
//		return docs.getdocumentUrl(reservationId);
//	}
//	
//	
//	public Optional<ReservationDocs> getFile(int  reservationid)  {
//		return  docs.findById(reservationid);
//				
//	}
//	
}
