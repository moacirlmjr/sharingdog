package br.com.sd.util;



public class MailUtil {

	/*private static final String ACOOUNT_USER = "sharingdog";
	private static final String MAIL_USER = "sharingdog@gmail.com";
	private static final String MAIL_PWD = "pucsharingdog";
	private static final String MAIL_TITLE = "Relat�rio de Ocupacao";
	private static final String MAIL_OWNER = "SharingDog";

	@SuppressWarnings("deprecation")
	public void enviaEmailSimples() throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(estadia.getUsuario().getEmail()); // pode ser qualquer
															// email
			email.setFrom(MailUtil.MAIL_USER); // será passado o email que você
												// fará
												// a autenticação
			email.setSubject(MailUtil.MAIL_TITLE + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Olá, senhor "
					+ estadia.getUsuario().getNome()
					+ "\n"
					+ "Através deste email estamos relatando os dados da sua ocupação no MyParis Hotel."
					+ "\n" + "Seguem os dados: " + "\n \n" + "Quarto: "
					+ estadia.getQuarto().getCategoria().getCategoria() + "\n"
					+ "Data inicio: "
					+ sdf.format(estadia.getDataInicio().getTime()) + "\n"
					+ "Data fim: " + sdf.format(estadia.getDataFim().getTime())
					+ "\n" + "Cama Extra: "
					+ (estadia.isCamaExtra() == false ? "Não" : "Sim") + "\n"
					+ "Valor Total: " + estadia.getValorTotal() + "\n" + "\n"
					+ "O MyParis Hotel agradece sua preferência!!!" + "\n"
					+ "Volte sempre!");
			email.send();

		} catch (EmailException e) {

			System.out.println(e.getMessage());

		}
	}
*/
}