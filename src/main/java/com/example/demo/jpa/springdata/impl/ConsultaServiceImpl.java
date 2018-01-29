package com.example.demo.jpa.springdata.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.springdata.dao.ConsultaDao;
import com.example.demo.jpa.springdata.dto.ConsultaDTO;
import com.example.demo.jpa.springdata.model.Cita;
import com.example.demo.jpa.springdata.model.Consulta;

import com.example.demo.jpa.springdata.service.CitaService;
import com.example.demo.jpa.springdata.service.ConsultaService;
import com.example.demo.jpa.springdata.service.MedicoService;
import com.example.demo.jpa.springdata.service.SalaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{
	
	@Autowired
	private ConsultaDao consultadao;
	
	@Autowired
	private MedicoService serviciomedico;
	
	@Autowired
	private SalaService serviciosala;
	
	@Autowired
	private CitaService serviciocita;
	
	@Override
	public ConsultaDTO transform(Consulta c)
	{
		ConsultaDTO cDTO = new ConsultaDTO();
		cDTO.setId(c.getId());
		cDTO.setId_medico(c.getId_medico().getId());
		cDTO.setId_sala(c.getId_sala().getId());
		cDTO.setTurno(c.getTurno().toString());
		c.getCitas().forEach(
				cita -> {cDTO.getCitas().add(cita.getId());
			});		
		return cDTO;
	}
	
	@Override	
	public Consulta transform(ConsultaDTO cDTO)
	{
		Consulta c;
		if(cDTO.getId()!=null && consultadao.exists(cDTO.getId()))
			c = consultadao.findOne(cDTO.getId());
		else
			c = new Consulta();
		c.setId_medico(serviciomedico.transform(serviciomedico.findById(cDTO.getId_medico())));;
		c.setId_sala(serviciosala.transform(serviciosala.findById(cDTO.getId_sala())));
		List<Cita> cit = new ArrayList<>();
		cDTO.getCitas().forEach(
				cita -> cit.add(serviciocita.transform(serviciocita.findById(cDTO.getId_sala()))));
		c.setCitas(cit);
		return c;
	}
	
	@Override	
	public List<ConsultaDTO> findAll()
	{
		final Iterable<Consulta> findAll = consultadao.findAll();
		final List<ConsultaDTO> res = new ArrayList<>();
		findAll.forEach(
			c -> {final ConsultaDTO cDTO = transform(c);
			res.add(cDTO);
		});
		return res;
	}
	
	@Override
	public ConsultaDTO findById(Integer id) {
		final Consulta c = consultadao.findOne(id);
		return transform(c);
	}
	
	@Override
	public ConsultaDTO create(ConsultaDTO consultaDTO){
		final Consulta c = transform(consultaDTO);
		return transform(consultadao.save(c));
	}
	
	@Override
	public void update(ConsultaDTO consultaDTO, Integer idConsulta)
	{
		final Consulta c = transform(consultaDTO);
		final Consulta origin = consultadao.findOne(idConsulta);
		modificarConsulta(origin,c);
		consultadao.save(c);
	}
	
	@Override
	public void delete(Integer idConsulta)// throws ClinicaNotFoundException
	{
		consultadao.delete(idConsulta);
	}

	@Override
	public void modificarConsulta(Consulta origen, Consulta nuevo)
	{
		nuevo.setId(origen.getId());		
	}

}
