package br.com.sd.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sd.dao.DAO;
import br.com.sd.modelo.Porte;
import br.com.sd.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class PorteBean {
	
	private Porte porte;
	
	public PorteBean(){
		porte=new Porte();
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}
	
	public List<Porte> getPortes() {
		return new DAO<Porte>(Porte.class).listaTodos();
	}
	
	public List<Porte> getPortesOrdenados() {
		return new DAO<Porte>(Porte.class).findListResults(Porte.findAllPorteOrdenados);
	}

	public void gravar() {
		System.out.println("Gravando Porte " + this.porte.getPorte());
		new DAO<Porte>(Porte.class).adiciona(porte);
		porte = new Porte();
		JSFMessageUtil.sendInfoMessageToUser("Porte cadastrado com sucesso!!!");
	}	

}




