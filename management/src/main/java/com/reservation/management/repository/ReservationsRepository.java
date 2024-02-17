package com.reservation.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reservation.management.entity.Reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations,Integer>{
	
	 @Query("select c from Reservations c  where c.travelRequestId=:travelRequestId")
	 List<Reservations> findbyTravelrequestid(int travelRequestId);

}
