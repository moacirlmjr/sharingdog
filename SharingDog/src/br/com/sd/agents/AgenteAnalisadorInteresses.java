package br.com.sd.agents;

import jade.core.Agent;


public class AgenteAnalisadorInteresses extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6776055151529992525L;

	protected void setup(){
		
		super.setup();
		
		addBehaviour(new AgenteAnalisadorInteressesBehavior(this, 5000));
	}

}
