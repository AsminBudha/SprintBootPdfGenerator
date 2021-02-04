package com.treeleaf.payload.request;

import java.util.Set;

public class VehicleRequest {
	
	private String name;
    
    private Set<String> location;
    
    public VehicleRequest() {}
    
    public VehicleRequest(String name,Set<String> location) {
    	this.name = name;
    	this.location = location;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getLocation() {
		return location;
	}

	public void setLocation(Set<String> location) {
		this.location = location;
	}
    
}
