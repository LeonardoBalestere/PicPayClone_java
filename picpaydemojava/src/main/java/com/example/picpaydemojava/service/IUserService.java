package com.example.picpaydemojava.service;

import java.util.List;

import com.example.picpaydemojava.dto.UserDTO;
import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.model.User;

public interface IUserService {

	User consultEntity(String login);

	void validate(User... users);

	void attBalance(Transaction transaction, Boolean isCreditCard);

	List<UserDTO> list(String login);

	UserDTO consult(String login);

}
