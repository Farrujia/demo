package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Cita {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Paciente id_paciente;
	
	@ManyToOne
	private Consulta id_consulta;
	
	private String hour_ini;
	
	
}
