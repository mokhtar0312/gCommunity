package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.TutorialServicesRemote;
import entities.SimpleMember;
import entities.Tutorial;

public class TutorialServicesDelegate {

	// private static TutorialServicesRemote remote;
	private static final String jndi = "/g-community-ejb/TutorialServices!services.interfaces.TutorialServicesRemote";

	private static TutorialServicesRemote getProxy() {
		return (TutorialServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}

	public static Boolean addTutorial(Tutorial tutorial,
			SimpleMember simplemembertut) {
		return getProxy().addTutorial(tutorial, simplemembertut);
	}

	public static Tutorial findTutorialbyId(Integer id) {
		return getProxy().findTutorialById(id);
	}

	public static Boolean updateTutorial(Tutorial Tutorial) {
		return getProxy().updateTutorial(Tutorial);
	}

	public static Boolean deleteTutorialbyId(Integer id) {
		return getProxy().deleteTutorialById(id);
	}

	public static Boolean deleteTutorial(Tutorial tutorial) {
		return getProxy().deleteTutorial(tutorial);
	}

	public static List<Tutorial> FindAllTutorial() {
		return getProxy().findAllTutorial();
	}

	public static List<Tutorial> findByTyped(String typed) {
		return getProxy().FindbyTyped(typed);
	}
}
