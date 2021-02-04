package com.treeleaf.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="location")
	Set<Camara> camara = new HashSet<>();
	
	public Location() {}
	
	public Location(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Camara> getCamara() {
		return camara;
	}

	public void setCamara(Set<Camara> camara) {
		this.camara = camara;
	}
	
}
