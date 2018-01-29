package com.example.demo.jpa.springdata.service;

import java.util.List;

import com.example.demo.jpa.springdata.dto.CitaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.model.Cita;


public interface CitaService {
	
	CitaDTO transform(Cita c);
	
	Cita transform(CitaDTO c);
		
	public List<CitaDTO> findAll();
	
	public CitaDTO findById(Integer idCita);

	
	public CitaDTO create(CitaDTO c);
	
	public void update(CitaDTO c, Integer idCita);
	
	
	public void delete(Integer idCita);
	
	public void modificarCita(Cita origen, Cita nuevo);

}
