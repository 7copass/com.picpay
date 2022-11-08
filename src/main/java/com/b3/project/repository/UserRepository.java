package com.b3.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b3.project.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	public boolean existsByCpfCnpj(String cpfCnpj); 
	public boolean existsByEmail(String email ); 
	
}
  
 