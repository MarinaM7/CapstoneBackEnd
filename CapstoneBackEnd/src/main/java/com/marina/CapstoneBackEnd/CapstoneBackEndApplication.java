package com.marina.CapstoneBackEnd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.marina.CapstoneBackEnd.entities.Appointment;
import com.marina.CapstoneBackEnd.entities.Report;
import com.marina.CapstoneBackEnd.entities.Role;
import com.marina.CapstoneBackEnd.entities.RoleType;
import com.marina.CapstoneBackEnd.entities.User;
import com.marina.CapstoneBackEnd.services.AppointmentService;
import com.marina.CapstoneBackEnd.services.ReportService;
import com.marina.CapstoneBackEnd.services.RoleService;
import com.marina.CapstoneBackEnd.services.UserService;

@SpringBootApplication
public class CapstoneBackEndApplication implements CommandLineRunner {

	@Autowired
	private RoleService rs;

	@Autowired
	private UserService us;

	@Autowired
	private AppointmentService as;
	
	@Autowired
	private ReportService repsrv;
	

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CapstoneBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		boolean insert = false;

		if (insert) {
			insertRoles();
			insertUsers();
		}

		// insertAppointment();
		// insertDoctor();
		// insertPatient();
		// insertReport();

	}

	public void insertRoles() {

		Role roleAdmin = new Role();
		roleAdmin.setRoleType(RoleType.ROLE_ADMIN);

		rs.addRole(roleAdmin);

		Role roleUserDoctor = new Role();
		roleUserDoctor.setRoleType(RoleType.ROLE_USER_DOCTOR);

		rs.addRole(roleUserDoctor);

		Role roleUserPatient = new Role();
		roleUserPatient.setRoleType(RoleType.ROLE_USER_PATIENT);

		rs.addRole(roleUserPatient);

	}

	public void insertUsers() {

		// User Admin
		User u1 = new User();
		u1.setUsername("admin");
		u1.setFirstName("Admin");
		u1.setLastName("Administrator");
		u1.setActive(true);
		u1.setEmail("admin@gmail.com");
		u1.setPassword(passwordEncoder.encode("admin"));

		Role roleAdmin = rs.findByRoleType(RoleType.ROLE_ADMIN);

		Set<Role> roles1 = new HashSet<>() {
			{
				add(roleAdmin);
			}
		};

		u1.setRoles(roles1);

		us.addUser(u1);

		// User Doctor
		User u2 = new User();
		u2.setUsername("doc");
		u2.setFirstName("Mario");
		u2.setLastName("Neri");
		u2.setActive(true);
		u2.setEmail("docneri@gmail.com");
		u2.setPassword(passwordEncoder.encode("doc"));

		Role roleDoc = rs.findByRoleType(RoleType.ROLE_USER_DOCTOR);

		Set<Role> roles2 = new HashSet<>() {
			{
				add(roleDoc);
			}
		};

		u2.setRoles(roles2);

		us.addUser(u2);

		// UserPatient
		User u3 = new User();
		u3.setUsername("patient");
		u3.setFirstName("Anna");
		u3.setLastName("Rossi");
		u3.setActive(true);
		u3.setEmail("annarossi@gmail.com");
		u3.setPassword(passwordEncoder.encode("patient"));

		Role rolePat = rs.findByRoleType(RoleType.ROLE_USER_PATIENT);

		Set<Role> roles3 = new HashSet<>() {
			{
				add(rolePat);
			}
		};

		u3.setRoles(roles3);

		us.addUser(u3);

	}

	public void insertDoctor() {
		// User Doctor
		User u2 = new User();
		u2.setUsername("docMegan");
		u2.setFirstName("Megan");
		u2.setLastName("Merolli");
		u2.setActive(true);
		u2.setEmail("docmerolli@gmail.com");
		u2.setPassword(passwordEncoder.encode("docMegan"));

		Role roleDoc = rs.findByRoleType(RoleType.ROLE_USER_DOCTOR);

		Set<Role> roles2 = new HashSet<>() {
			{
				add(roleDoc);
			}
		};

		u2.setRoles(roles2);

		us.addUser(u2);
	}
	
	public void insertPatient() {
		// UserPatient
				User u3 = new User();
				u3.setUsername("patient2");
				u3.setFirstName("Paolo");
				u3.setLastName("Gialli");
				u3.setActive(true);
				u3.setEmail("paologialli@gmail.com");
				u3.setPassword(passwordEncoder.encode("patient2"));

				Role rolePat = rs.findByRoleType(RoleType.ROLE_USER_PATIENT);

				Set<Role> roles3 = new HashSet<>() {
					{
						add(rolePat);
					}
				};

				u3.setRoles(roles3);

				us.addUser(u3);
	}

	public void insertAppointment() {

		Appointment a = new Appointment();

		User doctor = us.findByUsername("doc").get();

		if (doctor != null) {
			a.setDoctor(doctor);
			System.out.println("got user" + doctor.getEmail());
		}

		User patient = us.findByUsername("patient").get();

		if (patient != null) {
			a.setPatient(patient);
			System.out.println("got user" + patient.getEmail());
		}

//		a.setDoctor(doctor);
//		a.setPatient(patient);
		a.setDate(LocalDate.of(2023, Month.AUGUST, 10));
		a.setTime(LocalTime.of(11, 30));
		a.setSex("w");
		a.setBirthDate(LocalDate.of(2002, Month.JUNE, 13));
		a.setBirthCity("Abano Terme");
		a.setAddress("Via Orio Vergani 2");
		a.setPhoneNumber("3453025264");

		as.save(a);
	}

	public void insertReport() {
		
		Report r = new Report();
		
		User patient = us.findByUsername("patient").get();
		User doctor = us.findByUsername("doc").get();
		Appointment a  = as.getByPatientId(patient.getId()).get(1);
		
		r.setAppointment(a);
		r.setDoctor(doctor);
		r.setPatient(patient);
		r.setBaso(1.1);
		r.setEmatocrito(1.2);
		r.setEmoglobina(1.3);
		r.setEos(2.2);
		r.setGlobuliRossi(3.2);
		r.setLimph(1.5);
		r.setLuc(0.3);
		r.setMono(3.3);
		r.setNeut(1.1);
		r.setPiastrine(4.4);
		
		repsrv.save(r);
		
	}
	
}
