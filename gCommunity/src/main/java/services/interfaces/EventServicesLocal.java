package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Event;

@Local
public interface EventServicesLocal {
Boolean addEvent(Event event);
	
	Boolean deleteEventById(Integer id);

	Event findEventById(Integer id);

	Boolean updateEvent(Event event);

	Boolean deleteEvent(Event event);

	List<Event> findAllEvents();
}
