package com.b3.project.model;

import com.b3.project.groups.PessoaFisica;
import com.b3.project.groups.PessoaJuridica;

import lombok.Data;



public enum TypeUser {
	COMMON("fisica", "CPF", "000.000.000-00", PessoaFisica.class), 
	SHOPKEEPER("juridica", "CNPJ", "00.000.000/0000-00", PessoaJuridica.class);

	private final String typePerson;
	private final String document;
	private final String mask;
	private final Class<?> group;

	

private	TypeUser(String typePerson, String document, String mask, Class<?> group) {
		this.typePerson = typePerson;
		this.document = document;
		this.mask = mask;
		this.group = group;
	}



public String getTypePerson() {
	return typePerson;
}



public String getDocument() {
	return document;
}



public String getMask() {
	return mask;
}



public Class<?> getGroup() {
	return group;
}
	

	



}
 