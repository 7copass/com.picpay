package com.b3.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b3.project.DTOs.ResponseMessageDTO;
import com.b3.project.DTOs.UserDTO;
import com.b3.project.model.UserEntity;
import com.b3.project.service.UserServiceImpl;

@RestController
@RequestMapping("/picpay")
public class BankController {

	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/create-account")
	public ResponseEntity<?> createAccount(@RequestBody @Valid UserDTO userDTO){
		UserEntity newUser = new UserEntity();
		BeanUtils.copyProperties(userDTO, newUser, "id");
		if(service.existsByCpfCnpj(newUser.getCpfCnpj())) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageDTO("Cpf/Cnpj já cadastrados"));
		}else if(service.existsByEmail(newUser.getEmail())) { 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageDTO("E-mail já cadastrado"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(newUser));
	}
	
	@GetMapping("/all-users")
	public ResponseEntity<List<UserEntity>> allUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(service.allUsers());
	}
	 
	 
} 
