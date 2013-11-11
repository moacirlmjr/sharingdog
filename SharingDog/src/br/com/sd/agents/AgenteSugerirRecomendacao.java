package br.com.sd.agents;

import jade.core.Agent;
/*
 * Agente Sugere Card�pio � uma feature do n�cleo, por�m seu comportamento � uma feature alternativa
 * Definida pelo padr�o Strategy
 */
//O agente sera executado de 5 em 5 segundos
public class AgenteSugerirRecomendacao extends Agent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2120102533050279597L;

	protected void setup() {
			// TODO Auto-generated method stub
			super.setup();
			
			//86400000 milliseconds = 1 day
			addBehaviour(new AgenteSugerirRecomendacaoBehavior(this,10000));
		}
	
}

