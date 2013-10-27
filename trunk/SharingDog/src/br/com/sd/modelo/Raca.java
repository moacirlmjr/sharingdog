package br.com.sd.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.sd.modelo.interfaces.Generic;

@Entity
@Table(name = "raca")
public class Raca implements Generic{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String raca;	
	@OneToOne	
	private Porte porte;
	
	
	public Raca() {
		super();
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
