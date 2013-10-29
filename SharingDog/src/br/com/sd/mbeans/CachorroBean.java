package br.com.sd.mbeans;

import java.util.List;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Raca;

public class CachorroBean {
	
	private Cachorro cachorro;
	private Integer racaID;
	
	
	public CachorroBean(){
		cachorro = new Cachorro();
	}

	public Cachorro getCachorro() {
		return cachorro;
	}

	public void setCachorro(Cachorro cachorro) {
		this.cachorro = cachorro;
	}

	public Integer getRacaID() {
		return racaID;
	}

	public void setRacaID(Integer racaID) {
		this.racaID = racaID;
	}
	
	public List<Cachorro> getCachorros(){
		return new DAO<Cachorro>(Cachorro.class).listaTodos();		
	}
	
	public List<Cachorro> getCachorrosOrdenadosNomeERaca(){
		return new DAO<Cachorro>(Cachorro.class).findListResults(Cachorro.findAllCachorrosOrdenadosRaca);		
	}
	
	public String gravar(){
		Raca r = new DAO<Raca>(Raca.class).buscaPorId(racaID);
		this.cachorro.setRaca(r);
		System.out.println("adicionando o cachorro" + this.cachorro.getNome());
		new DAO<Cachorro>(Cachorro.class).adiciona(cachorro);		
		return "relatorioCachorros";
		
	}
	
	

}
