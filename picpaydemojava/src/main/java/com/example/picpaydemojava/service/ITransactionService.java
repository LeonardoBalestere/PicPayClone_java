package com.example.picpaydemojava.service;

import com.example.picpaydemojava.dto.TransactionDTO;

public interface ITransactionService {

	TransactionDTO process( TransactionDTO transactionDTO);

}
