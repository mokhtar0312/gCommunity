package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.SimpleMemberServicesRemote;
import entities.SimpleMember;

public class SimpleMemberdelegate {
	private static SimpleMemberServicesRemote remote;
	private static final String jndi = "/g-community-ejb/SimpleMemberServices!services.interfaces.SimpleMemberServicesRemote";

	private static SimpleMemberServicesRemote getProxy() {
		return (SimpleMemberServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	

	public static Boolean doAddSimpleMember(SimpleMember SimpleMember){
		return getProxy().addSimpleMember(SimpleMember);
	}

	public static Boolean doDeleteSimpleMemberById(Integer id){
		return getProxy().deleteSimpleMemberById(id);
	}

	public static SimpleMember doFindSimpleMemberById(Integer id){
		return getProxy().findSimpleMemberById(id);
	}

	public static Boolean doUpdateSimpleMember(SimpleMember SimpleMember){
		return getProxy().updateSimpleMember(SimpleMember);
	}

	public static Boolean doDeleteEmployee(SimpleMember SimpleMember){
		return getProxy().deleteSimpleMember(SimpleMember);
	}

	public static List<SimpleMember> doFindAllSimpleMember(){

		return getProxy().findAllSimpleMember();
	}
	
}
