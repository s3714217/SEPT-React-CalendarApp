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
        repository.saveAndFlush(event);
    }

    public void update(long eventID,Event event) {
    	Optional<Event> event1 = repository.findById(eventID);
    	if(event1.isPresent()) {
    		repository.save(event);
    	}
    	
     }

    public void delete(long id,Event event) {
       Optional<Event> event1 = repository.findById(id);
       if(event1.isPresent()) {
    	   repository.delete(event);
       }
    }

    public List<Event> getEvents() {
       return repository.findAll();
    }

    public Optional<Event> getEventById(long id) {
      Optional<Event> event1 = repository.findById(id);
      if(event1.isPresent()) {
    	  return event1;
      }
      else {
    	  return null;
      }
       

    }

   // public Event getEventByDay(Day day) {
       

   // }
    
    

  

}