package com.example.demo.jpa.springdata.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.jpa.springdata.model.Medico;


@Repository
public interface MedicoDao extends CrudRepository<Medico, Integer> {

	
	//public Medico findById(@Param(value = "id") Integer id);
}
