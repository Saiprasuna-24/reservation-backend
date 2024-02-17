package com.reservation.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reservation.management.entity.ReservationDocs;

@Repository
public interface DocsRepository  extends JpaRepository<ReservationDocs,Integer>{
	
//	@Query("select c from ReservationDocs c  where c.reservationId=:reservationId")
//	String getdocumentUrl(int reservationId);

}

