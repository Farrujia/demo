package com.example.demo.jpa.springdata.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestConfiguracion {
	
	/*
    @Autowired
    private RestTemplate restTemplate;
	
    @RequestMapping(value = "/")
    public DoctorDTO index() {
        
        DoctorDTO resultado = restTemplate.getForObject("http://doctor.dbgjerez.es:8080/api/doctor", DoctorDTO.class);
        resultado = restTemplate.postForObject("localhost:PUERTO", resultado, DoctorDTO.class);
        restTemplate.put("localhost:PUERTO", resultado);
        restTemplate.delete("localhost:PUERTO/doctor/1");
        
        return resultado;
    }*/
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	

}
