package br.com.sd.mbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tema;
	
	public TemaBean(){
		tema = "aristo";
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	// temas disponíveis dentro do JAR All-themes.jar
	public List<String> getTemas() {
		return Arrays.asList("aristo", "black-tie", "blitzer", "bluesky",
				"casablanca", "cupertino", "dark-hive", "dot-luv", "eggplant",
				"excite-bike", "flick", "glass-x", "hot-sneaks", "humanity",
				"le-frog", "midnight", "mint-choc", "overcast",
				"pepper-grinder", "redmond", "rocket", "sam", "smoothness",
				"south-street", "start", "sunny", "swanky-purse", "trontastic",
				"ui-darkness", "ui-lightness", "vader");
	}
}
