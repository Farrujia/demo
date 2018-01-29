package com.example.demo.jpa.springdata.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.springdata.dao.MedicoDao;
import com.example.demo.jpa.springdata.dto.MedicoDTO;
import com.example.demo.jpa.springdata.model.Consulta;
import com.example.demo.jpa.springdata.model.Medico;
import com.example.demo.jpa.springdata.service.ConsultaService;
import com.example.demo.jpa.springdata.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	
	@Autowired
	private MedicoDao medicodao;
	
	@Autowired
	private ConsultaService consultaservice;
	
	@Override
	public MedicoDTO transform(Medico m)
	{
		MedicoDTO mDTO = new MedicoDTO();
		mDTO.setIdInterno(m.getId());
		mDTO.setName(m.getName());
		mDTO.setId(m.getCodigo());
		mDTO.setPrice(m.getPrecio());
		m.getConsultas().forEach(
			consulta -> {mDTO.getConsultas().add(consulta.getId());
		});
		return mDTO;
	}
	
	@Override	
	public Medico transform(MedicoDTO mDTO)
	{
		Medico m;
		if(mDTO.getIdInterno()!=null && medicodao.exists(mDTO.getIdInterno()))
			m = medicodao.findOne(mDTO.getIdInterno());
		else
			m = new Medico();
		m.setName(mDTO.getName());
		m.setCodigo(mDTO.getId());
		m.setPrecio(mDTO.getPrice());
		List<Consulta> con = new ArrayList<>();
		if(mDTO.getConsultas() != null)
			mDTO.getConsultas().forEach(
				consulta -> con.add(consultaservice.transform(consultaservice.findById(consulta))));
		m.setConsultas(con);
		return m;
	}
	
	@Override	
	public List<MedicoDTO> findAll()
	{
		final Iterable<Medico> findAll = medicodao.findAll();
		final List<MedicoDTO> res = new ArrayList<>();
		findAll.forEach(
			m -> {final MedicoDTO mDTO = transform(m);
			res.add(mDTO);
		});
		return res;
	}
	
	@Override
	public MedicoDTO findById(Integer id) {
		final Medico d = medicodao.findOne(id);
		return transform(d);
	}
	
	@Override
	public MedicoDTO create(MedicoDTO medicoDTO) {
		final Medico d = transform(medicoDTO);
		return transform(medicodao.save(d));
	}
	
	@Override
	public void update(MedicoDTO medicoDTO, Integer idMedico) {
		final Medico m = transform(medicoDTO);
		final Medico origin = medicodao.findOne(idMedico);
		modificarMedico(origin,m);
		medicodao.save(m);
	}
	
	@Override
	public void delete(Integer idmedico)// throws MedicoNotFoundException
	{
		medicodao.delete(idmedico);
	}

	@Override
	public void modificarMedico(Medico origen, Medico nuevo)
	{
		nuevo.setId(origen.getId());
		
	}
	
}