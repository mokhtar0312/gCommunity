package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.TutorialServicesLocal;
import services.interfaces.TutorialServicesRemote;
import entities.Tutorial;

/**
 * Session Bean implementation class TutorialServices
 */
@Stateless
public class TutorialServices implements TutorialServicesRemote,
		TutorialServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TutorialServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addTutorial(Tutorial tutorial) {
		Boolean b = false;
		try {
			entityManager.merge(tutorial);
			b = true;
		} catch (Exception e) {
			System.err.println("problem adding tutorial");
		}
		return b;
	}

	@Override
	public Boolean deleteTutorialById(Integer id) {
		Boolean b = false;
		try {
			Tutorial tutofound = entityManager.find(Tutorial.class, id);
			entityManager.remove(entityManager.merge(tutofound));
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting tutorial");
		}
		return b;
	}

	@Override
	public Tutorial findTutorialById(Integer id) {
		Tutorial tutofound = entityManager.find(Tutorial.class, id);
		return tutofound;
	}

	@Override
	public Boolean updateTutorial(Tutorial tutorial) {
		Boolean b = false;
		try {
			entityManager.merge(tutorial);
			b = true;
		} catch (Exception e) {
			System.err.println("problem updating packs");
		}
		return b;
	}

	@Override
	public Boolean deleteTutorial(Tutorial tutorial) {
		Boolean b = false;
		try {
			entityManager.remove(entityManager.merge(tutorial));
			b = true;
		} catch (Exception e) {
			System.err.println("problem deleting packs");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tutorial> findAllTutorial() {
		String jpql = "select t from Tutorial t";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

}
