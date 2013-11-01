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

import br.com.sd.modelo.enumerator.InteresseStatus;
import br.com.sd.util.CalendarUtil;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Interesse.findAllInteresses", query = "select c from Cachorro c order by raca_id asc, nome asc"),
		@NamedQuery(name = "Interesse.findAllInteressesUser", query = "select c from Cachorro c where dono_id = :uid") })
public class Interesse {

	public static final String findAllInteresses = "Interesse.findAllInteresses";
	public static final String findAllInteressesUser = "Interesse.findAllInteressesUser";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Calendar dataRegistro;

	@OneToOne
	private Usuario usuario;

	@OneToOne
	private Raca racaDeInteresse;

	@Enumerated(EnumType.STRING)
	private InteresseStatus status;

	public Interesse() {
		usuario = new Usuario();
		racaDeInteresse = new Raca();
		dataRegistro = CalendarUtil.retornaDiaDeHoje();
	}

	public Interesse(Usuario usuario, Raca racaDeInteresse) {
		super();
		this.dataRegistro = CalendarUtil.retornaDiaDeHoje();
		this.usuario = usuario;
		this.racaDeInteresse = racaDeInteresse;
		this.status = InteresseStatus.ATIVO;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Raca getRacasDeInteresse() {
		return racaDeInteresse;
	}

	public void setRacasDeInteresse(Raca racasDeInteresse) {
		this.racaDeInteresse = racasDeInteresse;
	}

	public InteresseStatus getStatus() {
		return status;
	}

	public void setStatus(InteresseStatus status) {
		this.status = status;
	}

}
