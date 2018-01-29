package com.example.demo.jpa.springdata.dto;

import java.util.List;

public class SalaDTO {

	private Integer id;
	private String numero;
	private Integer id_clinica;
	private List<Integer> consultas;
	
	//Constructores
	
	public SalaDTO() {}
	public SalaDTO(Integer id, String numero, Integer clinica, List<Integer> consultas)
	{
		this.id = id;
		this.numero = numero;
		this.id_clinica = clinica;
		this.consultas = consultas;
	}
	
	//Getter y Setter
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getId_clinica() {
		return id_clinica;
	}
	public void setId_clinica(Integer id_clinica) {
		this.id_clinica = id_clinica;
	}
	public List<Integer> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Integer> consultas) {
		this.consultas = consultas;
	}
	
	
	
}
