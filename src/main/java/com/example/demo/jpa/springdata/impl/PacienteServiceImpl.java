package com.example.demo.jpa.springdata.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.springdata.dao.PacienteDao;
import com.example.demo.jpa.springdata.dto.PacienteDTO;
import com.example.demo.jpa.springdata.model.Cita;
import com.example.demo.jpa.springdata.model.Paciente;
import com.example.demo.jpa.springdata.service.CitaService;
import com.example.demo.jpa.springdata.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	private PacienteDao pacientedao;
	
	@Autowired
	private CitaService serviciocita;
	
	@Override
	public PacienteDTO transform(Paciente p)
	{
		PacienteDTO pDTO = new PacienteDTO();
		pDTO.setId(p.getId());
		pDTO.setName(p.getName());
		p.getCitas().forEach(
				cita -> {pDTO.getCitas().add(cita.getId());
		});
		return pDTO;
	}
	
	@Override	
	public Paciente transform(PacienteDTO pDTO)
	{
		Paciente p;
		if(pDTO.getId()!=null && pacientedao.exists(pDTO.getId()))
			p = pacientedao.findOne(pDTO.getId());
		else
			p = new Paciente();
		p.setName(pDTO.getName());
		List<Cita> cit = new ArrayList<>();
		pDTO.getCitas().forEach(
				cita -> cit.add(serviciocita.transform(serviciocita.findById(cita))));
		p.setCitas(cit);
		return p;
	}
	
	@Override	
	public List<PacienteDTO> findAll()
	{
		final Iterable<Paciente> findAll = pacientedao.findAll();
		final List<PacienteDTO> res = new ArrayList<>();
		findAll.forEach(
			p -> {final PacienteDTO pDTO = transform(p);
			res.add(pDTO);
		});
		return res;
	}
	
	@Override
	public PacienteDTO findById(Integer id) {
		final Paciente p = pacientedao.findOne(id);
		return transform(p);
	}
	
	@Override
	public PacienteDTO create(PacienteDTO pacienteDTO) {
		final Paciente c = transform(pacienteDTO);
		return transform(pacientedao.save(c));
	}
	
	@Override
	public void update(PacienteDTO pacienteDTO, Integer idPaciente) {
		final Paciente p = transform(pacienteDTO);
		final Paciente origin = pacientedao.findOne(idPaciente);
		modificarPaciente(origin,p);
		pacientedao.save(p);
	}
	
	@Override
	public void delete(Integer idPaciente)
	{
		pacientedao.delete(idPaciente);
	}

	@Override
	public void modificarPaciente(Paciente origen, Paciente nuevo)
	{
		nuevo.setId(origen.getId());		
	}

}
