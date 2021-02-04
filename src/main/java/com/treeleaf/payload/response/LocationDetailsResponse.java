package com.treeleaf.payload.response;

import java.util.List;

public class LocationDetailsResponse {
	
	private String locationName;
	
	private List<String> camaraDetails;
	
	public LocationDetailsResponse() {}
	
	public LocationDetailsResponse(String locationName,List<String> camaraDetails) {
		this.locationName = locationName;
		this.camaraDetails = camaraDetails;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<String> getCamaraDetails() {
		return camaraDetails;
	}

	public void setCamaraDetails(List<String> camaraDetails) {
		this.camaraDetails = camaraDetails;
	}
	
}
