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

    @PostMapping(value = "/")
	public void createEvent(@RequestBody Event event){
		service.repository.addEvent(event);
		
		service.add(event);
		
		
	}
	
	@DeleteMapping(value = "/")
	public void DeleteEvent(@RequestBody Event event){
		Event event1 = service.repository.findEvent(event.getEventID());
		//FIT HERE EVENT SETUP
		service.delete(event1.getEventID());
		
		
	}
	
	
	
	@PutMapping(value = "/")
	public void UpdateEvent(@RequestBody Event event){
		Event event1 = service.repository.findEvent(event.getEventID());
		//FIT HERE EVENT SETUP
		service.update(event1.getEventID(), event1);
		
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/")
	public List<Event> DisplayEvents(){
		
	
		List<Event> events = service.repository.findAll();
		
		return events;
		
	}
    
}