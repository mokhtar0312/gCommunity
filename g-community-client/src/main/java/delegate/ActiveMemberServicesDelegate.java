package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.ActiveMemberServicesRemote;
import entities.ActiveMember;
import entities.Vote;

public class ActiveMemberServicesDelegate {
	private static ActiveMemberServicesRemote remote;
	private static final String jndi = "/g-community-ejb/ActiveMemberServices!services.interfaces.ActiveMemberServicesRemote";

	private static ActiveMemberServicesRemote getProxy() {
		return (ActiveMemberServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	

	public static Boolean doAddActiveMember(ActiveMember activeMember){
		return getProxy().addActiveMember(activeMember);
	}

	public static Boolean doDeleteActiveMemberById(Integer id){
		return getProxy().deleteActiveMemberById(id);
	}

	public static ActiveMember doFindActiveMemberById(Integer id){
		return getProxy().findActiveMemberById(id);
	}

	public static Boolean doUpdateActiveMember(ActiveMember activeMember){
		return getProxy().updateActiveMember(activeMember);
	}

	public static Boolean doDeleteEmployee(ActiveMember activeMember){
		return getProxy().deleteActiveMember(activeMember);
	}

	public static List<ActiveMember> doFindAllActiveMember(){

		return getProxy().findAllActiveMember();
	}
	public static ActiveMember doFindActiveMemberByUserName(String username){
		return getProxy().findActiveMemberByUserName(username);
	}
}
