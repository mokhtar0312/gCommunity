package delegate;

import java.util.List;

import locator.ServiceLocator;
import anis.interfaces.AdminServiceRemote;
import entities.ActiveMember;
import entities.Message;
import entities.Notification;

public class AdminServicesDelegate {
	public static AdminServiceRemote remote;
	private static final String jndi = "/g-community-ejb/AdminService!anis.interfaces.AdminServiceRemote";

	public static AdminServiceRemote getProxy() {
		return (AdminServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean ajouterMessage(Message message) {
		return getProxy().ajouterMessage(message);
	}

	public static List<Integer> readAllNotificationsCountStock(
			ActiveMember activeMember) {
		return getProxy().readAllNotificationsCountStock(activeMember);
	}

	public static List<Notification> readAllNotifications() {
		return getProxy().readAllNotifications();
	}

	public static List<Integer> readAllNotificationsCount() {
		return getProxy().readAllNotificationsCount();
	}

	public static List<Integer> readAllNotificationsCountMessage(
			ActiveMember activeMember) {
		return getProxy().readAllNotificationsCountMessage(activeMember);
	}

}
