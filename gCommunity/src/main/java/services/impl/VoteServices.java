package services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.ActiveMember;
import entities.Streams;
import entities.Vote;
import services.interfaces.ActiveMemberServicesLocal;
import services.interfaces.VoteServicesLocal;
import services.interfaces.VoteServicesRemote;

/**
 * Session Bean implementation class VoteServices
 */
@Stateless
@LocalBean
public class VoteServices implements VoteServicesRemote, VoteServicesLocal {
	@PersistenceContext
	EntityManager entitymanager;
@EJB	
	private ActiveMemberServicesLocal activeMemberServices;
	
    /**
     * Default constructor. 
     */
    public VoteServices() {
       
    }

	@Override
	public Boolean addVote(Vote vote, Integer idMember) {
		 boolean b=false;
	        try {
	        	ActiveMember memberFound = activeMemberServices.
	        			findActiveMemberById(idMember);
				vote.setActiveMember(memberFound);	
				entitymanager.merge(vote);
				b=true;
				
				
			} catch (Exception e) {
				System.err.println("problem ...");
			}
	        return b;
	}

	@Override
	public Vote findVoteById(Integer id) {
		return entitymanager.find(Vote.class, id);
		
	}

	@Override
	public Boolean updateVote(Vote vote) {
		boolean b=false;
		try {
			entitymanager.merge(vote);
			b=true;
			
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean deleteVote(Integer id) {
		boolean b=false;
		try {
			entitymanager.remove(findVoteById(id));
			
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public List<Vote> findAllVotes() {
		
		String jpql = "select v from Vote s";
		Query query = entitymanager.createQuery(jpql);
		
		return query.getResultList();
	}

	

}
