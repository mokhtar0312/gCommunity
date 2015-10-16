package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Event;

@Remote
public interface EventServicesRemote {

Boolean addEvent(Event event);
	
	Boolean deleteEventById(Integer id);

	Event findEventById(Integer id);

	Boolean updateEvent(Event event);

	Boolean deleteEvent(Event event);

	List<Event> findAllEvents();
}
