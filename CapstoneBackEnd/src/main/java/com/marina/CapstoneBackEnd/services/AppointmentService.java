package com.marina.CapstoneBackEnd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marina.CapstoneBackEnd.entities.Appointment;
import com.marina.CapstoneBackEnd.repositories.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired AppointmentRepository appRepo;

	public Appointment save(Appointment a) {
		return appRepo.save(a);
	}

	public List<Appointment> getAll(){
		return appRepo.findAll();
	}
	
	public Optional<Appointment> getById(int id) {
		return appRepo.findById(id);
	}
	
	public List<Appointment> getByPatientId(int id){
		return appRepo.findByPatientId(id);
	}
	
	public List<Appointment> getByDoctorId(int id){
		return appRepo.findByDoctorId(id);
	}
}
