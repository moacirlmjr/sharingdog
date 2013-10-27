package br.com.sd.util;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Porte;
import br.com.sd.modelo.Raca;
import br.com.sd.modelo.Role;
import br.com.sd.modelo.Usuario;

public class ModeloUtil {
	
	public static ArrayList<Role> roles = new ArrayList<Role>();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ArrayList<Porte> portes = new ArrayList<Porte>();
	public static ArrayList<Raca> racas = new ArrayList<Raca>();
	public static ArrayList<Cachorro> cachorros = new ArrayList<Cachorro>();
	
	static{
		
		Role roleAdmin = new Role("Admin");
		Role roleUserDoador = new Role("UsuarioDoador");
		Role roleUserReceptor = new Role("UsuarioReceptor");
		
		roles.add(roleAdmin);
		roles.add(roleUserReceptor);
		roles.add(roleUserDoador);
		
		Usuario admin = new Usuario("Administrador",
				"administrador@sharingdog.com", "77665544", "@SharingDog",
				"admin", "admin123", roleAdmin);
		Usuario danyllo = new Usuario("Danyllo Wagner",
				"danyllo_wagner@hotmail.com", "79009677", "@DanylloWagner",
				"danyllo", "danyllo123", roleUserReceptor);
		Usuario anelise = new Usuario("Anelise Trigo",
				"anelisecid@hotmail.com", "80339677", "@AneliseCid",
				"anelise", "anelise123", roleUserReceptor);
		Usuario roberto = new Usuario("Roberto Felicio",
				"prof.roberto.posse@hotmail.com", "81214567", "@Roberto_Felicio",
				"roberto", "roberto123", roleUserReceptor);
		Usuario maria = new Usuario("Maria Joaquina",
				"maria_joaquina@gmail.com", "99887766", "@Maria-Joaquina",
				"maria", "maria123", roleUserReceptor);
		Usuario joao = new Usuario("Joao Santos",
				"joaozito@gmail.com", "88776655", "@JoaozitoJP",
				"joao", "joao123", roleUserReceptor);
		Usuario roberta = new Usuario("Roberta Albuquerque",
				"betabahia@gmail.com", "98765432", "@BetinhaBA",
				"roberta", "roberta123", roleUserDoador);
		Usuario marcos = new Usuario("Marcos Vinicius",
				"marcus_vinicius@yahoo.com.br", "87654321", "@MarcusNiteroi",
				"marcos", "marcos123", roleUserDoador);
		Usuario patricia = new Usuario("Patricia Maia",
				"patricinharj@yahoo.com.br", "87654321", "@PatyGataRJ",
				"patricia", "patricia123", roleUserDoador);
		Usuario edson = new Usuario("Edson Lisboa",
				"edson_lisboa@yahoo.com.br", "65569887", "@EdinhoBH",
				"edson", "edson123", roleUserDoador);
		Usuario dorgival = new Usuario("Dorgival Junior",
				"dorgivaljunior@golnaweb.com.br", "65569887", "@JuninhoGol",
				"dorgival", "dorgival123", roleUserDoador);
		Usuario jairo = new Usuario("Jairo Albuquerque",
				"jairoconstrutor@ig.com.br", "32325454", "@JairoCimentoCG",
				"jairo", "jairo123", roleUserDoador);
		
		usuarios.add(admin);
		usuarios.add(danyllo);
		usuarios.add(anelise);
		usuarios.add(roberto);
		usuarios.add(maria);
		usuarios.add(joao);
		usuarios.add(roberta);
		usuarios.add(marcos);
		usuarios.add(patricia);
		usuarios.add(edson);
		usuarios.add(dorgival);
		usuarios.add(jairo);
		
		
		Porte grande = new Porte("Grande");
		Porte medio = new Porte("medio");
		Porte pequeno = new Porte("pequeno");
		
		portes.add(grande);
		portes.add(medio);
		portes.add(pequeno);
		
		Raca pastorAlemao = new Raca("Pastor Alemao", grande);
		Raca saoBernado = new Raca("Sao Bernado", grande);
		Raca goldenRetrieve = new Raca("Golden Retrieve", grande);
		Raca dalmata = new Raca("Dalmata", grande);
		Raca dogAlemao = new Raca("Dog Alemão", grande);
		
		Raca Beagle = new Raca("Beagle", medio);
		Raca cockerSpaniel = new Raca("Cocker Spaniel", medio);
		Raca pitbull = new Raca("Pit Bull", medio);
		Raca foxPaulista = new Raca("Terrier Brasileiro", medio);
		Raca bulldog = new Raca("BullDog", medio);
		
		
		Raca chihuahua = new Raca("Chihuahua", pequeno);
		Raca poodle = new Raca("Poodle", pequeno);
		Raca basset = new Raca("Basset Hound", pequeno);
		Raca pinscher = new Raca("Pinscher", pequeno);
		Raca maltes = new Raca("Maltês", pequeno);
		
		racas.add(pastorAlemao);
		racas.add(saoBernado);
		racas.add(goldenRetrieve);
		racas.add(dalmata);
		racas.add(dogAlemao);
		
		racas.add(Beagle);
		racas.add(cockerSpaniel);
		racas.add(pitbull);
		racas.add(foxPaulista);
		racas.add(bulldog);
		
		racas.add(chihuahua);
		racas.add(poodle);
		racas.add(basset);
		racas.add(pinscher);
		racas.add(maltes);
		
		Calendar d1 = Calendar.getInstance();
		d1.set(2012, 10, 12);
		Cachorro yankee = new Cachorro("Yankee", pastorAlemao, edson, d1);
		d1.set(2011, 06, 11);
		Cachorro baleia = new Cachorro("baleia", pastorAlemao, roberta, d1);
		d1.set(2012, 10, 7);
		Cachorro tonhao = new Cachorro("Tonhão", saoBernado, dorgival, d1);
		d1.set(2012, 10, 7);
		Cachorro bilola = new Cachorro("Bilola", saoBernado, jairo, d1);
		
		cachorros.add(yankee);
		cachorros.add(baleia);
		cachorros.add(tonhao);
		cachorros.add(bilola);
		
		
	}
		
	
	

}
