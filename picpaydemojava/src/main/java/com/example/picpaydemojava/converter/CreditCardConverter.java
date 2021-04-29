package com.example.picpaydemojava.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.picpaydemojava.dto.CreditCardDTO;
import com.example.picpaydemojava.dto.TransactionDTO;
import com.example.picpaydemojava.model.CreditCard;
import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.service.IUserService;
import com.example.picpaydemojava.util.CreditCardUtil;

@Component
public class CreditCardConverter extends ConveterBase<CreditCard, CreditCardDTO> {

	@Autowired
	private IUserService userService;
	
	@Override
	public CreditCardDTO convertEntityToDTO(CreditCard entity) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transaction,TransactionDTO>(){
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity,CreditCardDTO.class);
	}

	@Override
	public CreditCard convertDTOToEntity(CreditCardDTO dto) {
		return CreditCard.builder()
				.flag(dto.getFlag())
				.number(CreditCardUtil.mask(dto.getNumber()))
				.numberToken(dto.getNumberToken())
				.user(userService.consultEntity(dto.getUser().getLogin()))
				.build();
	}

}
