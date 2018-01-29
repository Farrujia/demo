package com.example.demo.jpa.springdata.service;

import java.util.List;

import com.example.demo.jpa.springdata.dto.MedicoDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.model.Medico;


public interface MedicoService {

	MedicoDTO transform(Medico m);
		
	Medico transform(MedicoDTO m);
		
	public List<MedicoDTO> findAll();
	
	public MedicoDTO findById(Integer idMedico);

	//public List<MedicoDTO> findByName(String name);
	
	public MedicoDTO create(MedicoDTO m);
	
	public void update(MedicoDTO m, Integer idMedico);
	
	
	public void delete(Integer idMedico);
	
	public void modificarMedico(Medico origen, Medico nuevo);
	/*{
		medicoDao.delete(idMedico)
	}*/
}
	

	