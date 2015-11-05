package delegate;

import java.util.List;

import javax.validation.Path.ReturnValueNode;

import entities.ActiveMember;
import entities.Message;
import entities.Notification;
import locator.ServiceLocator;
import anis.interfaces.AdminServiceRemote;

public class AdminServicesDelegate {
public static AdminServiceRemote remote;
private static final String jndi = "/g-community-ejb/AdminService!anis.interfaces.AdminServiceRemote";

private static AdminServiceRemote getProxy() {
	return (AdminServiceRemote) ServiceLocator.getInstance().getProxy(
			jndi);
}
private static  Boolean ajouterMessage(Message message){
	return getProxy().ajouterMessage(message);
}
private static List<Integer>  readAllNotificationsCountStock(ActiveMember activeMember) {
	return getProxy().readAllNotificationsCountStock(activeMember);
}

private static List<Notification> readAllNotifications(){
	return getProxy().readAllNotifications();
}
private static List<Integer>  readAllNotificationsCount() {
	return getProxy().readAllNotificationsCount();
}
private static List<Integer>  readAllNotificationsCountMessage(ActiveMember activeMember) {
	return getProxy().readAllNotificationsCountMessage(activeMember);
}

}
