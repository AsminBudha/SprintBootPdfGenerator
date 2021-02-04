package com.treeleaf.services;


import org.springframework.http.ResponseEntity;

import com.treeleaf.payload.request.VehicleRequest;

public interface IVehicleService {
	
	ResponseEntity<?> add(VehicleRequest vechileRequest);
}
