package com.marina.CapstoneBackEnd.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marina.CapstoneBackEnd.entities.Report;

@Repository
public interface ReportRepository extends JpaRepository <Report, Integer> {


	@Query(nativeQuery = true,
            value = "SELECT * FROM reports WHERE patient_id = :id")
	List<Report> findByPatientId(@Param("id")int id);
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM reports WHERE doctor_id = :id")
	List<Report> findByDoctorId(@Param("id")int id);

	@Query(nativeQuery = true,
            value = "SELECT * FROM reports WHERE appointment_id = :id")
	Optional<Report> findByAppointmentId(@Param("id")int id);
	
}
