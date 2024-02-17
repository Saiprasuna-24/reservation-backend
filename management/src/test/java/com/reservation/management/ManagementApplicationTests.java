package com.reservation.management;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reservation.management.entity.Reservations;
import com.reservation.management.repository.ReservationsRepository;

//import com.springboot.restapi.model.User;
///import com.springboot.restapi.repository.UserRepository;


@SpringBootTest
class ManagementApplicationTests {
//
//	@Test
//	void contextLoads() {
//		
//	}
	
	@Autowired
	private ReservationsRepository repo;
	
	@Test
	public void testCreate() {
		
		Reservations r =new  Reservations();
		//r.setId(23);
		r.setResrvationDoneByEmployeeId(22262);
		r.setTravelRequestId(123);
		r.setReservationTypeId(567);
		r.setReservationDoneWithEntity("flight");
		r.setReservationDate(new Date(2023-04-05));
		r.setAmount(50000);
		r.setConfirmationId("895");
		r.setRemarks("nil");
		repo.save(r);
		//assertNotNull(repo.findById(23).get());
	}
	
	@Test
	public void testReadAll() {
		List<Reservations> list = repo.findAll();
    	assertThat(list).size().isGreaterThan(0);
	}
	
	  @Test
      public void testSinglereservation() {
	    Reservations reservation = repo.findById(40).get();
	   assertEquals("flight",reservation.getReservationDoneWithEntity());
	  }
	
	

}








//@Test
//public void testUpdate() {
//	User user = userRepository.findById(2L).get();
//	user.setFirstName("Jasna");
//	userRepository.save(user);
//	assertNotEquals("jacob",userRepository.findById(2L).get().getFirstName());
//}
//@Test
//public void testDelete() {
//	userRepository.deleteById(1L);
//	assertThat(userRepository.existsById(1L)).isFalse();
//}
//
//}
