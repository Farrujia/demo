package com.example.demo.jpa.springdata.dto;

import java.util.List;

public class PacienteDTO {

	private Integer id;
	
	private String name;
	
	private List<Integer> citas;

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

	public List<Integer> getCitas() {
		return citas;
	}

	public void setCitas(List<Integer> citas) {
		this.citas = citas;
	}

}
