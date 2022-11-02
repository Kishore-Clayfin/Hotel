package com.cf.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name ="Foodcategory")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FoodCategory  extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle5")
	@SequenceGenerator(name = "oracle5", sequenceName= " foodcategory_sequence " ,allocationSize= 1)
	private Integer itemId;
	@NotBlank(message = "Item Name is mandatory")
//	@Pattern(regexp = "^[A-Za-z]{4,20}+$",message ="Name should be in charcters only")
	private String itemName;
//	@NotBlank(message = "Item price is mandatory")
//	@Pattern(regexp = "^[0-9]+$",message ="Price should accept only numbers")
	private Double itemPrice;
	
	@OneToOne
	private ItemCategory itemCategory;
	@ManyToMany
	private List<ItemTimings> itemTimings;

	
}
