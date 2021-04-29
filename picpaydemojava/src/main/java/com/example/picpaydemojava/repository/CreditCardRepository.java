package com.example.picpaydemojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpaydemojava.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {

}
