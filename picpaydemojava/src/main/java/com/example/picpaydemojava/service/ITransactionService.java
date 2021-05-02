package com.example.picpaydemojava.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.picpaydemojava.dto.TransactionDTO;

public interface ITransactionService {

	TransactionDTO process( TransactionDTO transactionDTO);

	Page<TransactionDTO> list(Pageable paging, String login);

}
