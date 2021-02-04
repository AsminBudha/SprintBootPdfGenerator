package com.treeleaf.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.treeleaf.models.Location;
import com.treeleaf.models.Vehicle;
import com.treeleaf.payload.request.VehicleRequest;
import com.treeleaf.payload.response.MessageResponse;
import com.treeleaf.repository.LocationRepository;
import com.treeleaf.repository.VehicleRepository;

@Service
public class VehicleService implements IVehicleService{

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Override
	public ResponseEntity<?> add(VehicleRequest vehicleRequest) {
		
		Vehicle vehicle = new Vehicle(vehicleRequest.getName());
		
		Set<Location> location = new HashSet<>();
		
		for(String s : vehicleRequest.getLocation()) {
			Location l = locationRepository.findByName(s)
					.orElseThrow(() -> new RuntimeException("Error: " + s + " location not found"));
			
			location.add(l);
		}
		
		vehicle.setLocation(location);
		vehicleRepository.save(vehicle);
		return ResponseEntity.ok(new MessageResponse("Vechile Successfully added"));
	}

}
