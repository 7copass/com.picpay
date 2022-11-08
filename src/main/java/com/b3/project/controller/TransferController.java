package com.b3.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b3.project.DTOs.ResponseMessageDTO;
import com.b3.project.model.TransferEntity;
import com.b3.project.model.TypeUser;
import com.b3.project.model.UserEntity;

import com.b3.project.service.TransferServiceImpl;
import com.b3.project.service.UserServiceImpl;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	TransferServiceImpl service;

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/transaction")
	public ResponseEntity<?> transaction(@RequestBody @RequestParam Long payee, Long payer, Float value) {

		Optional<UserEntity> payerEntity = userServiceImpl.findByIdUser(payer);
		Optional<UserEntity> payeeEntity = userServiceImpl.findByIdUser(payee);

		TransferEntity transferEntity = new TransferEntity();
		transferEntity.setPayer(payerEntity.get());
		transferEntity.setPayee(payeeEntity.get());
		transferEntity.setValue(value);

		if (payerEntity.get().getAccountBalance() <= 0 || payerEntity.get().getAccountBalance() < value) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ResponseMessageDTO("insufficient payer balance"));
		}

		if (payerEntity.get().getType().equals(TypeUser.SHOPKEEPER)) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ResponseMessageDTO("The merchant type cannot perform transfers"));
		}
		payerEntity.get().debitAccount(value);
		payeeEntity.get().creditAccount(value);
		service.transation(transferEntity);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageDTO("Authorized"));

	}

}
