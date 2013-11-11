package br.com.sd.agents.strategies;

import br.com.sd.mbeans.RecomendacaoBean;


public class RecomendaBaseadoNoInteresseEstrategia  implements Estrategia {

	@Override
	public void execute() {
		
		System.out.println("Recomenda Baseado no interesse");
		
		RecomendacaoBean rmb = new RecomendacaoBean();
		rmb.getRecomendacoesUsuario();	
	
	}
}
