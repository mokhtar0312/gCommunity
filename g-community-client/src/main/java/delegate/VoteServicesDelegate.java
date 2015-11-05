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

	private static Boolean addVote(Vote vote, Integer idMember) {
		return getProxy().addVote(vote, idMember);
	}

	private static Vote findVoteById(Integer id) {
		return getProxy().findVoteById(id);
	}

	private static Boolean updateVote(Vote vote) {
		return getProxy().updateVote(vote);
	}

	private static Boolean deleteVote(Integer id) {
		return getProxy().deleteVote(id);
	}

	private static List<Vote> findAllVotes() {
		return getProxy().findAllVotes();
	}

}
