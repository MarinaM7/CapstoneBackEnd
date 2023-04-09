package com.marina.CapstoneBackEnd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marina.CapstoneBackEnd.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM appointments WHERE patient_id = :id")
	List<Appointment> findByPatientId(@Param("id")int id);
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM appointments WHERE doctor_id = :id")
	List<Appointment> findByDoctorId(@Param("id")int id);
	
}
