package com.cf.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Booking")
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle11")
	@SequenceGenerator(name = "oracle11", sequenceName= "BOOKING_SEQUENCE" ,allocationSize= 1)
	private Integer bookingId;
	private String modeOfPayment;
	
//	@FutureOrPresent(message = "Your are entering a past Date YYYY-MM-DD ")
//	@Temporal(TemporalType.DATE)//YYYY-MM-DD
	private LocalDate  bookingDate; 
	private LocalDate fromDate;
	private LocalDate toDate;
	
	@DecimalMin(value = "1.0", message = "Please Enter a valid  Amount")
	private Double amount;
	
	private String email;
	
	@OneToOne
	private Rooms rooms;
	
	
	@OneToOne
	private Hotel hotel;
	
	@ManyToOne
//	@JoinColumn(name = "userId")
	private User user;
	
}
