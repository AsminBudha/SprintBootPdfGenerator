package com.treeleaf.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.treeleaf.payload.request.LocationRequest;

public interface ILocationService {
	
	ResponseEntity<?> saveLocation(List <LocationRequest> Request);
}
