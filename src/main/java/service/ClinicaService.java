package service;

import model.Clinica;

public interface ClinicaService {

	Clinica findById(Integer id);
	Clinica findByName();

}
