package com.example.picpaydemojava.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.picpaydemojava.enums.CardFlag;

import lombok.Data;

@Data
public class CreditCardDTO {

	@NotBlank
	private CardFlag flag;
	
	@NotBlank
	private String securityCode;
	
	@NotBlank
	private String expirationData;
	
	@NotBlank
	private String cardHolderName;
	
	private String number;
	
	private String numberToken;
	
	@NotNull
	private UserDTO user;
	
	private Boolean isSave = false;
}
