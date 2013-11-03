package br.com.sd.mbeans;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import br.com.sd.modelo.Usuario;
import br.com.sd.dao.DAO;
import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Raca;
import br.com.sd.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class CachorroBean {

	private Cachorro cachorro;
	private Integer racaID;

	public CachorroBean() {
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

	public List<Cachorro> getCachorros() {
		return new DAO<Cachorro>(Cachorro.class).listaTodos();
	}

	public List<Cachorro> getCachorrosOrdenadosNomeERaca() {
		return new DAO<Cachorro>(Cachorro.class)
				.findListResults(Cachorro.findAllCachorrosOrdenadosRaca);
	}

	public void validaDataNascimento(FacesContext context, UIComponent component,
			Object value) {

		Date dataInicio = (Date) value;

		Date hoje = (Date) Calendar.getInstance().getTime();
		if (hoje.after(dataInicio)) {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(dataInicio.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
			this.cachorro.setDataNascimento(c);
		} else {
			throw new ValidatorException(new FacesMessage(
					"Data de nascimento eh maior ou igual a hoje"));
		}
	}

	public List<Cachorro> getCachorrosUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", doador.getId());
		return new DAO<Cachorro>(Cachorro.class).findListResults(
				Cachorro.findAllCachorrosUser, params);
	}

	public void gravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		Raca r = new DAO<Raca>(Raca.class).buscaPorId(racaID);
		this.cachorro.setDono(doador);
		this.cachorro.setRaca(r);
		System.out.println("adicionando o cachorro" + this.cachorro.getNome()
				+ "do doador" + this.cachorro.getDono().getNome());
		new DAO<Cachorro>(Cachorro.class).adiciona(cachorro);
		JSFMessageUtil.sendInfoMessageToUser(this.cachorro.getNome() + " adicionado com sucesso!!!");

	}

}
