package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.SimpleMember;

@Local
public interface SimpleMemberServicesLocal {
Boolean addSimpleMember(SimpleMember simpleMember);
	
	Boolean deleteSimpleMemberById(Integer id);

	SimpleMember findSimpleMemberById(Integer id);

	Boolean updateSimpleMember(SimpleMember simpleMember);

	Boolean deleteEmployee(SimpleMember simpleMember);

	List<SimpleMember> findAllSimpleMember();

}
