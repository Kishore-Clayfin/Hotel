package com.cf.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Payment
{
	@Id
	private Integer paymentId;
	private Double amount;
	private String modeOfPayment;
}
