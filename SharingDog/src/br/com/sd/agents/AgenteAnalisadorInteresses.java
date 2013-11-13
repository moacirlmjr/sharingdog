package br.com.sd.agents;

import jade.core.Agent;


public class AgenteAnalisadorInteresses extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6776055151529992525L;
	private AgenteAnalisadorInteressesBehavior aaib = new AgenteAnalisadorInteressesBehavior(this, 5000);

	protected void setup(){
		
		super.setup();
		
		addBehaviour(aaib);
	}

}
