package delegate;

import java.util.List;

import locator.ServiceLocator;
import services.interfaces.EventServicesRemote;
import entities.Event;
import entities.SimpleMember;

public class EventServiceDelegate {
	private static EventServicesRemote remote;
	private static final String jndi = "/g-community-ejb/EventServices!services.interfaces.EventServicesRemote";

	private static EventServicesRemote getProxy() {
		return (EventServicesRemote) ServiceLocator.getInstance().getProxy(
				jndi);
	}
	
	public static Boolean DoAddEvent(Event event)
	{
		return getProxy().addEvent(event);
	}

	public static Event DoFindEventById(Integer id)
	{
		return getProxy().findEventById(id);
	}
	public static Boolean DoDeleteEvent(Event event)
	{
		return getProxy().deleteEvent(event);
	}

	public static Boolean DoUpdateEvent(Event event)
	{
		System.out.println("updated");
		return getProxy().updateEvent(event);
	}

	public static Boolean DoDeleteEventById(Integer id)
	{
		return getProxy().deleteEventById(id);
	}

	public static List<Event> findAllEvents()
	{
		return getProxy().findAllEvents();
	}
	public static Event DoFindEventByName (String nom){
		return getProxy().findEventByName(nom);
	}
	public static Boolean DoAffectSimpleMemberToEvent(Event event,
			List<SimpleMember> simpleMembers) {
		return getProxy().affectSimpleMemberToEvent(event, simpleMembers);
	}
	public static List<Event> DofindAllEventsRestants(SimpleMember simpleMember) {
		return getProxy().findAllEventsRestants(simpleMember);
	}
}
