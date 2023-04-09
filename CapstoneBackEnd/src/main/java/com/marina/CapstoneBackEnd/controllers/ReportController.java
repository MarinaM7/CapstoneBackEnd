package com.marina.CapstoneBackEnd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marina.CapstoneBackEnd.entities.Report;
import com.marina.CapstoneBackEnd.services.ReportService;

@RestController
@RequestMapping("/reports")
@CrossOrigin
public class ReportController {
	
	@Autowired
	private ReportService repsrv;
	
	@GetMapping("/patient_id/{id}")
	public List<Report> getAllReportsByPatientId(@PathVariable int id) {
		return repsrv.getByPatientId(id);
	}

	@GetMapping ("/doctor_id/{id}")
	public List<Report> getAllReportsByDoctorId(@PathVariable int id){
		return repsrv.getByDoctorId(id);
	}
	
	@GetMapping ("/appointment_id/{id}")
	public Optional<Report> getAllReportsByAppointmentId(@PathVariable int id){
		return repsrv.getByAppointmentId(id);
	}
	
	// TODO 
	// WHEN THE DOCTOR IS POSTING A REPORT IT HAS TO AUTOMATICALLY GET THE USER_ID OF THE DOCTOR 
	// AND TO AUTOMATICALLY TAKE THE PATIENT_ID AND DATA FROM THE APPOINTMENT OF WHICH THE DOCTOR IS POSTING THE REPORT
	
	@PostMapping("/save/report")
	public Report saveReport(@RequestBody Report report) {
		
		Report r = new Report();
		
		if(report.getAppointment() != null) r.setAppointment(report.getAppointment());
		if(report.getDoctor() != null) r.setDoctor(report.getDoctor());
		if(report.getPatient() != null) r.setPatient(report.getPatient());
		if(report.getBaso() != 0) r.setBaso(report.getBaso());
		if(report.getEmatocrito() != 0) r.setEmatocrito(report.getEmatocrito());
		if(report.getEmoglobina() != 0) r.setEmoglobina(report.getEmoglobina());
		if(report.getEos() != 0) r.setEos(report.getEos());
		if(report.getGlobuliRossi() != 0) r.setGlobuliRossi(report.getGlobuliRossi());
		if(report.getLimph() != 0) r.setLimph(report.getLimph());
		if(report.getLuc() != 0) r.setLuc(report.getLuc());
		if(report.getMono() != 0) r.setMono(report.getMono());
		if(report.getNeut() != 0) r.setNeut(report.getNeut());
		if(report.getPiastrine() != 0) r.setPiastrine(report.getPiastrine());
		
		return repsrv.save(r);
		
	}
	
}
