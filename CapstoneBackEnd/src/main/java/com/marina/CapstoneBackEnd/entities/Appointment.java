package com.marina.CapstoneBackEnd.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor;
	
	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private User patient;
	
	private LocalDate date;
	
	private LocalTime time;
	
	// INFO about the patient
	
	private String sex;
	
	private LocalDate birthDate;
	
	private String birthCity;
	
	private String address;
	
	private String phoneNumber;
		
}
