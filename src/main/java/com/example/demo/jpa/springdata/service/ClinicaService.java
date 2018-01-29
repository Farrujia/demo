package com.example.demo.jpa.springdata.service;

import java.util.List;

import com.example.demo.jpa.springdata.dto.ClinicaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.model.Clinica;

public interface ClinicaService {

	ClinicaDTO transform(Clinica c);
	
	Clinica transform(ClinicaDTO c);
		
	public List<ClinicaDTO> findAll();
	
	public ClinicaDTO findById(Integer idClinica);
	
	public ClinicaDTO create(ClinicaDTO c);
	
	public void update(ClinicaDTO m, Integer idClinica);
	
	public void delete(Integer idClinica);
	
	public void modificarClinica(Clinica origen, Clinica nuevo);

	
	
	
	
	
}
