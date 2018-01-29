package com.example.demo.jpa.springdata.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.springdata.dao.ClinicaDao;
import com.example.demo.jpa.springdata.dto.ClinicaDTO;
import com.example.demo.jpa.springdata.model.Clinica;
import com.example.demo.jpa.springdata.model.Sala;
import com.example.demo.jpa.springdata.service.ClinicaService;
import com.example.demo.jpa.springdata.service.SalaService;

@Service
public class ClinicaServiceImpl implements ClinicaService{
	
	@Autowired
	private ClinicaDao clinicadao;

	@Autowired
	private SalaService serviciosala;
	
	@Override
	public ClinicaDTO transform(Clinica c)
	{
		ClinicaDTO mDTO = new ClinicaDTO();
		mDTO.setId(c.getId());
		mDTO.setName(c.getName());
		mDTO.setAddress(c.getAddress());
		c.getSalas().forEach(sala -> {mDTO.getSalas().add(sala.getId());});
		return mDTO;
	}
	
	@Override	
	public Clinica transform(ClinicaDTO cDTO)
	{
		Clinica c;
		if(cDTO.getId()!=null && clinicadao.exists(cDTO.getId()))
			c = clinicadao.findOne(cDTO.getId());
		else
			c = new Clinica();
		c.setName(cDTO.getName());
		c.setAddress(cDTO.getAddress());
		List<Sala> sal = new ArrayList<>();
			cDTO.getSalas().forEach(sala -> sal.add(serviciosala.transform(serviciosala.findById(sala))));
		c.setSalas(sal);
		return c;
	}
	
	@Override	
	public List<ClinicaDTO> findAll()
	{
		final Iterable<Clinica> findAll = clinicadao.findAll();
		final List<ClinicaDTO> res = new ArrayList<>();
		findAll.forEach(
			c -> {final ClinicaDTO cDTO = transform(c);
			res.add(cDTO);
		});
		return res;
	}
	
	@Override
	public ClinicaDTO findById(Integer id) {
		final Clinica c = clinicadao.findOne(id);
		return transform(c);
	}
	
	@Override
	public ClinicaDTO create(ClinicaDTO clinicaDTO){
		final Clinica c = transform(clinicaDTO);
		return transform(clinicadao.save(c));
	}
	
	
	@Override
	public void update(ClinicaDTO clinicaDTO, Integer idClinica){
		final Clinica c = transform(clinicaDTO);
		final Clinica origin = clinicadao.findOne(idClinica);
		modificarClinica(origin,c);
		clinicadao.save(origin);
	}
	
	@Override
	public void delete(Integer idclinica)// throws ClinicaNotFoundException
	{
		clinicadao.delete(idclinica);
	}

	@Override
	public void modificarClinica(Clinica origen, Clinica nuevo)
	{
		if(!nuevo.getName().equals(null))
			origen.setName(nuevo.getName());
		if(!nuevo.getAddress().equals(null))
			origen.setAddress(nuevo.getAddress());	
		
	}
}
