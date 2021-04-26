package com.example.picpaydemojava.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
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
@Table(name = "Users")

public class CreditCard extends BaseEntity {

	@Column(name = "CC_NUMBER", nullable = false)
	private String number;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "CC+FLAG", nullable = false)
	private CardFlag flag;
	
	@Column(name = "CC_TOKEN", nullable = false)
	private String tokenNumber;
	
	@ManyToOne(cascade = { CascadeType.MERGE})
	@Column(name = "CC_USER_ID", nullable = false)
	private User user;
}