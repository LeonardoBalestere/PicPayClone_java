package com.example.picpaydemojava.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UserDTO {

	@NotBlank
	private String login;
	
	private String password;
	
	private String email;
	
	private String fullName;
	
	private String cpf;
	
	private LocalDate birthDate;
	
	private String cellPhoneNumber;
	
	private Double balance;
}
