package com.sept.rest.webservices.restfulwebservices.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

import com.sept.rest.webservices.restfulwebservices.Day.Day;
import com.sept.rest.webservices.restfulwebservices.Event.Event;

@Component
public class EventService {
    @Autowired
    EventJpaRepository repository;

    public void add(Event event) {
        repository.addEvent(event);
        repository.save(event);
    }
    
    public void update(int eventID,Event event) {
    	
    	 repository.updateEvent(eventID, event);
    	
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Event> getEvents() {
        return (List<Event>) repository.findAll();
    }

    public Event getEventById(int id) {
        Event optionalEvent = repository.findEvent(id);
        return optionalEvent;

    }

    public Event getEventByDay(Day day) {
        Event optionalEvent = repository.findEvent(day);
        return optionalEvent;

    }
    
    

  

}