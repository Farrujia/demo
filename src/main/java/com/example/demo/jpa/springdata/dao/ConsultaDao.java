package com.example.demo.jpa.springdata.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.jpa.springdata.model.Consulta;

public interface ConsultaDao  extends CrudRepository<Consulta, Integer>{

}
