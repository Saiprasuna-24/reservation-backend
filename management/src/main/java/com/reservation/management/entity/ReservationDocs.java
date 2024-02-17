package com.reservation.management.entity;

import java.util.Arrays;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown =true)
@Entity
@Table(name="ReservationDocs")
public class ReservationDocs {

	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue(generator ="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String id;
	
	@Column(name="ReservationId")
	private int reservationId;
	
	@Column(name="DocumentUrl")
	private String documentUrl;
	
	private String fileName;
	
	 private byte[] data;
	 
	 private String fileType;
	
	public String getFileName() {
		return fileName;
	}

//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

   

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId =  reservationId;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="reservations_Id",referencedColumnName="id")
	private Reservations reservations;
	
	

	public Reservations getReservations() {
		return reservations;
	}

	public void setReservations(Reservations reservations) {
		this.reservations = reservations;
	}

	public ReservationDocs() {
	
	}

	

	
//
//	public byte[] getLogo() {
//		return logo;
//	}
//
//	public void setLogo(byte[] logo) {
//		this.logo = logo;
//	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	

	

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	

	public ReservationDocs(String id, int reservationId, String documentUrl, String fileName, byte[] data,
			String fileType, Reservations reservations) {
		super();
		this.id = id;
		this.reservationId = reservationId;
		this.documentUrl = documentUrl;
		this.fileName = fileName;
		this.data = data;
		this.fileType = fileType;
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "ReservationDocs [id=" + id + ", reservationId=" + reservationId + ", documentUrl=" + documentUrl
				+ ", fileName=" + fileName + ", data=" + Arrays.toString(data) + ", fileType=" + fileType
				+ ", reservations=" + reservations + "]";
	}

	
	
	
	
	
	
	
}
