package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.ActiveMember;
import entities.Vote;

@Remote
public interface VoteServicesRemote {

	Boolean addVote(Vote vote,Integer idMember);
	Vote findVoteById(Integer id);
	Boolean updateVote(Vote vote);
	Boolean deleteVote(Integer id);
	List<Vote> findAllVotes();
	Boolean Vote(Integer year, ActiveMember voter,
			ActiveMember voted);
}
