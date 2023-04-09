package com.marina.CapstoneBackEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marina.CapstoneBackEnd.entities.Report;
import com.marina.CapstoneBackEnd.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired
	ReportRepository repoRepo;
	
	public Report save(Report r) {
		return repoRepo.save(r);
	}
	
	public List<Report> getByPatientId(int id){
		return repoRepo.findByPatientId(id);
	}
	
	public List<Report> getByDoctorId(int id){
		return repoRepo.findByDoctorId(id);
	}
	
	public Optional<Report> getByAppointmentId(int id){
		return repoRepo.findByAppointmentId(id);
	}
	
}
