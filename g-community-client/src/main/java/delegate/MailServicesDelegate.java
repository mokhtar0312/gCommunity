package delegate;

import java.io.IOException;

import locator.ServiceLocator;
import services.interfaces.mailRemote;

public class MailServicesDelegate {

	private static mailRemote remote;
	private static final String jndi = "/g-community-ejb/mail!services.interfaces.mailRemote";

	private static mailRemote getProxy() {
		return (mailRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static void doMail(String subject, String text, String destinataire)
			throws IOException {
		getProxy().mail(subject, text, destinataire);;
		;
	}
}
