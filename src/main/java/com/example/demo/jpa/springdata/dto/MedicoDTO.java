package com.example.demo.jpa.springdata.dto;

import java.util.List;

import lombok.Data;


@Data
public class MedicoDTO {
	
	private Integer idInterno;
	private String id;
	private String name;
	private double price;
	private List<Integer> consultas;
	
	// Constructores 
	
	public MedicoDTO() {}
	public MedicoDTO(String i, String n,double p, List<Integer> con)
	{
		this.id = i;
		this.name = n;
		this.price = p;
		this.consultas = con;
	}
	
	//Getter y Setter
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Integer> consultas) {
		this.consultas = consultas;
	}

	public Integer getIdInterno() {
		return idInterno;
	}
	public void setIdInterno(Integer idInterno) {
		this.idInterno = idInterno;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
