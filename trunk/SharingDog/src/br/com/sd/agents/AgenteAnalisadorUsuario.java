package br.com.sd.agents;

import jade.core.Agent;


public class AgenteAnalisadorUsuario extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6776055151529992525L;

	protected void setup(){
		
		super.setup();
		
		addBehaviour(new AgenteAnalisadorUsuarioBehavior(this, 5000));
	}

}
