package com.example.demo.jpa.springdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Clinica {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clinica")
	private List<Sala> salas = new ArrayList<Sala>();
	
	
	//Getter y Setter
	
	public Integer getId() {
		return id;
	}

	public void getId(Integer id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String adr) {
		this.address = adr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}
	
	
}
