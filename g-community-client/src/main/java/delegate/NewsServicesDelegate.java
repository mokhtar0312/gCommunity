package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.NewsServicesRemote;
import entities.News;

public class NewsServicesDelegate {
	//private static NewsServicesRemote remote;
	private static final String jndi = "/g-community-ejb/NewsServices!services.interfaces.NewsServicesRemote";

	private static NewsServicesRemote getProxy() {
		return (NewsServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	
	public static Boolean addNews(News News)
	{
		return getProxy().addNews(News);
	}

	public static News findNewsbyId(Integer id)
	{
		return getProxy().findNewsbyId(id);
	}

	public static Boolean updateNews(News News)
	{
		return getProxy().updateNews(News);
	}

	public static Boolean deleteNews(News news)
	{
		return getProxy().deleteNews(news);
	}

	public static List<News> DisplayAllNews()
	{
		return getProxy().DisplayAllNews();
	}
}
