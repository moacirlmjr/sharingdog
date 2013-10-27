package br.com.sd.util;

import java.util.ArrayList;

import sun.security.provider.MD5;
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
		Usuario josefa = new Usuario("Josefa Leite",
				"zelita-leite@otmail.com", "32325454", "@ZeliaCG",
				"josefa", "josefa123", roleUserDoador);
		Usuario virginia = new Usuario("Maria Virginia",
				"vininha@hotmail.com", "33310100", "@Vininha85",
				"virginia", "virginia123", roleUserDoador);
		Usuario antonio = new Usuario("Antonio Carlos",
				"acarloscid@uol.com", "32478110", "@ACarlosCID",
				"antonio", "antonio123", roleUserDoador);
		Usuario mauro = new Usuario("Mauro Cesar",
				"maurinho2000@uol.com", "33294532", "@MaurinhoSurf",
				"mauro", "mauro123", roleUserDoador);
		Usuario emanuele = new Usuario("Emmanuele Marie",
				"manu1985@hotmail.com", "88456776", "@ManuEnfermeira",
				"emanuele", "emanuele123", roleUserDoador);
		Usuario rodrigo = new Usuario("Rodrigo Maia",
				"rodrigo_maia@hotmail.com", "88776655", "@RodrigoMaromba",
				"rodrigo", "rodrigo123", roleUserDoador);
		Usuario hadson = new Usuario("Hadson Barbosa",
				"hadson-ipira@hotmail.com", "88776655", "@HadsonIpira",
				"hadson", "hadson123", roleUserDoador);
		Usuario larissa = new Usuario("Larissa Leôncio",
				"lalinhajp@hotmail.com", "88776655", "@Lalinha-jampa",
				"larissa", "larissa123", roleUserDoador);
		Usuario mauricio = new Usuario("Mauricio Linhares",
				"mauricio-linhares-jp@gmail.com", "88776655", "@MauricioTI",
				"mauricio", "mauricio123", roleUserDoador);
		Usuario aliandro = new Usuario("Aiandro Dantas",
				"aliandro@gmail.com", "76544567", "@AliandroDataprev",
				"aliandro", "aliandro123", roleUserDoador);
		Usuario joselia = new Usuario("Joselia Albuquerque",
				"jojo55@hotmail.com", "33310100", "@Jojo55CG",
				"joselia", "joselia123", roleUserDoador);
		Usuario teresa = new Usuario("Theresa gaiao",
				"teka2000@yahoo.com", "98987676", "@Tekinha2000",
				"teresa", "teresa123", roleUserDoador);
		Usuario elizabet = new Usuario("Elizabet Medeiros",
				"betty@virtual.ufpb.br", "23456789", "@BettyUFPB",
				"elizabet", "elizabet123", roleUserDoador);
		Usuario felipe = new Usuario("Felipe Brasileiro",
				"felipebr@hotmail.com", "34325456", "@FilipeComSoc",
				"felipe", "felipe123", roleUserDoador);
		Usuario luis = new Usuario("Luis Claudio",
				"jojo55@hotmail.com", "33310100", "@Jojo55CG",
				"luis", "luis123", roleUserDoador);
		Usuario joselia = new Usuario("Joselia Albuquerque",
				"jojo55@hotmail.com", "33310100", "@Jojo55CG",
				"joselia", "joselia123", roleUserDoador);

		
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
		Raca dogAlemao = new Raca("Dog Alemao", grande);
		Raca labrador = new Raca("Labrador", grande);
		Raca akita = new Raca("Akita", grande);
		Raca viralatag = new Raca("Vira-lata", grande);

		
		Raca Beagle = new Raca("Beagle", medio);
		Raca cockerSpaniel = new Raca("Cocker Spaniel", medio);
		Raca pitbull = new Raca("Pit Bull", medio);
		Raca foxPaulista = new Raca("Terrier Brasileiro", medio);
		Raca bulldog = new Raca("BullDog", medio);
		Raca schnauzer = new Raca("Schnauzer", medio);
		Raca bullmastiff = new Raca("Bullmastiff", medio);
		Raca viralatam = new Raca("Vira-lata", medio);

		
		
		Raca chihuahua = new Raca("Chihuahua", pequeno);
		Raca poodle = new Raca("Poodle", pequeno);
		Raca basset = new Raca("Basset Hound", pequeno);
		Raca pinscher = new Raca("Pincher", pequeno);
		Raca maltes = new Raca("Maltss", pequeno);
		Raca yorkshire = new Raca("Yorkshire", pequeno);
		Raca shitsu = new Raca("Shitsu", pequeno);
		Raca viralatap = new Raca("Vira-lata", pequeno);

		
		racas.add(pastorAlemao);
		racas.add(saoBernado);
		racas.add(goldenRetrieve);
		racas.add(dalmata);
		racas.add(dogAlemao);
		racas.add(labrador);
		racas.add(akita);
		racas.add(viralatag);
		
		racas.add(Beagle);
		racas.add(cockerSpaniel);
		racas.add(pitbull);
		racas.add(foxPaulista);
		racas.add(bulldog);
		racas.add(schnauzer);
		racas.add(bullmastiff);
		racas.add(viralatam);
		
		racas.add(chihuahua);
		racas.add(poodle);
		racas.add(basset);
		racas.add(pinscher);
		racas.add(maltes);
		racas.add(yorkshire);
		racas.add(shitsu);
		racas.add(viralatap);
		
		
		Cachorro yankee = new Cachorro("Yankee", pastorAlemao, edson, RetornoDataUtil.getRandomDataNascimento());
		Cachorro baleia = new Cachorro("baleia", pastorAlemao, roberta, RetornoDataUtil.getRandomDataNascimento());
		Cachorro tonhao = new Cachorro("Tonhão", saoBernado, dorgival, RetornoDataUtil.getRandomDataNascimento());
		Cachorro bilola = new Cachorro("Bilola", saoBernado, jairo, RetornoDataUtil.getRandomDataNascimento());
		
		cachorros.add(yankee);
		cachorros.add(baleia);
		cachorros.add(tonhao);
		cachorros.add(bilola);
		
		
	}
		
	
	

}
