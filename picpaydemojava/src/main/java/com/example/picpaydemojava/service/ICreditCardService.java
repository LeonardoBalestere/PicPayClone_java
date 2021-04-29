package com.example.picpaydemojava.service;

import com.example.picpaydemojava.dto.CreditCardDTO;
import com.example.picpaydemojava.model.CreditCard;

public interface ICreditCardService {

	CreditCardDTO save(CreditCardDTO creditCard);

}