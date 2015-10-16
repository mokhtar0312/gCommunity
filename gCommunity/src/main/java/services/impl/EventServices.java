package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.EventServicesLocal;
import services.interfaces.EventServicesRemote;
import entities.Event;

/**
 * Session Bean implementation class EventServices
 */
@Stateless
@LocalBean
public class EventServices implements EventServicesRemote, EventServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EventServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.persist(event);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteEventById(Integer id) {
		Boolean b = false;
		try {
			entityManager.remove(findEventById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Event findEventById(Integer id) {
		return entityManager.find(Event.class, id);

	}

	@Override
	public Boolean updateEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.merge(event);
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@Override
	public Boolean deleteEvent(Event event) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(event));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEvents() {
		String jpql = "select e from Event e";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
