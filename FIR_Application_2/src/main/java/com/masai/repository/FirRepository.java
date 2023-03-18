package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Fir;

@Repository
public interface FirRepository extends JpaRepository<Fir, Integer>{

}
