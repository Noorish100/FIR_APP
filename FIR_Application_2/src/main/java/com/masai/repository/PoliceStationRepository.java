package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.PoliceStation;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Integer>{

}
