package com.treeleaf.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treeleaf.models.Camara;
import com.treeleaf.models.Location;
import com.treeleaf.models.Vehicle;
import com.treeleaf.payload.response.LocationDetailsResponse;
import com.treeleaf.payload.response.VehicleDetailsResponse;
import com.treeleaf.repository.CamaraRepository;
import com.treeleaf.repository.LocationRepository;
import com.treeleaf.repository.VehicleRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	CamaraRepository camaraRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public VehicleDetailsResponse getDetails(Long id) {
		
		if(!vehicleRepository.existsById(id))return new VehicleDetailsResponse(null,null,"NOT_FOUND");
		
		List<LocationDetailsResponse> locationDetails = new ArrayList<>();
		
		VehicleDetailsResponse vechileDetails = new VehicleDetailsResponse();
		
		Vehicle vehicle = vehicleRepository.getOne(id);
		vechileDetails.setVehicleNumber(vehicle.getVehicleNumber());
		
		for(Location l : vehicle.getLocation()) {
			LocationDetailsResponse ldr = new LocationDetailsResponse();
			ldr.setLocationName(l.getName());
			List<String> camaraDetails = new ArrayList<>();
			for(Camara c : l.getCamara()) {
				camaraDetails.add(c.getName());
			}
			ldr.setCamaraDetails(camaraDetails);
			locationDetails.add(ldr);
		}
		vechileDetails.setLocationDetails(locationDetails);
		vechileDetails.setStatus("success");
		return vechileDetails;
	}

}
