package com.marina.CapstoneBackEnd.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marina.CapstoneBackEnd.entities.Role;
import com.marina.CapstoneBackEnd.entities.RoleType;
import com.marina.CapstoneBackEnd.entities.User;
import com.marina.CapstoneBackEnd.repositories.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public Optional<User> getById(int id) {
		return repo.findById(id);
	}
	
	public List<User> getByRoles(RoleType r) {
		return repo.findByRole(r.toString());
	}
	
	public Optional<User> getByRoleAndId(RoleType r, int id) {
		return repo.findByRoleAndId(r.toString(), id);
	}
	
	
	public Iterable<User> getAll() {
		return repo.findAll();
	}
	
	public Optional<User> findByUsername(String nome) {
		return repo.findByUsername(nome);
	}
	
	public void addUser(User u) {
		repo.save(u);
	}
	
	public void deleteUser(User u) {
		repo.delete(u);
	}
	
}
