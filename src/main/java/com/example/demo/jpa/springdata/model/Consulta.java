package com.example.demo.jpa.springdata.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Consulta {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Medico id_medico;

	@ManyToOne
	private Sala id_sala;

	@Enumerated(EnumType.STRING)
	private Turno turno;
	
	/*@Temporal(value=TemporalType.DATE)
	private Date fecha;
*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_consulta")
	private List<Cita> citas = new ArrayList<>();
	
	
//Getter y Setter	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medico getId_medico() {
		return id_medico;
	}

	public void setId_medico(Medico id_medico) {
		this.id_medico = id_medico;
	}

	public Sala getId_sala() {
		return id_sala;
	}

	public void setId_sala(Sala id_sala) {
		this.id_sala = id_sala;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
}
