package com.marina.CapstoneBackEnd.entities;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "reports")
@Data
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private User doctor;
	
	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private User patient;
	
	// PATIENT DATA
	
	@OneToOne
	@JoinColumn(name = "appointment_id", referencedColumnName = "id")
	private Appointment appointment;
	
	// EMOCROMO VALUES 
	
	private double globuliRossi;
	
	private double emoglobina;
	
	private double ematocrito;
	
	private double luc;
	
	private double neut;
	
	private double limph;
	
	private double mono;
	
	private double eos;
	
	private double baso;
	
	private double piastrine;

}
