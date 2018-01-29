package com.example.demo.jpa.springdata.service;

import java.util.List;

import com.example.demo.jpa.springdata.dto.PacienteDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.model.Paciente;

public interface PacienteService {
	PacienteDTO transform(Paciente p);
	
	Paciente transform(PacienteDTO p);
		
	public List<PacienteDTO> findAll();
	
	public PacienteDTO findById(Integer idPaciente);
	
	public PacienteDTO create(PacienteDTO p);
	
	public void update(PacienteDTO m, Integer idPaciente);
	
	public void delete(Integer idPaciente);
	
	public void modificarPaciente(Paciente origen, Paciente nuevo);

}
