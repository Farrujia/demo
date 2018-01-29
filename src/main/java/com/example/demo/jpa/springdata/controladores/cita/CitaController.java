package com.example.demo.jpa.springdata.controladores.cita;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.springdata.dto.CitaDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.service.CitaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/cita")
public class CitaController {

	@Autowired
	private CitaService citaService;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<CitaDTO> findAll()
	{
		return citaService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idCita}")
	public CitaDTO findById(@PathVariable Integer idCita) throws NotFoundException
	{
		return citaService.findById(idCita);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CitaDTO create(@RequestBody CitaDTO c) throws NotFoundException {
		return citaService.create(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{idCita}")
	public void update(@RequestBody CitaDTO c, @PathVariable Integer idCita)throws NotFoundException
	{
		citaService.update(c,idCita);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idCita}")
	public void delete(@PathVariable Integer idCita)throws NotFoundException
	{
		citaService.delete(idCita);
	}
		
}
