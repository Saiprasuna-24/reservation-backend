package com.reservation.management.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ReservationTypes")
public class ReservationTypes {
	
	public ReservationTypes() {
		super();
	}


	public ReservationTypes(int typeId, String typeName,List<Reservations> reservations) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.reservations = reservations;
	}


	@Id
	private int typeId;
	
	@Column(name="TypeName")
	private String typeName;
	
	@JsonIgnore
	@OneToMany(mappedBy="reservationTypes")
	private List<Reservations> reservations ;


	@Override
	public String toString() {
		return "ReservationTypes [typeId=" + typeId + ", typeName=" + typeName + ", reservations=" + reservations + "]";
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public List<Reservations> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}
	
	

}
