package com.sept.rest.webservices.restfulwebservices.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sept.rest.webservices.restfulwebservices.Day.Day;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    EventService service;

    @PostMapping(value = "/{userName}/event/")
	public void createEvent(@RequestBody Event event){
		service.repository.addEvent(event);
		
		service.add(event);
		
		
	}
	
	@DeleteMapping(value = "/{userName}/event/{id}")
	public void DeleteEvent(@PathVariable (required = true) String userName,@PathVariable (required = true) int id,@RequestBody Event event){
		Event event1 = service.repository.findEvent(event.getEventID());
		//FIT HERE EVENT SETUP
		if(!(event1 == null)&&event1.getEventID() == id) {
		service.delete(event1.getEventID());
		}
		
	}
	
	
	
	@PutMapping(value = "/{userName}/event/{id}")
	public void UpdateEvent(@PathVariable (required = true) String userName,@PathVariable (required = true) int id,@RequestBody Event event){
		Event event1 = service.repository.findEvent(event.getEventID());
		//FIT HERE EVENT SETUP
		if(!(event1==null)) {
		service.update(event1.getEventID(), event1);
		}
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/{userName}/event/")
	public List<Event> DisplayEvents(@PathVariable(required = true) String userName){
		
		
	
		List<Event> events = service.repository.findAll();
		List<Event> eventsForUser = null;
		for(Event event : events) {
			if(event.getUser().getUserName().equals(userName)) {
				eventsForUser.add(event);
			}
			
		}
		return eventsForUser;
		
	}
    
}