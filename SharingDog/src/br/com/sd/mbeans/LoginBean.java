package br.com.sd.mbeans;


import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Usuario;
import br.com.sd.security.SegurancaUtil;
import br.com.sd.util.JSFMessageUtil;

@SessionScoped
@ManagedBean
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return usuario;
	}

	public Usuario getUsuarioLogado() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		return u;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String logOut() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(false);
		session.removeAttribute("usuario");
		session.invalidate();
		return "logout";
	}

	public Usuario isValidLogin(String login, String senha) {

		Usuario user = findUserByLogin(login);
		if (user == null || (!SegurancaUtil.criptografar(user.getSenha()).equals(senha))) {
			return null;
		}

		return user;
	}

	public String validaLogin() {

		Usuario user = isValidLogin(this.usuario.getLogin(),
				this.usuario.getSenha());
		if (user != null) {
			this.usuario = user;
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context
					.getExternalContext().getRequest();
			request.getSession().setAttribute("usuario", user);
			return user.isAdmin() ? "relatorioUsuarios" : "checkin";
		}

		JSFMessageUtil.sendErrorMessageToUser("Verifique seu email/password");
		return null;

	}

	public Usuario findUserByLogin(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		Usuario user = new DAO<Usuario>(Usuario.class).findOneResult(
				Usuario.FIND_BY_LOGIN, parameters);
		System.out.println();
		return user;
	}

}
