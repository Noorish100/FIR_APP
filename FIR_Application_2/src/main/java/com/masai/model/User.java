package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Pattern(regexp = "^[a-zA-Z]$", message = "No Special Characters Allowed.")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]$", message = "No Special Characters Allowed.")
	private String lastName;
	@Size(min = 10, max = 10, message = "mobile number should be 10 digit")
	private String mobileNumber;
	private String address;
	@Size(min = 12)
	private Integer age;
	private String gender;
	@NotNull(message = "user password should not be null")
	@Size(min = 3, max = 10, message = "length of username must be between 3 & 10")
	@Pattern(regexp = "/^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[^a-zA-Z0-9])(?!.*\\s).{6,12}$/")
	private String password;

	@OneToMany
	private List<Fir> firList = new ArrayList<>();

}
