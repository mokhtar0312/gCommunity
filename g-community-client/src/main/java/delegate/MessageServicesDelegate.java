package delegate;

import entities.Message;
import entities.Notification;
import locator.ServiceLocator;
import anis.interfaces.AdminServiceRemote;
import anis.interfaces.MessageServiceRemote;

public class MessageServicesDelegate {

	public static MessageServiceRemote remote;
	private static final String jndi = "/g-community-ejb/MessageService!anis.interfaces.MessageServiceRemote";
	
	public static MessageServiceRemote getProxy() {
		return (MessageServiceRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}

	public static Boolean ajouterMessage(Message message,Notification notification) {
		return getProxy().ajouterMessage(message, notification);
	}
}
