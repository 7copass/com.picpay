package com.b3.project.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b3.project.model.TransferEntity;
import com.b3.project.model.UserEntity;
import com.b3.project.repository.TransferRepository;
import com.b3.project.repository.UserRepository;

@Service
public class TransferServiceImpl implements ITransfer {

	@Autowired
	TransferRepository repository;

	@Autowired
	UserRepository userRepository;

	@Transactional
	public TransferEntity transation(TransferEntity transfer) {

		return repository.save(transfer);
	}

	
	

}
