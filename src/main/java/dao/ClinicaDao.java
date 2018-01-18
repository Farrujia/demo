package dao;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import model.Clinica;

@Repository
public interface ClinicaDao extends PagingAndSortingRepository<Clinica, Integer> {

	//@Query(value = "from Clinica c where c.name like :name")
	//o sin nada
	public ArrayList<Clinica> findByName();
	public ArrayList<Clinica> findById();
}
