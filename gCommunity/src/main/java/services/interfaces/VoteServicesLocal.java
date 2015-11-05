package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Vote;

@Local
public interface VoteServicesLocal {

	Boolean addVote(Vote vote,Integer idMember);
	Vote findVoteById(Integer id);
	Boolean updateVote(Vote vote);
	Boolean deleteVote(Integer id);
	List<Vote> findAllVotes();
}