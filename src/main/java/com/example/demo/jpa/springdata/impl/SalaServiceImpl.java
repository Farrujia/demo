package com.example.demo.jpa.springdata.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.springdata.dao.SalaDao;
import com.example.demo.jpa.springdata.dto.ClinicaDTO;
import com.example.demo.jpa.springdata.dto.SalaDTO;
import com.example.demo.jpa.springdata.model.Consulta;
import com.example.demo.jpa.springdata.model.Sala;
import com.example.demo.jpa.springdata.service.ClinicaService;
import com.example.demo.jpa.springdata.service.ConsultaService;
import com.example.demo.jpa.springdata.service.SalaService;

@Service
public class SalaServiceImpl implements SalaService{
	
	@Autowired
	private SalaDao saladao;

	@Autowired
	private ClinicaService servicioclinica;
	
	@Autowired
	private ConsultaService servicioconsulta;
	
	@Override
	public SalaDTO transform(Sala s)
	{
		SalaDTO sDTO = new SalaDTO();
		sDTO.setId(s.getId());
		sDTO.setNumero(s.getNumero());
		sDTO.setId_clinica(s.getClinica().getId());
		
		s.getConsultas().forEach(
			consulta -> {sDTO.getConsultas().add(consulta.getId());
		});
		return sDTO;
	}
	
	@Override	
	public Sala transform(SalaDTO sDTO)
	{
		Sala s;
		if(sDTO.getId()!=null && saladao.exists(sDTO.getId()))
			s = saladao.findOne(sDTO.getId());
		else
			s = new Sala();
		s.setNumero(sDTO.getNumero());
		s.setClinica(servicioclinica.transform(servicioclinica.findById(sDTO.getId_clinica())));
		servicioclinica.transform(servicioclinica.findById(sDTO.getId_clinica())).getSalas();
		List<Consulta> consul = new ArrayList<Consulta>();		
		sDTO.getConsultas().forEach(
				consultas -> {consul.add(servicioconsulta.transform(servicioconsulta.findById(sDTO.getId())));
					servicioconsulta.transform(servicioconsulta.findById(sDTO.getId())).setId_sala(s);
			});
		s.setConsultas(consul);
		return s;
	}
	
	@Override	
	public List<SalaDTO> findAll()
	{
		final Iterable<Sala> findAll = saladao.findAll();
		final List<SalaDTO> res = new ArrayList<>();
		findAll.forEach(
			s -> {final SalaDTO sDTO = transform(s);
			res.add(sDTO);
		});
		return res;
	}
	
	@Override
	public SalaDTO findById(Integer id) {
		final Sala s = saladao.findOne(id);
		return transform(s);
	}
	
	@Override
	public SalaDTO create(SalaDTO salaDTO){
		final Sala s = transform(salaDTO);
		return transform(saladao.save(s));
	}
	
	@Override
	public void update(SalaDTO salaDTO, Integer idSala){
		final Sala s = transform(salaDTO);
		final Sala origin = saladao.findOne(idSala);
		modificarSala(origin,s);
		saladao.save(s);
	}
	
	@Override
	public void delete(Integer idSala)// throws ClinicaNotFoundException
	{
		saladao.delete(idSala);
	}

	@Override
	public void modificarSala(Sala origen, Sala nuevo)
	{
		nuevo.setId(origen.getId());		
	}

}
