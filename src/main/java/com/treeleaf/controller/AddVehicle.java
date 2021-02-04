package com.treeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treeleaf.payload.request.VehicleRequest;
import com.treeleaf.services.IVehicleService;

@RestController
@RequestMapping("/api")
public class AddVehicle {
	
	@Autowired
	IVehicleService vehicleService;
	
	@PostMapping("/addvehicle")
	@PreAuthorize("hasRole('ADMIN')")
	ResponseEntity<?> addVehicle(@RequestBody VehicleRequest vechileRequest){
		return vehicleService.add(vechileRequest);
	}
}
