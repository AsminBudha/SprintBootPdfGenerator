package com.treeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treeleaf.models.Camara;

@Repository
public interface CamaraRepository extends JpaRepository<Camara,Long>{

}
