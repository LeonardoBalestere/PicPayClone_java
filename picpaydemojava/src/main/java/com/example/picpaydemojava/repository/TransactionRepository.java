package com.example.picpaydemojava.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpaydemojava.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

	Page<Transaction> findByOrigin_LoginOrDestiny_Login(String login, String login2, Pageable paging);
	
}
