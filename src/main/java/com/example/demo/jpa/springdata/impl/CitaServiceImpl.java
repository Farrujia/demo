package com.example.demo.jpa.springdata.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.springdata.dao.CitaDao;
import com.example.demo.jpa.springdata.dto.CitaDTO;
import com.example.demo.jpa.springdata.model.Cita;
import com.example.demo.jpa.springdata.service.CitaService;
import com.example.demo.jpa.springdata.service.ConsultaService;
import com.example.demo.jpa.springdata.service.PacienteService;

@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaDao citadao;
	@Autowired
	private PacienteService serviciopaciente;
	@Autowired
	private ConsultaService servicioconsulta;

	@Override
	public CitaDTO transform(Cita c)
	{
		CitaDTO cDTO = new CitaDTO();
		cDTO.setId(c.getId());
		cDTO.setFecha(c.getFecha());
		cDTO.setId_consulta(c.getId_consulta().getId());
		cDTO.setId_paciente(c.getId_paciente().getId());
		return cDTO;
	}
	
	@Override	
	public Cita transform(CitaDTO cDTO)
	{
		Cita c;
		if(cDTO.getId()!=null && citadao.exists(cDTO.getId()))
			c = citadao.findOne(cDTO.getId());
		else
			c = new Cita();
		c.setFecha(cDTO.getFecha());
		c.setId_consulta(servicioconsulta.transform(servicioconsulta.findById(cDTO.getId_consulta())));
		c.setId_paciente(serviciopaciente.transform(serviciopaciente.findById(cDTO.getId_paciente())));
		
		return c;
	}
	
	@Override	
	public List<CitaDTO> findAll()
	{
		final Iterable<Cita> findAll = citadao.findAll();
		final List<CitaDTO> res = new ArrayList<>();
		findAll.forEach(
			c -> {final CitaDTO cDTO = transform(c);
			res.add(cDTO);
		});
		return res;
	}
	
	@Override
	public CitaDTO findById(Integer id){
		final Cita c = citadao.findOne(id);
		return transform(c);
	}
	
	@Override
	public CitaDTO create(CitaDTO citaDTO){
		final Cita c = transform(citaDTO);
		return transform(citadao.save(c));
	}
	
	@Override
	public void update(CitaDTO citaDTO, Integer idCita){
		final Cita c = transform(citaDTO);
		final Cita origin = citadao.findOne(idCita);
		modificarCita(origin,c);
		citadao.save(c);
	}
	
	@Override
	public void delete(Integer idCita)
	{
		citadao.delete(idCita);
	}

	@Override
	public void modificarCita(Cita origen, Cita nuevo)
	{
		nuevo.setId(origen.getId());		
	}

}
