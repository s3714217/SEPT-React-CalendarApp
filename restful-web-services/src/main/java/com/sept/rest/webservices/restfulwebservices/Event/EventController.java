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
		
		service.add(event);
		
	}
	
	@DeleteMapping(value = "/{userName}/event/{id}")
	public void DeleteEvent(@PathVariable (required = true) String userName,@PathVariable (required = true) int id,@RequestBody Event event){
		service.delete(id, event);
		
	}
	
	
	
	@PutMapping(value = "/{userName}/event/{id}")
	public void UpdateEvent(@PathVariable (required = true) String userName,@PathVariable (required = true) int id,@RequestBody Event event){
		service.update(id, event);
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/{userName}/event/")
	public List<Event> DisplayEvents(@PathVariable(required = true) String userName){
		return service.getEvents();
		
		
	
		
		
	}
    
}