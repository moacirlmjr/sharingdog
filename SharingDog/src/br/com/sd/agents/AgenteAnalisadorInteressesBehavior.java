package br.com.sd.agents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import br.com.sd.agents.strategies.Contexto;
import br.com.sd.agents.strategies.RecomendaBaseadoNoInteresseEstrategia;


public class AgenteAnalisadorInteressesBehavior extends TickerBehaviour{

	
	private static final long serialVersionUID = 4468228483805851156L;
	


	public AgenteAnalisadorInteressesBehavior(Agent a, long period) {
		super(a, period);
	}


	@Override
	protected void onTick() {
		 Contexto contexto = new Contexto(new RecomendaBaseadoNoInteresseEstrategia());
	     contexto.executeEstrategia();	
	}

}
