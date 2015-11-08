package delegate;

import java.util.List;

import locator.ServiceLocator;
import anis.interfaces.MessageServiceRemote;
import entities.ActiveMember;
import entities.Message;
import entities.Notification;

public class MessageServicesDelegate {

	public static MessageServiceRemote remote;
	private static final String jndi = "/g-community-ejb/MessageService!anis.interfaces.MessageServiceRemote";

	public static MessageServiceRemote getProxy() {
		return (MessageServiceRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}

	public static Boolean ajouterMessage(Message message
			) {
		return getProxy().ajouterMessage(message);
	}

	public static List<Message> readAllMessage() {
		return getProxy().readAllMessage();
	}

	public static Boolean deleteMessageById(Integer id) {
		return getProxy().deleteMessageById(id);
	}

	public static Boolean updateMessage(Message message) {
		return getProxy().updateMessage(message);
	}

	public static Message findMessageById(Integer id) {
		return getProxy().findMessageById(id);
	}

	public static ActiveMember findActiveMemeberByUsername(String username) {
		return getProxy().findActiveMemeberByUsername(username);
	}

	public static ActiveMember findActiveMemberById(int i) {
		return getProxy().findActiveMemberById(i);
	}

	public static ActiveMember findActiveMemberByEmail(String email) {
		return getProxy().findActiveMemberByEmail(email);
	}

	public static List<Message> readAllMessageByIDActiveMember(
		ActiveMember activeMember) {
		return getProxy().readAllMessageByIDActiveMember(activeMember);
	}
	public static  List<Message> findAllMessage() {
		return getProxy().findAllMessage();
	}
}
