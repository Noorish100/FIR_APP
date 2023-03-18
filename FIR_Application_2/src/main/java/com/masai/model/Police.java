package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Police {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policeId;

	private String officerName;

	private String mobileNo;

	private String department;

	@OneToMany(cascade = CascadeType.ALL)
	List<Fir> firsFiled = new ArrayList<>();
	
	

	@OneToMany(cascade = CascadeType.ALL)
	List<Fir> casesClosed = new ArrayList<>();
}
