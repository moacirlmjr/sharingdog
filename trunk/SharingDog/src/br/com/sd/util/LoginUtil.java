package br.com.sd.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.sd.modelo.Usuario;

public class LoginUtil {

	public static Usuario retornaUsuarioLogado(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		return u;
	}
}
