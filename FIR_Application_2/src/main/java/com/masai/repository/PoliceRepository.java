package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Police;

@Repository
public interface PoliceRepository extends JpaRepository<Police, Integer>{

}
