package com.treeleaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.treeleaf.models.Camara;
import com.treeleaf.models.Location;
import com.treeleaf.payload.request.LocationRequest;
import com.treeleaf.payload.response.MessageResponse;
import com.treeleaf.repository.CamaraRepository;
import com.treeleaf.repository.LocationRepository;

@Service
public class LocationService implements ILocationService{

	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	CamaraRepository camaraRepository;
	
	@Override
	public ResponseEntity<?> saveLocation(List<LocationRequest> Request) {
		
		for(LocationRequest locationRequest: Request) {
			Location location = new Location(locationRequest.getName());
			locationRepository.save(location);
			
			for(String name : locationRequest.getCamara()) {
				Camara camara = new Camara(name,location);
				camaraRepository.save(camara);
			}
		}
		return ResponseEntity.ok(new MessageResponse("location added successfully"));
	}

}
