package com.cf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Rooms")
@Getter
@Setter
@ToString
@NoArgsConstructor
//@JsonIgnoreProperties(value = { "roomNumber"})
public class Rooms extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle2")
	@SequenceGenerator(name = "oracle2", sequenceName= " rooms_sequence1" ,allocationSize= 1)
	private Integer roomId;
	private Integer roomNumber;
	@NotBlank(message = "roomType is mandatory")
//	@Pattern(regexp = "^[A-Za-z]{2,20}+$",message ="room type should be in charcters only")
	private String roomType;
	private Integer numberOfBeds;
	private Double roomCharges;
	private String status;
	
}
