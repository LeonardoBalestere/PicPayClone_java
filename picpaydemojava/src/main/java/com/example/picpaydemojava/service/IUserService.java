package com.example.picpaydemojava.service;

import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.model.User;

public interface IUserService {

	User consultEntity(String login);

	void validate(User... users);

	void attBalance(Transaction transaction, Boolean isCreditCard);

}
