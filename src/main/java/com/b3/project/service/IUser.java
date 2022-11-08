package com.b3.project.service;

import java.util.List;
import java.util.Optional;

import com.b3.project.model.UserEntity;

public interface IUser {
	
	public UserEntity createAccount(UserEntity newUser);
	
	public Optional<UserEntity> findByIdUser(Long id);
	
	public List<UserEntity> allUsers();
	
	public boolean existsByCpfCnpj(String cpfCnpj);
	public boolean existsByEmail(String Email);
}
