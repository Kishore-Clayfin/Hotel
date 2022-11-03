package com.cf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Hotel")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Hotel extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle7")
	@SequenceGenerator(name = "oracle7", sequenceName= " hotel_sequence" ,allocationSize= 1)
	private Integer hotelId;
	@NotBlank(message = "Name is mandatory")
	@Pattern(regexp = "^[A-Za-z\\s]{2,20}+$",message ="Name should be in charcters only ")
	private String name;
	@NotBlank(message = "Open Timing is mandatory")
	private String openTiming;
	@NotBlank(message = "Close Timing  is mandatory")
	private String closeTiming;
	@NotBlank(message = "classification is mandatory")
	@Pattern(regexp = "^[A-Za-z0-9\\s]{2,20}+$",message ="classification should be in charcters And numbers only ")
	private String classification;
	@NotBlank(message = "contactNumber is mandatory")
	private String contactNumber;
	@NotBlank(message = "streetName is mandatory")
//	@Pattern(regexp = "^[A-Za-z\\s]{2,20}+$",message ="streetName should be in charcters only ")
	private String streetName;
	@NotBlank(message = "area is mandatory")
	@Pattern(regexp = "^[A-Za-z\\s]{2,20}+$",message ="area should be in charcters only ")
	private String area;
	@NotBlank(message = "city is mandatory")
	@Pattern(regexp = "^[A-Za-z\\s]{2,20}+$",message ="city should be in charcters only ")
	private String city;
	@NotBlank(message = "state is mandatory")
	@Pattern(regexp = "^[A-Za-z\\s]{2,20}+$",message ="state should be in charcters only ")
	private String state;
	private Integer pincode;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Rooms> rooms;
	@OneToMany
	private List<Employee> employee;
	@ManyToMany
	private List<FoodCategory> foodCategory;

}
