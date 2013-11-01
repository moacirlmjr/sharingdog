package br.com.sd.util;

import java.util.ArrayList;

import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Porte;
import br.com.sd.modelo.Raca;
import br.com.sd.modelo.Recomendacao;
import br.com.sd.modelo.Role;
import br.com.sd.modelo.Usuario;
import br.com.sd.modelo.enumerator.Sexo;
import br.com.sd.security.SegurancaUtil;

public class ModeloUtil {
	
	public static ArrayList<Role> roles = new ArrayList<Role>();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ArrayList<Porte> portes = new ArrayList<Porte>();
	public static ArrayList<Raca> racas = new ArrayList<Raca>();
	public static ArrayList<Cachorro> cachorros = new ArrayList<Cachorro>();
	public static ArrayList<Interesse> interesses = new ArrayList<Interesse>();
	public static ArrayList<Recomendacao> recomendacoes = new ArrayList<Recomendacao>();	
	
	static{
		
		Role roleAdmin = new Role("Admin");
		Role roleUserDoador = new Role("UsuarioDoador");
		Role roleUserReceptor = new Role("UsuarioReceptor");
		
		roles.add(roleAdmin);
		roles.add(roleUserReceptor);
		roles.add(roleUserDoador);
		
		Usuario admin = new Usuario("Administrador",
				"administrador@sharingdog.com", "77665544", "@SharingDog",  Sexo.Masculino,
				"admin", "admin123", roleAdmin);
		
		Usuario danyllo = new Usuario("Danyllo Wagner",
				"danyllo_wagner@hotmail.com", "79009677", "@DanylloWagner", Sexo.Masculino,
				"danyllo", SegurancaUtil.criptografar("danyllo123"), roleUserReceptor);
		Usuario anelise = new Usuario("Anelise Trigo",
				"anelisecid@hotmail.com", "80339677", "@AneliseCid", Sexo.Feminino,
				"anelise", "anelise123", roleUserReceptor);
		Usuario roberto = new Usuario("Roberto Felicio",
				"prof.roberto.posse@hotmail.com", "81214567", "@Roberto_Felicio",  Sexo.Masculino,
				"roberto", "roberto123", roleUserReceptor);
		Usuario maria = new Usuario("Maria Joaquina", 
				"maria_joaquina@gmail.com", "99887766", "@Maria-Joaquina", Sexo.Feminino,
				"maria", "maria123", roleUserReceptor);
		Usuario joao = new Usuario("Joao Santos",
				"joaozito@gmail.com", "88776655", "@JoaozitoJP",  Sexo.Masculino,
				"joao", "joao123", roleUserReceptor);
		
		Usuario roberta = new Usuario("Roberta Albuquerque",
				"betabahia@gmail.com", "98765432", "@BetinhaBA", Sexo.Feminino,
				"roberta", "roberta123", roleUserDoador);
		Usuario marcos = new Usuario("Marcos Vinicius",
				"marcus_vinicius@yahoo.com.br", "87654321", "@MarcusNiteroi",  Sexo.Masculino,
				"marcos", "marcos123", roleUserDoador);
		Usuario patricia = new Usuario("Patricia Maia",
				"patricinharj@yahoo.com.br", "87654321", "@PatyGataRJ", Sexo.Feminino,
				"patricia", "patricia123", roleUserDoador);
		Usuario edson = new Usuario("Edson Lisboa",
				"edson_lisboa@yahoo.com.br", "65569887", "@EdinhoBH",  Sexo.Masculino,
				"edson", "edson123", roleUserDoador);
		Usuario dorgival = new Usuario("Dorgival Junior",
				"dorgivaljunior@golnaweb.com.br", "65569887", "@JuninhoGol",  Sexo.Masculino,
				"dorgival", "dorgival123", roleUserDoador);
		Usuario jairo = new Usuario("Jairo Albuquerque",
				"jairoconstrutor@ig.com.br", "32325454", "@JairoCimentoCG",  Sexo.Masculino,
				"jairo", "jairo123", roleUserDoador);
		Usuario josefa = new Usuario("Josefa Leite",
				"zelita-leite@otmail.com", "32325454", "@ZeliaCG", Sexo.Feminino,
				"josefa", "josefa123", roleUserDoador);
		Usuario virginia = new Usuario("Maria Virginia",
				"vininha@hotmail.com", "33310100", "@Vininha85", Sexo.Feminino,
				"virginia", "virginia123", roleUserDoador);
		Usuario antonio = new Usuario("Antonio Carlos",
				"acarloscid@uol.com", "32478110", "@ACarlosCID",  Sexo.Masculino,
				"antonio", "antonio123", roleUserDoador);
		Usuario mauro = new Usuario("Mauro Cesar",
				"maurinho2000@uol.com", "33294532", "@MaurinhoSurf",  Sexo.Masculino,
				"mauro", "mauro123", roleUserDoador);
		Usuario emanuele = new Usuario("Emmanuele Marie",
				"manu1985@hotmail.com", "88456776", "@ManuEnfermeira", Sexo.Feminino,
				"emanuele", "emanuele123", roleUserDoador);
		Usuario rodrigo = new Usuario("Rodrigo Maia",
				"rodrigo_maia@hotmail.com", "88776655", "@RodrigoMaromba",  Sexo.Masculino,
				"rodrigo", "rodrigo123", roleUserDoador);
		Usuario hadson = new Usuario("Hadson Barbosa",
				"hadson-ipira@hotmail.com", "88776655", "@HadsonIpira",  Sexo.Masculino,
				"hadson", "hadson123", roleUserDoador);
		Usuario larissa = new Usuario("Larissa Leôncio",
				"lalinhajp@hotmail.com", "88776655", "@Lalinha-jampa", Sexo.Feminino,
				"larissa", "larissa123", roleUserDoador);
		Usuario mauricio = new Usuario("Mauricio Linhares",
				"mauricio-linhares-jp@gmail.com", "88776655", "@MauricioTI",  Sexo.Masculino,
				"mauricio", "mauricio123", roleUserDoador);
		Usuario aliandro = new Usuario("Aiandro Dantas",
				"aliandro@gmail.com", "76544567", "@AliandroDataprev",  Sexo.Masculino,
				"aliandro", "aliandro123", roleUserDoador);
		Usuario joselia = new Usuario("Joselia Albuquerque",
				"jojo55@hotmail.com", "33310100", "@Jojo55CG", Sexo.Feminino,
				"joselia", "joselia123", roleUserDoador);
		Usuario teresa = new Usuario("Theresa gaiao",
				"teka2000@yahoo.com", "98987676", "@Tekinha2000", Sexo.Feminino,
				"teresa", "teresa123", roleUserDoador);
		Usuario elizabet = new Usuario("Elizabet Medeiros",
				"betty@virtual.ufpb.br", "23456789", "@BettyUFPB", Sexo.Feminino,
				"elizabet", "elizabet123", roleUserDoador);
		Usuario felipe = new Usuario("Felipe Brasileiro",
				"felipebr@hotmail.com", "34325456", "@FilipeComSoc",  Sexo.Masculino,
				"felipe", "felipe123", roleUserDoador);
		Usuario luis = new Usuario("Luis Claudio",
				"cyrillocav@hotmail.com", "33310100", "@cyrillocav",  Sexo.Masculino,
				"luis", "luis123", roleUserDoador);
		Usuario nilton = new Usuario("Nilton Batista",
				"nbmj@hotmail.com", "32321000", "@NiltonMoreno",  Sexo.Masculino,
				"nilton", "nilton123", roleUserDoador);		
		Usuario flavio = new Usuario("Flavio Mota",
				"flavio_motaj@hotmail.com", "87655678", "@FlavioNikiti",  Sexo.Masculino,
				"flavio", "flavio123", roleUserDoador);
		Usuario joaozao = new Usuario("Joao Loureiro",
				"joaozitocg@hotmail.com", "99887766", "@Joao1990",  Sexo.Masculino,
				"joao", "joao123", roleUserDoador);
		Usuario monique = new Usuario("Monique Nascimento",
				"moniquedf@hotmail.com", "88777788", "@NikiDF1984",  Sexo.Feminino,
				"monique", "monique123", roleUserDoador);
		Usuario gabriela = new Usuario("Gabriela Albuquerque",
				"gabyalbuquerqie@hotmail.com", "33359609", "@Gaby2000",  Sexo.Feminino,
				"gabriela", "gabriela123", roleUserDoador);

		
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
		usuarios.add(josefa);
		usuarios.add(virginia);
		usuarios.add(antonio);
		usuarios.add(mauro);
		usuarios.add(emanuele);
		usuarios.add(rodrigo);
		usuarios.add(hadson);
		usuarios.add(mauricio);
		usuarios.add(aliandro);
		usuarios.add(larissa);
		usuarios.add(joselia);
		usuarios.add(teresa);
		usuarios.add(elizabet);
		usuarios.add(felipe);
		usuarios.add(luis);
		usuarios.add(nilton);
		usuarios.add(flavio);
		usuarios.add(joaozao);
		usuarios.add(monique);
		usuarios.add(gabriela);

		
				
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
		
		
		Cachorro yankee = new Cachorro("Yankee", pastorAlemao, edson, RetornoDataUtil.getRandomDataNascimento(), Sexo.Masculino);
		Cachorro baleia = new Cachorro("baleia", pastorAlemao, roberta, RetornoDataUtil.getRandomDataNascimento(), Sexo.Feminino);
		Cachorro tonhao = new Cachorro("Tonhão", saoBernado, dorgival, RetornoDataUtil.getRandomDataNascimento(), Sexo.Masculino);
		Cachorro bilola = new Cachorro("Bilola", saoBernado, jairo, RetornoDataUtil.getRandomDataNascimento(), Sexo.Masculino);
		
		cachorros.add(yankee);
		cachorros.add(baleia);
		cachorros.add(tonhao);
		cachorros.add(bilola);
		
		Interesse i1 = new Interesse(maria, pinscher);
		Interesse i2 = new Interesse(gabriela, poodle);
		Interesse i3 = new Interesse(danyllo, pastorAlemao);
		Interesse i4 = new Interesse(danyllo, saoBernado);
		
		interesses.add(i1);
		interesses.add(i2);
		interesses.add(i3);
		interesses.add(i4);
		
		ArrayList<Cachorro> cachorrosRec = new ArrayList<Cachorro>();
		cachorrosRec.add(yankee);
		cachorrosRec.add(baleia);
		
		Recomendacao r1 = new Recomendacao(i3, cachorrosRec);
		recomendacoes.add(r1);



		
		
		
	}
		
	
	

}
