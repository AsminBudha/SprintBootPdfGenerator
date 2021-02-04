package com.treeleaf.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "vechile",uniqueConstraints= {@UniqueConstraint(columnNames="vechile_number")})
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="vechile_number")
	@NotBlank
	private String vehicleNumber;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "vehicle_location", 
				joinColumns = @JoinColumn(name = "vechile_id"), 
				inverseJoinColumns = @JoinColumn(name = "location_id"))
	private Set<Location> location = new HashSet<>();
	
	public Vehicle() {}
	
	public Vehicle(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}
	
}

