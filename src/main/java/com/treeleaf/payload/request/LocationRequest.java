package com.treeleaf.payload.request;

import java.util.List;

public class LocationRequest {
	
	private String name;
	
	private List<String> camara;
	
	public LocationRequest() {}
	
	public LocationRequest(String name,List<String> camara) {
		this.name = name;
		this.camara = camara;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCamara() {
		return camara;
	}

	public void setCamara(List<String> camara) {
		this.camara = camara;
	}
	
}
