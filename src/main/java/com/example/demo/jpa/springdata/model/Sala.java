package com.example.demo.jpa.springdata.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity 
public class Sala {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique = true)
	private String numero;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Clinica clinica;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_sala")
	private	List<Consulta> consultas = new ArrayList<>();

	
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

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica id_clinica) {
		this.clinica = id_clinica;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
	
}
