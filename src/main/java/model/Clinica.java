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
public class Clinica {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_clinica")
	private ArrayList<Sala> salas = new ArrayList<>();
	
}
