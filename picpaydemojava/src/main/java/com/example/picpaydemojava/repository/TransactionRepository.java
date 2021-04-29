package com.example.picpaydemojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpaydemojava.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	

}
