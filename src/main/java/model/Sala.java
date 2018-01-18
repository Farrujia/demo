package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
public class Sala {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique = true)
	private String roomNumber;
	
	//no se si tendria que tener foreign key
	@ManyToOne(fetch = FetchType.LAZY)
	private Clinica id_clinica;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_sala")
	ArrayList<Consulta> consultas = new ArrayList<>();
	
	
	
}
