package br.com.sd.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Porte;
import br.com.sd.modelo.Raca;
import br.com.sd.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class RacaBean {

	private Raca raca;
	private Integer porteID;
	
	public RacaBean(){
		raca = new Raca();
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Integer getPorteID() {
		return porteID;
	}

	public void setPorteID(Integer porteID) {
		this.porteID = porteID;
	}

	public List<Raca> getRacas() {
		return new DAO<Raca>(Raca.class).listaTodos();
	}
	
	public List<Raca> getRacasOrdenadas() {
		return new DAO<Raca>(Raca.class).findListResults(Raca.findAllRacasOrdenadas);
	}

	public void gravar() {
		Porte p = new DAO<Porte>(Porte.class).buscaPorId(porteID);
		raca.setPorte(p);
		System.out.println("Gravando Raca " + this.raca.getRaca());
		new DAO<Raca>(Raca.class).adiciona(raca);
		raca= new Raca();
		JSFMessageUtil.sendInfoMessageToUser("Raça cadastrada com sucesso!!!");

		//return "relatorioRacas";

	}

}
