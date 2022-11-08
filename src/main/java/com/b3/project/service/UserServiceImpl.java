package com.b3.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.project.model.UserEntity;
import com.b3.project.repository.UserRepository;

@Service
public class UserServiceImpl implements IUser {
	
	@Autowired
	UserRepository repository;

	@Transactional 
	public UserEntity createAccount(UserEntity newUser) {
		
		return repository.save(newUser);
	}

	@Override
	public Optional<UserEntity> findByIdUser(Long id) {
		return repository.findById(id);
		
	}

	@Override
	public List<UserEntity> allUsers() {
		return repository.findAll();
	}

	@Override
	public boolean existsByCpfCnpj(String cpfCnpj) {
		return repository.existsByCpfCnpj(cpfCnpj);
	}

	@Override
	public boolean existsByEmail(String Email) {
		
		return repository.existsByEmail(Email);
	}
	 
	
 
}
