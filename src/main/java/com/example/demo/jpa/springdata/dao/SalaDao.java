package com.example.demo.jpa.springdata.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.jpa.springdata.model.Sala;

@Repository
public interface SalaDao extends CrudRepository<Sala,Integer> {

}
