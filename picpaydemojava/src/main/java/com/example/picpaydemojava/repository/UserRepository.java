package com.example.picpaydemojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.picpaydemojava.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByLogin(String login);
}
