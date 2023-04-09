package com.marina.CapstoneBackEnd.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marina.CapstoneBackEnd.entities.Role;
import com.marina.CapstoneBackEnd.entities.RoleType;
import com.marina.CapstoneBackEnd.repositories.RoleRepository;


@Service
public class RoleService {
	
	@Autowired
	RoleRepository repo;
	
	public void addRole(Role r) {
		repo.save(r);
	}
	
	public Optional<Role> getById(int id) {
		return repo.findById(id);
	}
	
	public Role findByRoleType ( RoleType r ) {
		return repo.getByRoleType(r);
	}
	
}
