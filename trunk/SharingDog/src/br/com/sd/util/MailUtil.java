package br.com.sd.util;

import java.text.SimpleDateFormat;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.sd.modelo.Interesse;
import br.com.sd.modelo.Recomendacao;
import br.com.sd.modelo.Usuario;



public class MailUtil {

	private static final String ACOOUNT_USER = "sharingdog";
	private static final String MAIL_USER = "sharingdog@gmail.com";
	private static final String MAIL_PWD = "pucsharingdog";
	private static final String MAIL_OWNER = "SharingDog";

	@SuppressWarnings("deprecation")
	public static void enviaEmailBoasVindas(Usuario user) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Boas Vindas" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("OlÃ¡, senhor "
					+ user.getNome()
					+ "\n"
					+ "Seja muito bem vindo ao Sharing Dog!!!"
					+ "\n" + 
					"Será uma grande satisfação realizar seu encontro com um dos nossos cachorros." 
					+ "\n" +
					"A partir de agora cadastre seus interesses e verifique sua conta periodicamente." 
					+ "\n" +
					"Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" +
					"Até Breve!");
			email.send();

		} catch (EmailException e) {

			System.out.println(e.getMessage());

		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void enviaEmailInteresse(Interesse interesse) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = interesse.getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Cadastro de Interesse" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Olá, senhor "
					+ user.getNome()
					+ "\n"
					+ "Informamos que seu iteresse em " + interesse.getRacasDeInteresse().getRaca() 
					+ " foi cadastrado com sucesso em nassa base de dados!"
					+ "\n" + 
					"Em breve estaremos enviando algumas sugestões com base na sua preferência." 
					+ "\n" +
					"Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" +
					"Até Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void enviaEmailRecomendacao(Recomendacao rec) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = rec.getInteresse().getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Recomendação de animal" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Olá, senhor "
					+ user.getNome()
					+ "\n"
					+ "Temos um cachorro que pode ser do seu interesse! " 
					+ "\n" + 
					"Nome: " + rec.getCachorro().getNome() 
					+ "\n" + 
					"Raca: " + rec.getCachorro().getRaca().getRaca() 
					+ "\n" + 
					"Sexo: " + rec.getCachorro().getSexo() 
					+ "\n" + 
					  "\n" + 		
					"Abaixo segue os dados do dono do animal: "
					+ "\n" + 
					"Nome: " + rec.getCachorro().getDono().getNome() 
					+ "\n" +
					"Telefone: " + rec.getCachorro().getDono().getTelefone() 
					+ "\n" +
					"Email: " + rec.getCachorro().getDono().getEmail()
					+ "\n \n" +
					"Gostou do animal? entre em contato com o dono para os acertos finais!!!"
					+ "\n" +
					"Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" +
					"Até Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}


}