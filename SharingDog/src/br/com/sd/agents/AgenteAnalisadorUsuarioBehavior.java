package br.com.sd.agents;


import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import br.com.sd.agents.strategies.Contexto;
import br.com.sd.agents.strategies.RecomendaBaseadoNoUsuarioEstrategia;



public class AgenteAnalisadorUsuarioBehavior extends TickerBehaviour{

	
	private static final long serialVersionUID = 4468228483805851156L;


	public AgenteAnalisadorUsuarioBehavior(Agent a, long period) {
		super(a, period);
	}


	@Override
	protected void onTick() {
		 Contexto contexto = new Contexto(new RecomendaBaseadoNoUsuarioEstrategia());
	     contexto.executeEstrategia();	
	}

}
