package com.example.picpaydemojava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.picpaydemojava.converter.TransactionConverter;
import com.example.picpaydemojava.dto.TransactionDTO;
import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.repository.TransactionRepository;
import com.example.picpaydemojava.service.ICreditCardService;
import com.example.picpaydemojava.service.ITransactionService;
import com.example.picpaydemojava.service.IUserService;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	private TransactionConverter transactionConverter;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ICreditCardService creditCardService;
	
	@Override
	public TransactionDTO process(TransactionDTO transactionDTO) {
		Transaction transaction = save(transactionDTO);
		creditCardService.save(transactionDTO.getCreditCard());
		userService.attBalance(transaction, transactionDTO.getIsCreditCard());
		return transactionConverter.convertEntityToDTO(transaction);
	}

	private Transaction save(TransactionDTO transactionDTO) {
		Transaction transaction = transactionConverter.convertDTOToEntity(transactionDTO);
		userService.validate(transaction.getDestiny(), transaction.getOrigin());
		return transactionRepository.save(transaction);
	}
	

	
}
