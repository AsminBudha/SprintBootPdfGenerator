package com.treeleaf.payload.response;

import java.util.List;

public class VehicleDetailsResponse {
	
	private String vehicleNumber;
	
	private List<LocationDetailsResponse> locationDetails;
	
	private String status;
	
	public VehicleDetailsResponse() {}
	
	public VehicleDetailsResponse(String number, List<LocationDetailsResponse> locationDetails, String status) {
		this.vehicleNumber = number;
		this.locationDetails = locationDetails;
		this.status = status;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public List<LocationDetailsResponse> getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(List<LocationDetailsResponse> locationDetails) {
		this.locationDetails = locationDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
