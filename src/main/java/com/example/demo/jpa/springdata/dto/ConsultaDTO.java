package com.example.demo.jpa.springdata.dto;

import java.util.List;

public class ConsultaDTO {

	private Integer id;
	private Integer id_medico;
	private Integer id_sala;
	private String turno;
	private List<Integer> citas;
	
	// Constructores 
	
	public ConsultaDTO() {}
	public ConsultaDTO(Integer n, Integer m, Integer s, String t, List<Integer> c)
	{
		this.id = n;
		this.id_medico = m;
		this.id_sala = s;
		this.turno = t;
		this.citas = c;
	}
	
	//Getter y Setter
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_medico() {
		return id_medico;
	}
	public void setId_medico(Integer id_medico) {
		this.id_medico = id_medico;
	}
	public Integer getId_sala() {
		return id_sala;
	}
	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public List<Integer> getCitas() {
		return citas;
	}
	public void setCitas(List<Integer> citas) {
		this.citas = citas;
	}
	
}
