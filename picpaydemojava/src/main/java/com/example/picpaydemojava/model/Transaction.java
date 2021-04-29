package com.example.picpaydemojava.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "TRANSACTION")

public class Transaction extends BaseEntity implements Serializable{

	@Column(name = "TR_CODE", nullable = false)
	private String code;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@Column(name = "TR_CODE", nullable = false)
	private User origin;
	
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)	
	@Column(name = "TR_CODE", nullable = false)
	private User destiny;
	
	@Column(name = "TR_CODE", nullable = false)
	private LocalDateTime datatime;
	
	@Column(name = "TR_CODE", nullable = false)
	private Double value;
	
}
