package br.com.sd.agents.strategies;


public class Contexto {
	
	 private Estrategia estrategia;
	 
	    public Contexto(Estrategia estrategia) {
	        this.estrategia = estrategia;
	    }
	 
	    public void executeEstrategia() {
	        estrategia.execute();
	    }

}
