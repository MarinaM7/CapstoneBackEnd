package com.marina.CapstoneBackEnd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marina.CapstoneBackEnd.entities.Role;
import com.marina.CapstoneBackEnd.entities.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role getByRoleType(RoleType r);

}
