package com.treeleaf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treeleaf.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long>{
	
	boolean existsByName(String name);
	
	Optional<Location> findByName(String username);
}

