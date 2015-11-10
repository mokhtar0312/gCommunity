package delegate;

import locator.ServiceLocator;

import services.interfaces.AuthentificationRemote;
import entities.ActiveMember;

public class AuthentificationDelegate {
	private static AuthentificationRemote remote;
	private static final String jndi = "/g-community-ejb/Authentification!services.interfaces.AuthentificationRemote";

	private static AuthentificationRemote getProxy() {
		return (AuthentificationRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	

	public static Boolean doConnect(ActiveMember activeMember){
		return getProxy().connect(activeMember);
	}
	public static Boolean doDisconnect(){
		return getProxy().disconect();
	}
	public static ActiveMember doGetConectedPerson(){
		return getProxy().getConectedPerson();
	}

}
