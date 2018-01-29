package com.example.demo.jpa.springdata.service;

import java.util.List;

import com.example.demo.jpa.springdata.dto.SalaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.model.Sala;

public interface SalaService {
	
	SalaDTO transform(Sala s);
	
	Sala transform(SalaDTO s);
		
	public List<SalaDTO> findAll();
	
	public SalaDTO findById(Integer idSala);
	
	public SalaDTO create(SalaDTO s);
	
	public void update(SalaDTO m, Integer idSala);
	
	public void delete(Integer idSala);// throws MedicoNotFoundException;
	
	public void modificarSala(Sala origen, Sala nuevo);

}
