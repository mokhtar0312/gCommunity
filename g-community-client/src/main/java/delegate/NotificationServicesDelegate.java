package delegate;

import java.util.List;

import entities.Message;
import entities.Notification;
import locator.ServiceLocator;
import anis.interfaces.AdminServiceRemote;
import anis.interfaces.NotificationServiceRemote;

public class NotificationServicesDelegate {
	public static NotificationServiceRemote remote;
	private static final String jndi = "/g-community-ejb/NotificationService!anis.interfaces.NotificationServiceRemote";
	
	public static NotificationServiceRemote getProxy() {
		return (NotificationServiceRemote) ServiceLocator.getInstance().getProxy(jndi);
	}
	public static Boolean ajouterNotification(Notification notification) {
		return getProxy().ajouterNotification(notification);
	}
	public static List<Notification> readAllNotifications(){
		return getProxy().readAllNotifications();
	}
	public static Boolean deleteNotificationById(Integer id) {
		return getProxy().deleteNotificationById(id);
	}
	public static Boolean updateNotification(Notification notification) {
		return getProxy().updateNotification(notification);
	}
	public static  Message getMessageFromNotificationTable(Integer id) {
		return getProxy().getMessageFromNotificationTable(id);
	}
	public static List<Notification> readAllNotificationsStocks() {
		return getProxy().readAllNotificationsStocks();
	}
}
