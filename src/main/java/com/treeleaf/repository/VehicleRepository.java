package com.treeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treeleaf.models.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{
	
	boolean existsById(Long id);
	
}
