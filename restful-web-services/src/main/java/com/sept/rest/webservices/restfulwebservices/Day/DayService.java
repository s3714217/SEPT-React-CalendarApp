package com.sept.rest.webservices.restfulwebservices.Day;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sept.rest.webservices.restfulwebservices.Event.Event;

import java.util.*;


@Component
@Service
public class DayService implements DayServiceInterface{
    @Autowired
    DayJpaRepository repository;
    
    

	@Override
	public void createDay(int number,String month) {
		Day day = new Day(number,month);
		repository.Add(day);
		
	}
	
	
	@Override
	public void addEvent(Day day, Event event) {
		Day day1 = repository.findDay(day.getDayNumber(), day.getDayMonth());
		day1.setEvent(event);
		repository.updateDay(day1);
		
	}

	@Override
	public void updateEvent(Day day, Event event) {
		Day day1 = repository.findDay(day.getDayNumber(), day.getDayMonth());
		day1.setEvent(event);
		repository.updateDay(day1);
		
	}

	@Override
	public void deleteEvent(Day day,int EventId) {
		Day day1 = repository.findDay(day.getDayNumber(), day.getDayMonth());
		day1.deleteEvent(EventId);
		repository.updateDay(day1);
		
	}

	@Override
	public Collection<Day> getDays() {
		return repository.findAll();
	}

	@Override
	public ArrayList<Event> DisplayEvents(Day day) {
		
		ArrayList<Event> events = day.getEvents();
		return events;
		
	}

	

  

}