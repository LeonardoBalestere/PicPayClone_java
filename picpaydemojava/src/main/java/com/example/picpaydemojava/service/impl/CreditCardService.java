package com.example.picpaydemojava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.picpaydemojava.converter.CreditCardConverter;
import com.example.picpaydemojava.dto.CreditCardDTO;
import com.example.picpaydemojava.model.CreditCard;
import com.example.picpaydemojava.repository.CreditCardRepository;
import com.example.picpaydemojava.service.ICreditCardService;
import com.example.picpaydemojava.service.IUserService;

@Component
public class CreditCardService implements ICreditCardService{

	@Autowired
	private CreditCardRepository creditCardRepositoy;
	
	@Autowired
	private CreditCardConverter creditCardConverter;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public CreditCardDTO save(CreditCardDTO creditCardDTO) {
		CreditCardDTO creditCardReturn = null;
		if(creditCardDTO.getIsSave()) {
			CreditCard creditCard = creditCardConverter.convertDTOToEntity(creditCardDTO);
			userService.validate(creditCard.getUser());
			CreditCard creditCardSave = creditCardRepositoy.save(creditCard);
			creditCardReturn = creditCardConverter.convertEntityToDTO(creditCardSave);
		}
		return creditCardReturn;
	} 

}
