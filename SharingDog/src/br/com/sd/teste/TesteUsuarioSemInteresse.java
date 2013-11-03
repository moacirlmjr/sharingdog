package br.com.sd.teste;

import br.com.sd.mbeans.UsuarioBean;

public class TesteUsuarioSemInteresse {
	
	public static void main(String[] args) {
		UsuarioBean ub = new UsuarioBean();
		ub.getUsuariosSemInteresse();
		
		System.out.println("Tamanhooooooo" + ub.getUsuariosSemInteresse().size());
	}

}
