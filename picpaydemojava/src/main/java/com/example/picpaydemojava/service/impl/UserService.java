package com.example.picpaydemojava.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.model.User;
import com.example.picpaydemojava.repository.UserRepository;
import com.example.picpaydemojava.service.IUserService;
import com.example.picpaydemojava.service.exceptions.ExceptionHandling;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User consultEntity(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public void validate(User... users) {
		Arrays.asList(users).stream().forEach(user ->{
			if(user == null) {
				throw new ExceptionHandling("User don't exist");
			}
		});
		
	}

	@Override
	public void attBalance(Transaction transaction, Boolean isCreditCard) {
		// TODO Auto-generated method stub
		
	}

}
