package br.com.sd.agents;


import br.com.sd.agents.strategies.Contexto;
import br.com.sd.agents.strategies.RecomendaBaseadoNoInteresseEstrategia;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;


public class AgenteSugerirRecomendacaoBehavior extends TickerBehaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338612790725509651L;

	public AgenteSugerirRecomendacaoBehavior(Agent a, long period) {
		super(a, period);
	}

	@Override
	protected void onTick() {
	        Contexto contexto = new Contexto(new RecomendaBaseadoNoInteresseEstrategia());
	       	contexto.executeEstrategia();	
	}
	
		
	
}


