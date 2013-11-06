package br.com.sd.teste;

import java.util.ArrayList;

import br.com.sd.mbeans.InteresseBean;
import br.com.sd.mbeans.RecomendacaoBean;
import br.com.sd.modelo.Interesse;

public class TestaRec {
	
	public static void main(String[] args) {
		RecomendacaoBean rb = new RecomendacaoBean();
		InteresseBean ib = new InteresseBean();
		
		ArrayList<Interesse> interesses = (ArrayList<Interesse>) ib.getInteresses();
		
		for(Interesse i : interesses){
			if(i.getUsuario().getId() == 4){
				rb.recomendaInteresse(i);
			}
		}
	}

}
