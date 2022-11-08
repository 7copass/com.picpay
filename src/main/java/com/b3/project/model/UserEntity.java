package com.b3.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.b3.project.groups.PessoaFisica;
import com.b3.project.groups.PessoaJuridica;
import com.b3.project.groups.sequence.UserGroupSequenceProvider;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@GroupSequenceProvider(UserGroupSequenceProvider.class)
public class UserEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	@CPF(groups = PessoaFisica.class)
	@CNPJ(groups = PessoaJuridica.class)
	private String cpfCnpj;
	
	private String email;
	
	private String password;
	
	private Double accountBalance;
	
	private TypeUser type;
	 
	
	public void debitAccount(double value) {
		if(accountBalance <= 0) {
			
		}
		accountBalance = accountBalance - value;
	}
	
	public void creditAccount(double value) {
		accountBalance = accountBalance + value;

	}

	
}
