package br.com.sd.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import br.com.sd.modelo.interfaces.Generic;

@Entity
@NamedQuery(name = "Raca.findAllRacasOrdenadas", query = "select r from Raca r order by porte_id asc, raca asc")

public class Raca implements Generic {

	
	private static final long serialVersionUID = 1L;
	
	public static final String findAllRacasOrdenadas = "Raca.findAllRacasOrdenadas";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String raca;
	@OneToOne
	private Porte porte;

	public Raca() {
		super();
	}

	public Raca(String raca, Porte porte) {
		super();
		this.raca = raca;
		this.porte = porte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

}
