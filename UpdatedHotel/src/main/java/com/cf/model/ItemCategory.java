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

@Entity(name ="Itemcategory")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemCategory extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle4")
	@SequenceGenerator(name = "oracle4", sequenceName= " itemcategory_sequence",allocationSize= 1)
	private Integer categoryId;
	@NotBlank(message = "categoryname is mandatory")
	@Pattern(regexp = "^[A-Za-z]{2,20}+$",message ="Name should be in charcters only")
	private String categoryname;
	@NotBlank(message = "categoryType is mandatory")
	@Pattern(regexp = "^[A-Za-z\\S]{2,20}+$",message ="Type should be in charcters only")
	private String categoryType;

}
