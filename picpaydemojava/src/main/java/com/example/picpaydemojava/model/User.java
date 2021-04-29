package com.example.picpaydemojava.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
	
	@Column(name = "USU_LOGIN", nullable = false)
	private String login;
	
	@Column(name = "USU_PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "USU_EMAIL", nullable = false)
	private String email;
	
	@Column(name = "USU_FULL_NAME", nullable = false)
	private String fullName;
	
	@Column(name = "USU_CPF", nullable = false)
	private String CPF;
	
	@Column(name = "USU_BIRTH_DATE", nullable = false)
	private String birthDate;

	@Column(name = "USU_CELLPHONE_NUMBER", nullable = false)
	private String cellphonenumber;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
	private List<CreditCard> creditCard;
	
	@Column(name = "USU_BALANCE", nullable = false)
	private String balance;
	
	@Column(name = "USU_ATIVE", nullable = false)
	private String ative;
	
}