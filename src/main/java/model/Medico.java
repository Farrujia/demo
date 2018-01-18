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
public class Medico {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="medico")
	private ArrayList<Consulta> consultas = new ArrayList<>();
}
