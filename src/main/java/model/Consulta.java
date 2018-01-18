package model;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Consulta {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Medico id_medico;
	
	@ManyToOne
	private Sala id_sala;

	@Enumerated(EnumType.STRING)
	private Turno turno;
	
	@Temporal(value = TemporalType.DATE)
	private Date fecha;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_consulta")
	private ArrayList<Cita> citas = new ArrayList<>();
}
