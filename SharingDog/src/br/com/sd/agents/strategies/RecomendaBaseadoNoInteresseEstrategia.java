package br.com.sd.agents.strategies;

import br.com.sd.mbeans.InteresseBean;
import br.com.sd.mbeans.RecomendacaoBean;
import br.com.sd.modelo.Interesse;
import br.com.sd.util.AgentComunicator;




public class RecomendaBaseadoNoInteresseEstrategia  implements Estrategia {

	@Override
	public void execute() {
		
		System.out.println("Recomenda Baseado no interesse");
		InteresseBean ib = new InteresseBean();
		AgentComunicator.setListaDeInteresseSR(ib.getInteressesAtivos());
		RecomendacaoBean rb = new RecomendacaoBean();
		for(Interesse i: ib.getInteressesAtivos()){
			rb.recomendaInteresse(i);
			System.out.println("Recomendando Baseado no interesse para " + i.getUsuario().getNome());
		}
		
		
			
	}
}
