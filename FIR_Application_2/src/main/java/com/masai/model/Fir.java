package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fir {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int firId;

	private String crimeDetail;

	private LocalDateTime timeStamp;

	@ManyToOne
	private User applicant;

	@OneToOne
	private Police officer;
	
	private Boolean isOpen;

	@OneToMany
	private List<User> criminals = new ArrayList<>();

	@ManyToOne
	private PoliceStation policeStation;

}
