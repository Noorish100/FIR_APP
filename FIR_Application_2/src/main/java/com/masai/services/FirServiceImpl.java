package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.model.Fir;
import com.masai.repository.FirRepository;

@Service
public class FirServiceImpl implements FirService {

	@Autowired
	private FirRepository firRepository;

	@Override
	public Fir createFir(Fir fir) {

		return firRepository.save(fir);
	}

}
