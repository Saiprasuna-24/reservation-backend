package com.reservation.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.management.entity.ReservationTypes;

@Repository
public interface ReservationTypesRepo extends JpaRepository<ReservationTypes,Integer> {

}
