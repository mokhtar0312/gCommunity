package anis;

import java.util.List;

import anis.interfaces.MessageServiceLocal;
import anis.interfaces.MessageServiceRemote;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.ActiveMember;
import entities.Message;
import entities.Notification;

/**
 * Session Bean implementation class MessageService
 */
@Stateful
@LocalBean
public class MessageService implements MessageServiceRemote, MessageServiceLocal {
	@PersistenceContext
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public MessageService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean ajouterMessage(Message message, Notification notification) {
		Boolean b = false;
		try {
			entityManager.persist(message);
			entityManager.persist(notification);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public List<Message> readAllMessage() {
		String jpql = "select m from Message m ";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean deleteMessageById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.find(Message.class, id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean updateMessage(Message message) {
		Boolean b = false;
		try {
			entityManager.merge(message);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Message findMessageById(Integer id) {
		return entityManager.find(Message.class, id);

	}

	@Override
	public ActiveMember findActiveMemeberByUsername(String username) {
		return entityManager.find(ActiveMember.class, username);

	}

	@Override
	public ActiveMember findActiveMemberById(Long long1) {
		return entityManager.find(ActiveMember.class, long1);

	}

	@Override
	public ActiveMember findActiveMemberByEmail(String email) {
		return entityManager.find(ActiveMember.class, email);

	}

	@Override
	public List<Message> readAllMessageByIDActiveMember(
			ActiveMember activeMember) {
		Query query = entityManager.createQuery("Select e from Message e where e.activeMember=:l ");
		query.setParameter("l", activeMember);

		try {
			activeMember =  (ActiveMember) query.getResultList();


		} catch (Exception e) {
			activeMember=null;
		}
		return query.getResultList();
	}

	

}