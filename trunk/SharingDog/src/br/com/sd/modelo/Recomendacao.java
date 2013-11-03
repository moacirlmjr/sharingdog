package br.com.sd.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sd.modelo.enumerator.RecomendacaoStatus;
import br.com.sd.modelo.interfaces.Generic;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Recomendacao.findAllRecomendacaoes", query = "select r from Recomendacao r order by dataRegistro desc"),
		@NamedQuery(name = "Recomendacao.findAllRecomendacaoesUsuario", query = "select r from Recomendacao r order by dataRegistro desc") })
public class Recomendacao implements Generic{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String findAllRecomendacaoesUsuario = "Recomendacao.findAllRecomendacaoesUsuario";
	public static final String findAllRecomendacaoes = "Recomendacao.findAllRecomendacaoes";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Calendar dataRegistro;

	@OneToOne
	private Interesse interesse;

	@Enumerated(EnumType.STRING)
	private RecomendacaoStatus status;

	@OneToOne
	private Cachorro cachorro;

	public Recomendacao() {
		interesse = new Interesse();
		dataRegistro = Calendar.getInstance();		
	}

	public Recomendacao(Interesse interesse, Cachorro cachorro) {
		super();
		this.dataRegistro = Calendar.getInstance();
		this.interesse = interesse;
		this.cachorro = cachorro;
		this.status = RecomendacaoStatus.ATIVA;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public RecomendacaoStatus getStatus() {
		return status;
	}

	public void setStatus(RecomendacaoStatus status) {
		this.status = status;
	}

	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Recomendacao) && ((Recomendacao) obj).getId().equals(this.getId())) { 
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return this.getId().hashCode();
		
	}
	

}

