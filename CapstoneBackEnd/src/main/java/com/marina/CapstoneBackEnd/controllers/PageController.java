package com.marina.CapstoneBackEnd.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marina.CapstoneBackEnd.entities.Role;
import com.marina.CapstoneBackEnd.entities.RoleType;
import com.marina.CapstoneBackEnd.entities.User;
import com.marina.CapstoneBackEnd.services.UserService;

@RestController
@RequestMapping("/page")
@CrossOrigin
public class PageController {
	
	@Autowired
	private UserService us;

	@GetMapping("/hello")
	public String hello() {
		return "hi, you finally got here";
	}
	
	@GetMapping("/users")
	public List<User> users() {
		return (List<User>) us.getAll();
	}
	
	@GetMapping("/docs")
	public List<User> docs() {
		
		return us.getByRoles(RoleType.ROLE_USER_DOCTOR);
	}
	
	@GetMapping("/doc/{id}")
	public User docById(@PathVariable int id) {
		return us.getByRoleAndId(RoleType.ROLE_USER_DOCTOR, id).get();
	}
	
	@GetMapping("/patient/{id}")
	public User patientById(@PathVariable int id) {
		return us.getByRoleAndId(RoleType.ROLE_USER_PATIENT, id).get();
	}
	
	@GetMapping("/user/{id}")
	public User userById(@PathVariable int id) {
		
		return us.getById(id).get();
	}
	
	@GetMapping("/update/user/{id}")
	public User updateUserById(@PathVariable int id, @RequestBody User user) {
		
		User u = us.getById(id).get();
		
		if(user.getFirstName() != "")u.setFirstName(user.getFirstName());
		if(user.getLastName() != "")u.setLastName(user.getLastName());
		if(user.getEmail() != "")u.setEmail(user.getEmail());
		if(user.getUsername() != "")u.setUsername(user.getUsername());
		
		us.addUser(u);
		
		return u;
	}
	
}
