package com.example.demo.jpa.springdata.controladores.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.springdata.dto.ConsultaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.service.ConsultaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaDTO> findAll()
	{
		return consultaService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idConsulta}")
	public ConsultaDTO findById(@PathVariable Integer idConsulta)throws NotFoundException
	{
		return consultaService.findById(idConsulta);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ConsultaDTO create(@RequestBody ConsultaDTO c)throws NotFoundException {
		return consultaService.create(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{idConsulta}")
	public void update(@RequestBody ConsultaDTO c, @PathVariable Integer idConsulta)throws NotFoundException
	{
		consultaService.update(c,idConsulta);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idConsulta}")
	public void delete(@PathVariable Integer idConsulta)throws NotFoundException
	{
		consultaService.delete(idConsulta);
	}
		
}
