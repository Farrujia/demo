package com.example.demo.jpa.springdata.controladores.sala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.springdata.dto.SalaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.service.SalaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {

	@Autowired
	private SalaService salaService;

	@RequestMapping(method = RequestMethod.GET)
	public List<SalaDTO> findAll()
	{
		return salaService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idSala}")
	public SalaDTO findById(@PathVariable Integer idSala) throws NotFoundException
	{
		return salaService.findById(idSala);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public SalaDTO create(@RequestBody SalaDTO s) throws NotFoundException{
		return salaService.create(s);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{idSala}")
	public void update(@RequestBody SalaDTO s, @PathVariable Integer idSala)throws NotFoundException
	{
		salaService.update(s,idSala);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idSala}")
	public void delete(@PathVariable Integer idSala)
	{
		salaService.delete(idSala);
	}
		
}
