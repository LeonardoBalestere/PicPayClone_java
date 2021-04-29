package com.example.picpaydemojava.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class TransactionDTO {

	@NotBlank
	private String code;
	
	@NotNull
	private UserDTO origin;
	
	@NotNull
	private UserDTO destiny;
	
	@NotNull
	private LocalDateTime dateTime;
	
	@NotNull
	private Double value;
	
	private CreditCardDTO creditCard;
	
	private Boolean isCreditCard = false;
}
