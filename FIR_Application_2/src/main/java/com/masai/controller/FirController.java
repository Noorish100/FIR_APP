package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Fir;
import com.masai.services.FirService;

@RestController
@RequestMapping("/masaifir")
public class FirController {

	
	@Autowired
	private FirService firService;
	
	@PostMapping("/user/fir")
	public ResponseEntity<Fir> registerFir(@RequestBody Fir fir){
		
		Fir f1 = firService.createFir(fir);
		
		return new ResponseEntity<>(f1,HttpStatus.ACCEPTED);
	}
}
