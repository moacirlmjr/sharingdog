package br.com.sd.modelo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.sd.modelo.enumerator.RecomendacaoStatus;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Recomendacao.findAllRecomendacaoesUsuario", query = "select c from Cachorro c order by raca_id asc, nome asc"),
		@NamedQuery(name = "Recomendacao.findAllRecomendacaoesAtuais", query = "select c from Cachorro c where dono_id = :uid") })
public class Recomendacao {

	public static final String findAllRecomendacaoesUsuario = "Recomendacao.findAllRecomendacaoesUsuario";
	public static final String findAllRecomendacaoesAtuais = "Recomendacao.findAllRecomendacaoesAtuais";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Calendar dataRegistro;

	@OneToOne
	private Interesse interesse;

	@Enumerated(EnumType.STRING)
	private RecomendacaoStatus status;
	
	@OneToMany
	private List<Cachorro> cachorros;

	public Recomendacao() {
		interesse = new Interesse();
		dataRegistro = Calendar.getInstance();
	}

	public Recomendacao(Interesse interesse, List<Cachorro> cachorros) {
		super();
		this.dataRegistro = Calendar.getInstance();
		this.interesse = interesse;
		this.cachorros = cachorros;
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

	public List<Cachorro> getCachorros() {
		return cachorros;
	}

	public void setCachorros(List<Cachorro> cachorros) {
		this.cachorros = cachorros;
	}
	
	public void adicionaCachorroParaRecomendacao(Cachorro c) {
		this.cachorros.add(c);
	}
	
	

}
