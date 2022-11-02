package com.cf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle6")
	@SequenceGenerator(name = "oracle6", sequenceName= " Employee_sequence " ,allocationSize= 1)
	private Integer employeeId;
	@NotBlank(message = "Name is mandatory")
//	@Pattern(regexp = "^[A-Za-z]{4,20}+$",message ="Name should be in charcters only ")
	private String name;
//	@Pattern(regexp = "^[0-9]+$",message ="salary should be in numbers")
	private Double salary;
//	@Pattern(regexp = "^[+]91[6789]\\d{9}$",message ="mobile number should be in 10digit")
	private String mobileNumber;
	@Email(message = "Invalid email address")
	private String email;
	
	@OneToOne
	private Department department;
	
}
