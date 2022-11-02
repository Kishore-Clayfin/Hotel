package com.cf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Department")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Department extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle8")
	@SequenceGenerator(name = "oracle8", sequenceName= " department_sequence" ,allocationSize= 1)
	private Integer departmentId;
	@NotBlank(message = "Department name is mandatory")
	@Pattern(regexp = "^[A-Za-z]{4,20}+$",message ="Department Name  will accept only Characters")
	private String departmentName;
	
}
