package com.b3.project.groups.sequence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.b3.project.DTOs.UserDTO;
import com.b3.project.groups.PessoaFisica;
import com.b3.project.groups.PessoaJuridica;
import com.b3.project.model.TypeUser;
import com.b3.project.model.UserEntity;

public class UserGroupSequenceProvider implements DefaultGroupSequenceProvider<UserEntity> {

	@Override
	public List<Class<?>> getValidationGroups(UserEntity user) {
		List<Class<?>> groups = new ArrayList<>();

		groups.add(UserEntity.class);

		if (isPersonSelected(user)) {
			groups.add(user.getType().getGroup());
		}

		return groups;

	}

	boolean isPersonSelected(UserEntity user) { 
		return user != null && user.getType() != null;
	}
	
}
