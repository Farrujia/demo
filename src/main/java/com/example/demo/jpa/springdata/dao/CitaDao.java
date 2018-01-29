package com.example.demo.jpa.springdata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.jpa.springdata.model.Cita;

@Repository
public interface CitaDao extends PagingAndSortingRepository<Cita, Integer> {

}
