package br.com.sd.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sd.modelo.interfaces.Generic;


@Entity
@Table(name = "cachorro")
public class Cachorro implements Generic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToOne
	private Raca raca;
	@OneToOne
	private Usuario dono;

	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public Cachorro() {
		super();
	}
	
	public Cachorro(String nome, Raca raca, Usuario dono,
			Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.raca = raca;
		this.dono = dono;
		this.dataNascimento = dataNascimento;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
	
	


}
