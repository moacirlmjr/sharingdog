package br.com.sd.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Role;
import br.com.sd.modelo.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario;
	private Integer roleID;
	
	public UsuarioBean(){
		usuario= new Usuario();
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

	public String gravar() {
		System.out.println("Gravando usuario " + this.usuario.getNome());
		Role role = new DAO<Role>(Role.class).buscaPorId(roleID);
		this.usuario.setRole(role);
		new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
		this.usuario = new Usuario();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession httpSession = request.getSession(true);
		Usuario user = (Usuario) httpSession.getAttribute("usuario");
		if (user.isAdmin()) {
			return "relatorioUsuarios";
		} else {
			return "login";
		}

	}

	public String gravarUsuario() {
		System.out.println("Gravando usuario " + this.usuario.getNome());
		Role role = new DAO<Role>(Role.class).buscaPorId(roleID);
		this.usuario.setRole(role);
		new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
		this.usuario = new Usuario();
		return "login";

	}

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		this.usuario = user;
		return this.usuario;
	}

	public String atualizaDados() {
		new DAO<Usuario>(Usuario.class).atualiza(this.usuario);
		this.usuario = new Usuario();
		return "dadosDoUsuario";
	}

}
