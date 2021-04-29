package com.example.picpaydemojava.enums;

public enum CardFlag {

	VISA("Visa"),
	MASTERCARD("Master Card"),
	ELO("Elo");
	
	private String description;
	
	CardFlag(String description){
		this.description = description;
	}
	
	public String getDescritpion() {
		return description;
	}
}