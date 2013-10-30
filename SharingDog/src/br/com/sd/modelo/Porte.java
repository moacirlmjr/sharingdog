package br.com.sd.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import br.com.sd.modelo.interfaces.Generic;

@Entity
@NamedQuery(name = "Porte.findAllPortesOrdenados", query = "select p from Porte p order by porte asc") 
public class Porte implements Generic {

	private static final long serialVersionUID = 1L;

	public static final String findAllPorteOrdenados = "Porte.findAllPortesOrdenados";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String porte;

	public Porte(String porte) {
		super();
		this.porte = porte;
	}

	public Porte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

}
