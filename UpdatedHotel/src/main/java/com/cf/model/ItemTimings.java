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

@Entity(name ="Itemtimings")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemTimings extends Auditable<String>
{
	@Id


@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="oracle3")
@SequenceGenerator(name = "oracle3", sequenceName= " itemtimings_sequence" ,allocationSize= 1)
	private Integer timingId;
	@NotBlank(message = "categories is mandatory")
	@Pattern(regexp = "^[A-Za-z]{2,20}+$",message ="categories should be in charcters only")
	private String categories;
	
}
