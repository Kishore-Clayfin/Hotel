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

@Entity(name ="HOTELUSERS")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends Auditable<String>
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oracle1")
	@SequenceGenerator(name = "oracle1", sequenceName = " USER_SEQUENCE", allocationSize = 1)
	private Integer userId;
	@NotBlank(message = "username is mandatory")
	private String username;
//	@NotBlank(message = "password is mandatory")
	private String password;
	@NotBlank(message = "role is mandatory")
	private String role;
	private Boolean enabled;
}
