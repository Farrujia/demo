package com.example.demo.jpa.springdata.controladores.paciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.springdata.dto.PacienteDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService pacienteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<PacienteDTO> findAll()
	{
		return pacienteService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idPaciente}")
	public PacienteDTO findById(@PathVariable Integer idPaciente) throws NotFoundException
	{
		return pacienteService.findById(idPaciente);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public PacienteDTO create(@RequestBody PacienteDTO p) {
		return pacienteService.create(p);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{idPaciente}")
	public void update(@RequestBody PacienteDTO p, @PathVariable Integer idPaciente)
	{
		pacienteService.update(p,idPaciente);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idPaciente}")
	public void delete(@PathVariable Integer idPaciente)throws NotFoundException
	{
		pacienteService.delete(idPaciente);
	}
}
