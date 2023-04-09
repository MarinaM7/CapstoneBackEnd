package com.marina.CapstoneBackEnd.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marina.CapstoneBackEnd.entities.Appointment;
import com.marina.CapstoneBackEnd.entities.User;
import com.marina.CapstoneBackEnd.services.AppointmentService;
import com.marina.CapstoneBackEnd.services.UserService;

@RestController
@RequestMapping("app")
@CrossOrigin
public class AppointmentContoller {

	@Autowired
	private UserService us;
	@Autowired
	private AppointmentService appsrv;

	@GetMapping("/appointments/all")
	public List<Appointment> getAllAppointments() {
		return appsrv.getAll();
	}

	@GetMapping("/appointments/its_id/{id}")
	public Appointment getAllAppointmentsByItsId(@PathVariable int id) {
		return appsrv.getById(id).get();
	}
	
	@GetMapping("/appointments/patient_id/{id}")
	public List<Appointment> getAllAppointmentsByPatientId(@PathVariable int id) {
		return appsrv.getByPatientId(id);
	}

	@GetMapping("/appointments/doctor_id/{id}")
	public List<Appointment> getAllAppointmentsByDoctorId(@PathVariable int id) {
		return appsrv.getByDoctorId(id);
	}

	// USE THIS PATH TO SAVE AN APPOINTMENT PASSING ALL THE DATA THAT ARE ASKED
	// TODO --> SOME DATA HAS TO BE PRECOMPILED IF IS ALREADY PRESENT ANOTHER
	// APPOINTMENT WITH THIS PATIENT_ID

	@PostMapping("/save/appointment")
	public Appointment saveAppointment2(@RequestBody Appointment app) {

		Appointment a = new Appointment();

		if (app.getAddress() != null)
			a.setAddress(app.getAddress());

		if (app.getBirthCity() != null)
			a.setBirthCity(app.getBirthCity());

		if (app.getBirthDate() != null)
			a.setBirthDate(app.getBirthDate());

		if (app.getDate() != null)
			a.setDate(app.getDate());

		if (app.getDoctor() != null)
			a.setDoctor(app.getDoctor());

		if (app.getPatient() != null)
			a.setPatient(app.getPatient());

		if (app.getPhoneNumber() != null)
			a.setPhoneNumber(app.getPhoneNumber());

		if (app.getSex() != null)
			a.setSex(app.getSex());

		if (app.getTime() != null)
			a.setTime(app.getTime());

		appsrv.save(a);

		return a;

	}

	@PutMapping("/update/appointment/{id}")
	public Appointment updateAppointment(@PathVariable int id, @RequestBody Appointment app) {

		Appointment a = appsrv.getById(id).get();

		if (app.getAddress() != "" && app.getAddress() != null )
			a.setAddress(app.getAddress());

		if (app.getBirthCity() != "" && app.getBirthCity() != null)
			a.setBirthCity(app.getBirthCity());

		if (app.getBirthDate() != null)
			a.setBirthDate(app.getBirthDate());

		if (app.getDate() != null)
			a.setDate(app.getDate());

		if (app.getDoctor() != null)
			a.setDoctor(app.getDoctor());

		if (app.getPatient() != null)
			a.setPatient(app.getPatient());

		if (app.getPhoneNumber() != "" && app.getPatient() != null)
			a.setPhoneNumber(app.getPhoneNumber());

		if (app.getSex() != null)
			a.setSex(app.getSex());

		if (app.getTime() != null)
			a.setTime(app.getTime());

		appsrv.save(a);

		return a;

	}

	@PutMapping("/update/details/appointments/patient_id/{id}")
	public List<Appointment> updateDetailsAppointmentsByPatientId(@PathVariable int id, @RequestBody Appointment app) {

		List<Appointment> a = appsrv.getByPatientId(id);

		for (Appointment p : a) {
			
			if (app.getAddress() != "")
				p.setAddress(app.getAddress());

			if (app.getBirthCity() != "")
				p.setBirthCity(app.getBirthCity());

			if (app.getBirthDate() != null)
				p.setBirthDate(app.getBirthDate());

			if (app.getDate() != null)
				p.setDate(app.getDate());

			if (app.getDoctor() != null)
				p.setDoctor(app.getDoctor());

			if (app.getPatient() != null)
				p.setPatient(app.getPatient());

			if (app.getPhoneNumber() != "")
				p.setPhoneNumber(app.getPhoneNumber());

			if (app.getSex() != null)
				p.setSex(app.getSex());

			if (app.getTime() != null)
				p.setTime(app.getTime());

			appsrv.save(p);
		}

		return a;

	}

}
