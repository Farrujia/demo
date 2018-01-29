package com.example.demo.jpa.springdata.controladores.medico;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.jpa.springdata.dto.MedicoDTO;
import com.example.demo.jpa.springdata.exception.NotFoundException;
import com.example.demo.jpa.springdata.service.MedicoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api/medico")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;

	@Autowired
    private RestTemplate restTemplate;
	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public List<Medico> findAll(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer size){
		return medicoService.findAll(page,size);
	}*/

	@RequestMapping(method = RequestMethod.GET)
	public List<MedicoDTO> findAll()
	{
		return medicoService.findAll();
	}
/*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public MedicoDTO findOne(@PathVariable("id") Integer id) throws NotFoundExcept
	{
		return medicoService.findById(id);
	}*/

	
	@RequestMapping(method = RequestMethod.GET, value = "/{idMedico}")
	public MedicoDTO findById(@PathVariable Integer idMedico)throws NotFoundException
	{
		return medicoService.findById(idMedico);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public MedicoDTO create(@RequestBody MedicoDTO m) {
		return medicoService.create(m);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{idMedico}")
	public void update(@RequestBody MedicoDTO m, @PathVariable Integer idMedico)
	{
		medicoService.update(m,idMedico);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idMedico}")
	public void delete(@PathVariable Integer idMedico) throws NotFoundException
	{
		medicoService.delete(idMedico);
	}
	
	@RequestMapping(value = "/dbg", method = {RequestMethod .GET})
	public void retrieveDoctorsFromExternalApp()
	{
		//DoctorDTO result = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?page=" + i, DoctorDTO.class);
		//List<DoctorDTO> result = restTemplate.postForEntity(url, request, responseType)
		//List<DoctorDTO> resultList = Arrays.asList(restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?page=0", DoctorDTO[].class));
		//resultList.forEach(o -> doctorService.create(o));
		int j = 0;
		List<String> ids = new ArrayList<>();
		MedicoDTO[] result;
		MedicoDTO medico = new MedicoDTO();
		do {
			result = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor?page="+j, MedicoDTO[].class);
			j++;
			for(int i = 0; i< result.length;++i)
				ids.add(result[i].getId());
		}while(result.length!=0);
		
		for(int k = 0; k<ids.size();k++) {
			medico = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor/"+ids.get(k), MedicoDTO.class);
			medicoService.create(medico);
			}
	}
}
