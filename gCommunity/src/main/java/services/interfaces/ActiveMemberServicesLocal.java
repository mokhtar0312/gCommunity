package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.ActiveMember;

@Local
public interface ActiveMemberServicesLocal {
	Boolean addActiveMember(ActiveMember activeMember);

	Boolean deleteActiveMemberById(Integer id);

	ActiveMember findActiveMemberById(Integer id);

	Boolean updateActiveMember(ActiveMember activeMember);

	Boolean deleteEmployee(ActiveMember activeMember);

	List<ActiveMember> findAllActiveMember();

}
