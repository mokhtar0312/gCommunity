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
	

	public static Boolean addActiveMember(ActiveMember activeMember){
		return getProxy().addActiveMember(activeMember);
	}

	public static Boolean deleteActiveMemberById(Integer id){
		return getProxy().deleteActiveMemberById(id);
	}

	public static ActiveMember findActiveMemberById(Integer id){
		return getProxy().findActiveMemberById(id);
	}

	public static Boolean updateActiveMember(ActiveMember activeMember){
		return getProxy().updateActiveMember(activeMember);
	}

	public static Boolean deleteEmployee(ActiveMember activeMember){
		return getProxy().deleteActiveMember(activeMember);
	}

	public static List<ActiveMember> findAllActiveMember(){

		return getProxy().findAllActiveMember();
	}
}
