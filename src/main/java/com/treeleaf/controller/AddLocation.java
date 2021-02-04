package com.treeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treeleaf.payload.request.LocationRequest;
import com.treeleaf.services.ILocationService;

@RestController
@RequestMapping("/api")
public class AddLocation {
	
	@Autowired
	ILocationService locationServiec;
	
	@PostMapping("/addlocation")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addLocation(@RequestBody List<LocationRequest> locationRequest){
		return locationServiec.saveLocation(locationRequest);
	}
}
