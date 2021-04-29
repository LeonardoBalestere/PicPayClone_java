package com.example.picpaydemojava.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.example.picpaydemojava.dto.UserDTO;
import com.example.picpaydemojava.model.User;

public class UserConverter extends ConveterBase<User,UserDTO> {

	@Override
	public UserDTO convertEntityToDTO(User entity) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<User,UserDTO>(){
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity,UserDTO.class);
	}
	@Override
	public User convertDTOToEntity(UserDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<UserDTO,User>(){
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(dto,User.class);
	}

}
