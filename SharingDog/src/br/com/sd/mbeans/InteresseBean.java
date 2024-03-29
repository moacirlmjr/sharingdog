package br.com.sd.mbeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.EmailException;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Raca;
import br.com.sd.modelo.Usuario;
import br.com.sd.modelo.enumerator.InteresseStatus;
import br.com.sd.util.CalendarUtil;
import br.com.sd.util.JSFMessageUtil;
import br.com.sd.util.LoginUtil;
import br.com.sd.util.MailUtil;

@ManagedBean
@RequestScoped
public class InteresseBean {

	private Interesse interesse;
	private Raca selectedRaca;

	public InteresseBean() {
		interesse = new Interesse();
		selectedRaca = new Raca();
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public Raca getSelectedRaca() {
		return selectedRaca;
	}

	public void setSelectedRaca(Raca selectedRaca) {
		this.selectedRaca = selectedRaca;
	}

	public List<Interesse> getInteresses() {
		return new DAO<Interesse>(Interesse.class).listaTodos();
	}

	public List<Interesse> getInteressesAtivos() {
		return new DAO<Interesse>(Interesse.class)
				.findListResults(Interesse.findAllInteressesAtivos);
	}

	public List<Interesse> getInteressesAtendidos() {
		return new DAO<Interesse>(Interesse.class)
				.findListResults(Interesse.findAllInteressesAtendidos);
	}

	public List<Interesse> getInteressesInativos() {
		return new DAO<Interesse>(Interesse.class)
				.findListResults(Interesse.findAllInteressesAtivos);
	}

	public List<Interesse> getInteressesUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", u.getId());
		return new DAO<Interesse>(Interesse.class).findListResults(
				Interesse.findAllInteressesUser, params);

	}

	public void gravar() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		this.interesse.setRacasDeInteresse(this.selectedRaca);
		this.interesse.setUsuario(u);
		this.interesse.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
		this.interesse.setStatus(InteresseStatus.ATIVO);
		new DAO<Interesse>(Interesse.class).adiciona(this.interesse);
		try {
			MailUtil.enviaEmailInteresse(this.interesse);
		} catch (EmailException e) {
			System.out.println("Erro no cadastramento do interesse!!!");
			e.printStackTrace();
		}
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getRacasDeInteresse().getRaca()
				+ " gravado com sucesso!");
	}

	public void tornarInativo() {
		this.interesse.setStatus(InteresseStatus.INATIVO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getRacasDeInteresse().getRaca()
				+ " alterado para Inativado!");
	}

	public void tornarAtendido() {
		this.interesse.setStatus(InteresseStatus.ATENDIDO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getRacasDeInteresse().getRaca()
				+ " alterado para Atendido!");

	}

	public void tornarAtivo() {
		this.interesse.setStatus(InteresseStatus.ATIVO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getRacasDeInteresse().getRaca()
				+ " alterado para Ativado!");
	}

	public void excluir() {
		new DAO<Interesse>(Interesse.class).remove(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getRacasDeInteresse().getRaca()
				+ " excluido com sucesso!");

	}

}
