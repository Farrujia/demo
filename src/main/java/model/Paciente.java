package model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Paciente {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_paciente")
	ArrayList<Cita> citas = new ArrayList<>();
}
