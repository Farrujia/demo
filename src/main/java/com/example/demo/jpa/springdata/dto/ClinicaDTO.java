package com.example.demo.jpa.springdata.dto;

import java.util.List;

public class ClinicaDTO {

	
	private Integer id;
	private String name;
	private String address;
	private List<Integer> salas;
	
	//Constructores
	
	public ClinicaDTO() {}
	public ClinicaDTO(String n, String a, List<Integer> s)
	{
		this.name = n;
		this.address = a;
		this.salas = s;
	}
	
	//Getter y Setter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String a) {
		this.address = a;
	}

	public String getAddress() {
		return address;
	}
	public List<Integer> getSalas() {
		return salas;
	}
	public void setSalas(List<Integer> salas) {
		this.salas = salas;
	}
}
