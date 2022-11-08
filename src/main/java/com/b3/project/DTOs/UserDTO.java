package com.b3.project.DTOs;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;


import com.b3.project.groups.PessoaFisica;
import com.b3.project.groups.PessoaJuridica;

import com.b3.project.model.TypeUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode

public class UserDTO {

	@NotBlank()
	private String fullName;
	
	@CPF(groups = PessoaFisica.class)
	@CNPJ(groups = PessoaJuridica.class)
	private String cpfCnpj;
	
	@NotBlank	
	private String email;
	
	@NotBlank
	private String password;
	
	@NotNull
	private Double accountBalance;
	
	@NotNull
	private TypeUser type;
	 
}
