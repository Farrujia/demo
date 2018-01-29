package com.example.demo.jpa.springdata.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Cita {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente id_paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Consulta id_consulta;

	//Getters y setters
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Paciente getId_paciente() {
		return id_paciente;
	}
	
	public void setId_paciente(Paciente id_paciente) {
		this.id_paciente = id_paciente;
	}
	
	public Consulta getId_consulta() {
		return id_consulta;
	}
	
	public void setId_consulta(Consulta id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
