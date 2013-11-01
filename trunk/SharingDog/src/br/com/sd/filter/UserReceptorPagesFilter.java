package br.com.sd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import br.com.sd.modelo.Usuario;

public class UserReceptorPagesFilter extends AbstractFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Usuario user = (Usuario) req.getSession(true).getAttribute("usuario");
		if (user == null){
			accessDenied(request, response, req);
			throw new SecurityException();	
			
		}

		if((!user.isUserReceptor() && !user.isUserDoador())){
			accessDenied(request, response, req);
			throw new SecurityException();
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		
	}
}