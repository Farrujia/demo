package com.example.demo.jpa.springdata.service;

import java.util.List;

import com.example.demo.jpa.springdata.dto.ConsultaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.model.Consulta;

public interface ConsultaService {
	ConsultaDTO transform(Consulta c);
	
	Consulta transform(ConsultaDTO c);
		
	public List<ConsultaDTO> findAll();
	
	public ConsultaDTO findById(Integer idConsulta);
	
	public ConsultaDTO create(ConsultaDTO c);
	
	public void update(ConsultaDTO m, Integer idConsulta);
	
	public void delete(Integer idConsulta);
	
	public void modificarConsulta(Consulta origen, Consulta nuevo);

}
