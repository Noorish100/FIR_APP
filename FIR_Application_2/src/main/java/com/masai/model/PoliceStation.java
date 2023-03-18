package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PoliceStation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stationId;

	private String stationCode;

	private String address;
    
	@OneToOne
	Police officerInCharge ;
//	private Police officerInCharge;

	@OneToMany
	List<Police> constables = new ArrayList<>();
	
	@OneToMany
	List<Fir> firList = new ArrayList<>();

}
