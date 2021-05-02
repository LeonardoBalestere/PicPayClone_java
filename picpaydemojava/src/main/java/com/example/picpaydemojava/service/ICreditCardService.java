package com.example.picpaydemojava.service;

import org.springframework.stereotype.Service;

import com.example.picpaydemojava.dto.CreditCardDTO;

@Service
public interface ICreditCardService {

	CreditCardDTO save(CreditCardDTO creditCard);

}