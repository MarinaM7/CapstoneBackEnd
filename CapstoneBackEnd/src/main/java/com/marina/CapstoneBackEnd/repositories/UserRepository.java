package com.marina.CapstoneBackEnd.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marina.CapstoneBackEnd.entities.Role;
import com.marina.CapstoneBackEnd.entities.RoleType;
import com.marina.CapstoneBackEnd.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   
	Optional<User> findByUsername(String n);
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM users JOIN user_roles ur ON users.id = ur.user_id JOIN roles r ON r.id = ur.role_id WHERE r.role_type = :r")
	List<User> findByRole(String r);
	
	@Query(nativeQuery = true,
            value = "SELECT * FROM users JOIN user_roles ur ON users.id = ur.user_id JOIN roles r ON r.id = ur.role_id WHERE r.role_type = :r AND users.id = :id")
	Optional<User> findByRoleAndId(String r, int id);
}