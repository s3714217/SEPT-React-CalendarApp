package com.sept.rest.webservices.restfulwebservices.Day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sept.rest.webservices.restfulwebservices.Event.Event;

import java.util.List;


@RestController
public class DayController {
	@Autowired
	private DayService dayService;
	
	@GetMapping(value = "/{month}/{day}")
	public Day displayDayDetails(@PathVariable(required = true) String month,@PathVariable(required = true) int day){
		
		Day tempday = dayService.repository.findDay(day, month);
		if(tempday != null) {
		dayService.DisplayEvents(tempday);
		return tempday;
		}
		else {
			dayService.createDay(day, month);
			tempday = dayService.repository.findDay(day, month);
			return tempday;
		}
		
		
	}
	
	@PostMapping(value = "/{month}/{day}/create")
	public void createEventOnDay(@PathVariable(required = true) String month,@PathVariable(required = true) int day,@RequestBody Event event){
		Day tempday = dayService.repository.findDay(day, month);
		
		dayService.addEvent(tempday, event);
		
		
	}
	
	@DeleteMapping(value = "/{month}/{day}/delete/{EventId}")
	public void DeleteEventOnDay(@PathVariable(required = true) String month,@PathVariable(required = true) int day,@PathVariable(required = true) int eventID){
		Day tempday = dayService.repository.findDay(day, month);
		//FIT HERE EVENT SETUP
		dayService.deleteEvent(tempday, eventID);
		
		
	}
	
	
	
	@PutMapping(value = "/{month}/{day}/update/{EventId}")
	public void UpdateEventOnDay(@PathVariable(required = true) String month,@PathVariable(required = true) int day,@PathVariable(required = true) int eventID,@RequestBody Event event){
		Day tempday = dayService.repository.findDay(day, month);
		//FIT HERE EVENT SETUP
		dayService.updateEvent(tempday, event);
		
		
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/{month}")
	public List<Event> DisplayEventOnMonth(@PathVariable(required = true) String month){
		
		List<Day> daysWithEvents = dayService.repository.findAll();
		List<Event> events = null;
		for(Day day : daysWithEvents) {
			if(day.getDayMonth().equalsIgnoreCase(month)) {
				events.addAll(day.getEvents());
			}
		}
		return events;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
  
