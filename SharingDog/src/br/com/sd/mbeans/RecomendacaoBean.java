package br.com.sd.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.EmailException;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Recomendacao;
import br.com.sd.modelo.Usuario;
import br.com.sd.modelo.enumerator.InteresseStatus;
import br.com.sd.modelo.enumerator.RecomendacaoStatus;
import br.com.sd.util.CalendarUtil;
import br.com.sd.util.JSFMessageUtil;
import br.com.sd.util.LoginUtil;
import br.com.sd.util.MailUtil;

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

	public List<Recomendacao> getRecomendacoesAtivas() {
		return new DAO<Recomendacao>(Recomendacao.class)
				.findListResults(Recomendacao.findAllRecomendacaoesAtivas);
	}

	public List<Recomendacao> getRecomendacoesInativas() {
		return new DAO<Recomendacao>(Recomendacao.class)
				.findListResults(Recomendacao.findAllRecomendacaoesInativas);
	}

	public List<Recomendacao> getRecomendacoesConfirmadas() {
		return new DAO<Recomendacao>(Recomendacao.class)
				.findListResults(Recomendacao.findAllRecomendacaoesConfirmadas);
	}

	public List<Recomendacao> getRecomendacoesUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().equals(u)) {
				auxNovo.add(r);
			}
		}
		System.out.println("Entreeeeeeeeeeeeei: " + auxNovo.size());
		return auxNovo;
	}

	public List<Recomendacao> getRecomendacoesConfirmadasUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().equals(u)) {
				if (r.getStatus() == RecomendacaoStatus.CONFIRMADA) {
					auxNovo.add(r);
				}
			}
		}
		System.out.println("Entreeeeeeeeeeeeei: " + auxNovo.size());
		return auxNovo;
	}

	public List<Recomendacao> getRecomendacoesInativasUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().equals(u)) {
				if (r.getStatus() == RecomendacaoStatus.INATIVA) {
					auxNovo.add(r);
				}
			}
		}
		System.out.println("Entreeeeeeeeeeeeei: " + auxNovo.size());
		return auxNovo;
	}

	public void gravar() {
		Interesse inte = new DAO<Interesse>(Interesse.class)
				.buscaPorId(this.interesseID);
		Cachorro cachorro = new DAO<Cachorro>(Cachorro.class)
				.buscaPorId(this.cachorroID);
		this.recomendacao.setInteresse(inte);
		this.recomendacao.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
		this.recomendacao.setCachorro(cachorro);
		this.recomendacao.setStatus(RecomendacaoStatus.ATIVA);
		new DAO<Recomendacao>(Recomendacao.class).adiciona(this.recomendacao);

	}

	public void gravar(Recomendacao rec) {
		new DAO<Recomendacao>(Recomendacao.class).adiciona(rec);

	}

	public void tornarConfirmada() {
		this.recomendacao.setStatus(RecomendacaoStatus.CONFIRMADA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil.sendInfoMessageToUser("Recomendacao ao cachorro"
				+ this.recomendacao.getCachorro().getNome()
				+ " alterado para Confirmada!");
	}

	public void tornarInativa() {
		this.recomendacao.setStatus(RecomendacaoStatus.INATIVA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil.sendInfoMessageToUser("Recomendacao ao cachorro "
				+ this.recomendacao.getCachorro().getNome()
				+ " alterado para Inativa!");
	}

	public void tornarAtiva() {
		this.recomendacao.setStatus(RecomendacaoStatus.ATIVA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil.sendInfoMessageToUser("Recomendacao ao cachorro "
				+ this.recomendacao.getCachorro().getNome()
				+ " alterado para Ativada!");
	}

	public void excluir() {
		new DAO<Recomendacao>(Recomendacao.class).remove(this.recomendacao);
		JSFMessageUtil.sendInfoMessageToUser("Recomendacao ao cachorro "
				+ this.recomendacao.getCachorro().getNome()
				+ " excluido com sucesso!");
	}

	public void recomendaUsuario(Usuario u) {
		InteresseBean ib = new InteresseBean();
		CachorroBean cb = new CachorroBean();
		ArrayList<Interesse> intUser = new ArrayList<Interesse>();
		ArrayList<Interesse> allInt = (ArrayList<Interesse>) ib
				.getInteressesAtivos();
		ArrayList<Cachorro> cachorros = (ArrayList<Cachorro>) cb.getCachorros();

		for (Interesse i : allInt) {
			if (i.getUsuario().equals(u)) {
				intUser.add(i);
			}
		}

		for (Cachorro c : cachorros) {
			for (Interesse i : intUser) {
				if (c.getRaca().equals(i.getRacasDeInteresse())) {
					Recomendacao rec = new Recomendacao();
					i.setStatus(InteresseStatus.ATENDIDO);
					new DAO<Interesse>(Interesse.class).atualiza(i);
					rec.setStatus(RecomendacaoStatus.ATIVA);
					rec.setCachorro(c);
					rec.setInteresse(i);
					rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
					gravar(rec);
				}
			}
		}

	}

	public void recomendaInteresse(Interesse i) {
		CachorroBean cb = new CachorroBean();
		ArrayList<Cachorro> cachorros = (ArrayList<Cachorro>) cb.getCachorros();
		ArrayList<Cachorro> cachorrosRec = new ArrayList<Cachorro>();


		for (Cachorro c : cachorros) {
			if (c.getRaca().getId()==(i.getRacasDeInteresse().getId())) {
				cachorrosRec.add(c);
			}
		}
		
		for(Cachorro dog: cachorrosRec){
			Recomendacao rec = new Recomendacao();
			rec.setCachorro(dog);
			rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
			rec.setInteresse(i);
			i.setStatus(InteresseStatus.ATENDIDO);
			new DAO<Interesse>(Interesse.class).atualiza(i);
			rec.setStatus(RecomendacaoStatus.ATIVA);
			gravar(rec);
			try {
				MailUtil.enviaEmailRecomendacao(rec);
			} catch (EmailException e) {
				System.out.println("Deu erro no envio da Recomendacao!!!!");
				e.printStackTrace();
			}
			rec = null;
			
		}
		
		

	}
}
