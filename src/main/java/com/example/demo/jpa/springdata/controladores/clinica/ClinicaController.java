package com.example.demo.jpa.springdata.controladores.clinica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.springdata.dto.ClinicaDTO;
import com.example.demo.jpa.springdata.service.ClinicaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/clinica")
public class ClinicaController {

	@Autowired
	private ClinicaService clinicaService;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<ClinicaDTO> findAll()
	{
		return clinicaService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{idClinica}") 
	public ClinicaDTO findById(@PathVariable Integer idClinica)
	{
		return clinicaService.findById(idClinica);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ClinicaDTO create(@RequestBody ClinicaDTO c){
		return clinicaService.create(c);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{idClinica}")
	public void update(@RequestBody ClinicaDTO c, @PathVariable Integer idClinica)
	{
		clinicaService.update(c,idClinica);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idClinica}")
	public void delete(@PathVariable Integer idClinica)
	{
		clinicaService.delete(idClinica);
	}
		
}
