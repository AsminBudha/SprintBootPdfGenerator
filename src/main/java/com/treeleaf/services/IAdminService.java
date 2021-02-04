package com.treeleaf.services;

import com.treeleaf.payload.response.VehicleDetailsResponse;

public interface IAdminService {
	
	VehicleDetailsResponse getDetails(Long id);
	
}
