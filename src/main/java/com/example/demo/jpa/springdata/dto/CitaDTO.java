package com.example.demo.jpa.springdata.dto;

import java.util.Date;

public class CitaDTO {

	private Integer id;
	
	private Date Fecha;
	private Integer id_paciente;
	private Integer id_consulta;
	
	
	//Constructores
	
	public CitaDTO() {}
	public CitaDTO(Date fecha, Integer paciente, Integer consulta)
	{
		this.setFecha(fecha);
		this.id_paciente = paciente;
		this.id_consulta = consulta;
	}
	
	
	//Getter y Setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId_paciente() {
		return id_paciente;
	}
	
	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}
	
	public Integer getId_consulta() {
		return id_consulta;
	}
	
	public void setId_consulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
	}
	
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	
	
}
