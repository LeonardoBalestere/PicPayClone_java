package com.example.picpaydemojava.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.picpaydemojava.converter.UserConverter;
import com.example.picpaydemojava.dto.UserDTO;
import com.example.picpaydemojava.exceptions.ExceptionHandling;
import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.model.User;
import com.example.picpaydemojava.repository.UserRepository;
import com.example.picpaydemojava.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;

	@Override
	public User consultEntity(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public void validate(User... users) {
		Arrays.asList(users).stream().forEach(user -> {
			if (user == null) {
				throw new ExceptionHandling("User don't exist");
			}
		});

	}

	@Override
	@Async("AsyncExecutor")
	public void attBalance(Transaction saveTransaction, Boolean isCreditCard) {
		decreaseBalance(saveTransaction, isCreditCard);
		increaseBalance(saveTransaction);
	}

	private void increaseBalance(Transaction saveTransaction) {
		userRepository.updateIncreaseBalance(saveTransaction.getOrigin().getLogin(), saveTransaction.getValue());
	}

	private void decreaseBalance(Transaction saveTransaction, Boolean isCreditCard) {
		if (!isCreditCard) {
			userRepository.updateDecreaseBalance(saveTransaction.getOrigin().getLogin(), saveTransaction.getValue());
		}
	}

	@Override
	public UserDTO consult(String login) {
		User user = consultEntity(login);
		return userConverter.convertEntityToDTO(user);
	}

	@Override
	public List<UserDTO> list(String login) {
		List<User> users = userRepository.findAll();
		List<User> usersFiltered = users.stream().filter(v -> !v.getLogin().equals(login)).collect(Collectors.toList());
		
		return userConverter.convertEntitiesToDTO(usersFiltered);
	}
}