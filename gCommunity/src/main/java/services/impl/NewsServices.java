package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.NewsServicesLocal;
import services.interfaces.NewsServicesRemote;
import entities.News;

/**
 * Session Bean implementation class NewsServices
 */
@Stateless
@LocalBean
public class NewsServices implements NewsServicesRemote, NewsServicesLocal {
	@PersistenceContext
	EntityManager entitymanager;

	/**
	 * Default constructor.
	 */
	public NewsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addNews(News news) {
		Boolean b = false;
		try {
			entitymanager.merge(news);
			b = true;
		} catch (Exception e) {
			System.err.println("couldn't add news");
		}
		return b;
	}

	@Override
	public News findNewsbyId(Integer Id) {
		News newsfound = entitymanager.find(News.class, Id);
		return newsfound;
	}

	@Override
	public Boolean updateNews(News news) {
		Boolean b = false;
		try {
			entitymanager.merge(news);
			b = true;
		} catch (Exception e) {
			System.err.println("problem when updating news");
		}
		return b;
	}

	@Override
	public Boolean deleteNews(News news) {
		Boolean b = false;
		try {
			entitymanager.remove(entitymanager.merge(news));
			b = true;
		} catch (Exception e) {
			System.err.println("ouups ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<News> DisplayAllNews() {
		String jpql = "select n from News n";
		Query query = entitymanager.createQuery(jpql);
		return query.getResultList();
	}

}
