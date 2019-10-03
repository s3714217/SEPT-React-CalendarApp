package com.sept.rest.webservices.restfulwebservices.Day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sept.rest.webservices.restfulwebservices.Event.Event;

import java.util.List;


@RestController
public class DayController {
	@Autowired
	private DayService dayService;
	
	@RequestMapping(value = "/{month}/{day}")
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
	
	@RequestMapping(value = "/{month}/{day}/create")
	public void createEventOnDay(@PathVariable(required = true) String month,@PathVariable(required = true) int day){
		Day tempday = dayService.repository.findDay(day, month);
		//FIT HERE EVENT SETUP
		dayService.addEvent(tempday, event);
		
		
	}
	
	@RequestMapping(value = "/{month}/{day}/delete/{EventId}")
	public void DeleteEventOnDay(@PathVariable(required = true) String month,@PathVariable(required = true) int day,@PathVariable(required = true) int eventID){
		Day tempday = dayService.repository.findDay(day, month);
		//FIT HERE EVENT SETUP
		dayService.deleteEvent(tempday, eventID);
		
		
	}
	
	
	
	@RequestMapping(value = "/{month}/{day}/update/{EventId}")
	public void UpdateEventOnDay(@PathVariable(required = true) String month,@PathVariable(required = true) int day,@PathVariable(required = true) int eventID){
		Day tempday = dayService.repository.findDay(day, month);
		//FIT HERE EVENT SETUP
		dayService.updateEvent(day, event);
		
		
	}
	
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
  
