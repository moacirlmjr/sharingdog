package br.com.sd.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Recomendacao;
import br.com.sd.modelo.Role;
import br.com.sd.modelo.Usuario;
import br.com.sd.util.JSFMessageUtil;
import br.com.sd.util.MailUtil;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	private Integer roleID;

	public UsuarioBean() {
		usuario = new Usuario();
		roleID = 1;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return new DAO<Usuario>(Usuario.class).listaTodos();
	}

	public List<Usuario> getUsuariosSemInteresse() {

		ArrayList<Interesse> todosOsInteresse = (ArrayList<Interesse>) new DAO<Interesse>(
				Interesse.class).listaTodos();
		ArrayList<Usuario> todosOsUsuarios = (ArrayList<Usuario>) new DAO<Usuario>(
				Usuario.class).listaTodos();

		ArrayList<Usuario> todosOsUsuariosReceptores = new ArrayList<Usuario>();
		ArrayList<Usuario> todosOsUsuariosSemInteresse = new ArrayList<Usuario>();
		ArrayList<Usuario> todosOsUsuariosComInteresse = new ArrayList<Usuario>();
		
		for(Usuario u: todosOsUsuarios){
			if(u.getRole().getId()==2){
				todosOsUsuariosReceptores.add(u);
			}
		}

		for (Interesse i : todosOsInteresse) {
			todosOsUsuariosComInteresse.add(i.getUsuario());
		}

		todosOsUsuariosReceptores.removeAll(todosOsUsuariosComInteresse);
		todosOsUsuariosSemInteresse = todosOsUsuariosReceptores;

		return todosOsUsuariosSemInteresse;
	}

	public List<Usuario> getUsuariosSemRecomendacao() {

		ArrayList<Usuario> todosOsUsuarios = (ArrayList<Usuario>) new DAO<Usuario>(
				Usuario.class).listaTodos();
		ArrayList<Recomendacao> todosAsRecomendacoes = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();

		ArrayList<Usuario> todosOsUsuariosSemRecomendacao = new ArrayList<Usuario>();
		ArrayList<Usuario> todosOsUsuariosComRecomendacao = new ArrayList<Usuario>();
		ArrayList<Usuario> todosOsUsuariosReceptores = new ArrayList<Usuario>();
		ArrayList<Interesse> todosOsInteressesComRecomendacao = new ArrayList<Interesse>();
		
		for(Usuario u: todosOsUsuarios){
			if(u.getRole().getId()==2){
				todosOsUsuariosReceptores.add(u);
			}
		}

		for (Recomendacao r : todosAsRecomendacoes) {
			if (!todosOsInteressesComRecomendacao.contains(r.getInteresse())) {
				todosOsInteressesComRecomendacao.add(r.getInteresse());
			}
		}

		
		for (Interesse i : todosOsInteressesComRecomendacao) {
			if (!todosOsUsuariosComRecomendacao.contains(i.getUsuario())) {
				todosOsUsuariosComRecomendacao.add(i.getUsuario());
			}
		}

		todosOsUsuariosReceptores.removeAll(todosOsUsuariosComRecomendacao);
		todosOsUsuariosSemRecomendacao = todosOsUsuariosReceptores;	

		return todosOsUsuariosSemRecomendacao;
	}

	
	public void gravarUsuario() {
		System.out.println("Gravando usuario " + this.usuario.getNome());
		Role role = new DAO<Role>(Role.class).buscaPorId(roleID);
		this.usuario.setRole(role);
		new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
		
		JSFMessageUtil.sendInfoMessageToUser("Usu�rio Gravado com sucesso!!!");
		try {
			MailUtil.enviaEmailBoasVindas(usuario);
		} catch (EmailException e) {
			System.out.println("N�o conseguiu enviar email de boas vindas!!!");
			e.printStackTrace();
		}
		this.usuario = new Usuario();
	}

	public String atualizaDados() {
		new DAO<Usuario>(Usuario.class).atualiza(this.usuario);
		this.usuario = new Usuario();
		return "dadosDoUsuario";
	}

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		this.usuario = user;
		return this.usuario;
	}

}
