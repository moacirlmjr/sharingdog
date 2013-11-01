package br.com.sd.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Raca;
import br.com.sd.modelo.Usuario;
import br.com.sd.modelo.enumerator.InteresseStatus;
import br.com.sd.util.CalendarUtil;

@ManagedBean
@RequestScoped
public class InteresseBean {

	private Interesse interesse;
	private Integer RacaID;

	public InteresseBean() {
		interesse = new Interesse();
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public List<Interesse> getInteresses() {
		List<Interesse> rec = new ArrayList<Interesse>();
		return rec;
	}

	public List<Interesse> getInteressesAtuais() {
		List<Interesse> rec = new ArrayList<Interesse>();
		return rec;
	}

	public List<Interesse> getInteressesUsuario() {
		List<Interesse> rec = new ArrayList<Interesse>();
		return rec;
	}

	public void grava() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");

		Raca r = new DAO<Raca>(Raca.class).buscaPorId(this.RacaID);
		this.interesse.setRacasDeInteresse(r);
		this.interesse.setUsuario(u);
		this.interesse.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
		this.interesse.setStatus(InteresseStatus.ATIVO);
		new DAO<Interesse>(Interesse.class).adiciona(this.interesse);
	}

	public void tornaInativo() {
		this.interesse.setStatus(InteresseStatus.INATIVO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
	}

	public void tornaAtendido() {
		this.interesse.setStatus(InteresseStatus.ATENDIDO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
	}

}
