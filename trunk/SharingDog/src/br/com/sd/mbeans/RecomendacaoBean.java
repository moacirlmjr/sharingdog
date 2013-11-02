package br.com.sd.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Recomendacao;
import br.com.sd.modelo.Usuario;
import br.com.sd.modelo.enumerator.InteresseStatus;
import br.com.sd.modelo.enumerator.RecomendacaoStatus;
import br.com.sd.util.CalendarUtil;
import br.com.sd.util.LoginUtil;

@ManagedBean
@RequestScoped
public class RecomendacaoBean {

	private Recomendacao recomendacao;
	private Integer interesseID;
	private Integer cachorroID;

	public RecomendacaoBean() {
		recomendacao = new Recomendacao();
	}

	public Recomendacao getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(Recomendacao recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Integer getInteresseID() {
		return interesseID;
	}

	public void setInteresseID(Integer interesseID) {
		this.interesseID = interesseID;
	}

	public List<Recomendacao> getRecomendacoes() {
		return new DAO<Recomendacao>(Recomendacao.class).listaTodos();
	}

	public List<Recomendacao> getRecomendacoesAtuais() {
		return new DAO<Recomendacao>(Recomendacao.class).listaTodos();

	}

	public List<Recomendacao> getRecomendacoesUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().getId() == u.getId()) {
				if (r.getInteresse().getStatus() == InteresseStatus.ATIVO) {
					auxNovo.add(r);
				}
			}
		}
		return auxNovo;
	}

	public void gravar() {
		Interesse inte = new DAO<Interesse>(Interesse.class).buscaPorId(this.interesseID);
		Cachorro cachorro = new DAO<Cachorro>(Cachorro.class).buscaPorId(this.cachorroID);
		this.recomendacao.setInteresse(inte);
		this.recomendacao.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
		this.recomendacao.setCachorro(cachorro);
		this.recomendacao.setStatus(RecomendacaoStatus.ATIVA);
		new DAO<Recomendacao>(Recomendacao.class).adiciona(this.recomendacao);

	}

	public void tornaConfirmada() {
		this.recomendacao.setStatus(RecomendacaoStatus.CONFIRMADA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
	}

	public void tornaInativa() {
		this.recomendacao.setStatus(RecomendacaoStatus.INATIVA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
	}

	public void excluir() {
		new DAO<Recomendacao>(Recomendacao.class).remove(this.recomendacao);
	}
	
	
	public void recomendaUsuario(){
		
	}
}
