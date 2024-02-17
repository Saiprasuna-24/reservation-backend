package com.reservation.management.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reservation.management.entity.ReservationDocs;
import com.reservation.management.entity.ReservationTypes;
import com.reservation.management.entity.Reservations;
import com.reservation.management.payload.Response;
import com.reservation.management.services.ReservationServiceImpl;
//import com.reservation.management.services.ReservationTypeService;

import jakarta.validation.Valid;

@CrossOrigin("http://localhost:4200")
@RestController
@RestControllerAdvice
@Validated
@RequestMapping("/api/reservations")
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl  reservationService ;
	
//	@Autowired
//	private ReservationsRepository repo;
	

	@GetMapping("/allreservations")
    public List<Reservations>  getAllReservations(){
		
    	return reservationService.getAllReservations() ;
    }
	
	@GetMapping({"/reservationbyid/{id}"})
    public Reservations getReservationsbyId(@PathVariable("id") int id) {
    	return reservationService.getReservationsbyId(id);
    }
	
	@PostMapping("/add")
	public Reservations createReservation(@RequestBody  @Valid Reservations reservations ) {
		return reservationService.createReservation(reservations);
	}
	
	@GetMapping("/track/{travelRequestId}")
	public  List<Reservations> getAllReservations(@PathVariable int travelRequestId ) {
		return reservationService.findbyTravelrequestid(travelRequestId);
	}
	
//	,@RequestParam("user") String user 
	
	@PostMapping("/uploadFile")
	public ResponseEntity<Response> saveFile(@RequestParam("file") MultipartFile file,@RequestParam("user") String user,@RequestParam("reservationid") int reservationid) throws JsonParseException,JsonMappingException,IOException{
		
		ReservationDocs reservationDocs= new ObjectMapper().readValue(user, ReservationDocs.class);
		reservationDocs.setData(file.getBytes());
		reservationDocs.setFileType(file.getContentType());
		reservationDocs.setReservationId(reservationid);
		reservationDocs.setFileName(file.getOriginalFilename());
		
		ReservationDocs dbreservationDocs  = reservationService.save(reservationDocs);
	    if(dbreservationDocs !=null) {
		  return new ResponseEntity<Response>(new Response("file saved successfully"),HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<Response>(new Response("Not saved"),HttpStatus.BAD_REQUEST);
	    }
	}
	@GetMapping("{reservationId}/download")
    //@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> downloadFile(@PathVariable int reservationId ){
	    String fileId = reservationService.getdocumentUrl(reservationId);
	  
	// ReservationDocs dbFile=null;
	  
	  //dbFile=db;
	    System.out.println(fileId);
	   // String contentType="application/octet-stream";
	    ReservationDocs dbFile=reservationService.getFile(fileId);
		 return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				  .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + dbFile.getFileName() +"\"")
				  .body(new ByteArrayResource(dbFile.getData()));
	    
	 
}
	
	
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<String> DocumentSizeLimitExceededExcption(RedirectAttributes ra) {
		//return ra.addFlashAttribute("error","you could not upload file bigger than X MB");
		return new ResponseEntity<String>("you could not enter file bigger than 1 MB",HttpStatus.BAD_REQUEST);
	}
	
	
	

//	@GetMapping("{reservationId}/download")
//		public ResponseEntity<?> downloadFile(@PathVariable int reservationId ){
//		    String fileId =reservationService.getdocumentUrl(reservationId);
//		    System.out.println(fileId);
		   // String contentType="application/octet-stream";
		   // ReservationDocs dbFile=reservationService.getFile(fileId);
//			 return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
//					  .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + dbFile.getFileName() +"\"")
//					  .body(new ByteArrayResource(dbFile.getData()));
		    
//			 return (ResponseEntity<?>) ResponseEntity.ok();
//		}

	
//	
	
	
	@GetMapping("/types")
     public List<ReservationTypes>  getAllReservationsTypes(){
		
    	return reservationService.getAllReservationsTypes() ;
    }
}
