package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.VoteServicesRemote;
import entities.Vote;

public class VoteServicesDelegate {

	private static VoteServicesRemote remote;
	private static final String jndi = "/g-community-ejb/VoteServices!services.interfaces.VoteServicesRemote";

	private static VoteServicesRemote getProxy() {
		return (VoteServicesRemote) ServiceLocator.getInstance().getProxy(jndi);
	}

	public static Boolean addVote(Integer year, Integer idMembervoter, Integer idMembervoted) {
		return getProxy().addVote(year, idMembervoter, idMembervoted);
	}

	public static Vote findVoteById(Integer id) {
		return getProxy().findVoteById(id);
	}

	public static Boolean updateVote(Vote vote) {
		return getProxy().updateVote(vote);
	}

	public static Boolean deleteVote(Integer id) {
		return getProxy().deleteVote(id);
	}

	public static List<Vote> findAllVotes() {
		return getProxy().findAllVotes();
	}
	
	

}
