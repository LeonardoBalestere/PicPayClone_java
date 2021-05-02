package com.example.picpaydemojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.picpaydemojava.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByLogin(String login);
	
	@Modifying
	@Query("update User u set u.balance = u.balance - ?2 where u.login = ?1")
	void  updateIncreaseBalance(String login, Double value);
	
	@Modifying
	@Query("update User u set u.balance = u.balance - ?2 where u.login = ?1")
	void  updateDecreaseBalance(String login, Double value);
}