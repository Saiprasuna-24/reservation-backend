package com.reservation.management.entity;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="Reservations")
public class Reservations {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	 @NotNull
	@Column(name="ReservationDoneByEmployeeId")
	private int resrvationDoneByEmployeeId;
	
	 @NotNull
	@Column(name="TravelRequestId")
	private int travelRequestId;
	
	 @NotNull
	@Column(name="ReservationTypeId")
	private int reservationTypeId;
	
    @Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
	@Column(name="CreatedOn")
	private Date createdOn;
	
    @NotNull
	@Column(name="ReservationDoneWithEntity")
	private String reservationDoneWithEntity;
	
    
	@Column(name = "ReservationDate")
	 @JsonFormat(pattern="yyyy-MM-dd")
	private Date reservationDate;
	
	@Positive(message="should be positive")
	@Column(name="Amount")
	private int amount;
	
	 @NotNull
	@Column(name="ConfirmationId")
	private String confirmationId ;
	
	
	@Column(name="Remarks")
	private String remarks;
	
	 
	  @PrePersist
	  private void onCreate() throws ParseException {
		  createdOn = new Date();
	  }
	
	
     @JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="type_id",referencedColumnName="typeId")
	private ReservationTypes reservationTypes;
	
    
   
	
	@OneToMany(mappedBy="reservations")
	private List<ReservationDocs> rerservationDocs;
	

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getResrvationDoneByEmployeeId() {
		return resrvationDoneByEmployeeId;
	}

	public void setResrvationDoneByEmployeeId(int resrvationDoneByEmployeeId) {
		this.resrvationDoneByEmployeeId = resrvationDoneByEmployeeId;
	}
	public int getTravelRequestId() {
		return travelRequestId;
	}

	public void setTravelRequestId(int travelRequestId) {
		this.travelRequestId = travelRequestId;
	}

	public int getReservationTypeId() {
		return reservationTypeId;
	}

	public void setReservationTypeId(int reservationTypeId) {
		this.reservationTypeId = reservationTypeId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getReservationDoneWithEntity() {
		return reservationDoneWithEntity;
	}

	public void setReservationDoneWithEntity(String reservationDoneWithEntity) {
		this.reservationDoneWithEntity = reservationDoneWithEntity;
	}

	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public ReservationTypes getReservationTypes() {
		return reservationTypes;
	}

	public void setReservationTypes(ReservationTypes reservationTypes) {
		this.reservationTypes = reservationTypes;
	}


	public Reservations() {
		
	}
	
    

	



	
	public Reservations(int id, int resrvationDoneByEmployeeId, int travelRequestId, int reservationTypeId,
			Date createdOn, String reservationDoneWithEntity, Date reservationDate, int amount, String confirmationId,
			String remarks, ReservationTypes reservationTypes, List<ReservationDocs> rerservationDocs) {
		super();
		this.id = id;
		this.resrvationDoneByEmployeeId = resrvationDoneByEmployeeId;
		this.travelRequestId = travelRequestId;
		this.reservationTypeId = reservationTypeId;
		this.createdOn = createdOn;
		this.reservationDoneWithEntity = reservationDoneWithEntity;
		this.reservationDate = reservationDate;
		this.amount = amount;
		this.confirmationId = confirmationId;
		this.remarks = remarks;
		this.reservationTypes = reservationTypes;
		this.rerservationDocs = rerservationDocs;
	}
	
	public List<ReservationDocs> getRerservationDocs() {
		return rerservationDocs;
	}
	public void setRerservationDocs(List<ReservationDocs> rerservationDocs) {
		this.rerservationDocs = rerservationDocs;
	}
	
	@Override
	public String toString() {
		return "Reservations [id=" + id + ", resrvationDoneByEmployeeId=" + resrvationDoneByEmployeeId
				+ ", travelRequestId=" + travelRequestId + ", reservationTypeId=" + reservationTypeId + ", createdOn="
				+ createdOn + ", reservationDoneWithEntity=" + reservationDoneWithEntity + ", reservationDate="
				+ reservationDate + ", amount=" + amount + ", confirmationId=" + confirmationId + ", remarks=" + remarks
				+ ", reservationTypes=" + reservationTypes + ", rerservationDocs=" + rerservationDocs + "]";
	}
	
	
	
	
	

	
	 
	
	
}
