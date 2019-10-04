package com.sept.rest.webservices.restfulwebservices.Day;

import java.util.*;

import com.sept.rest.webservices.restfulwebservices.Event.Event;

public interface DayServiceInterface {
	public abstract void createDay(int number,String month);
	public abstract void addEvent(Day day,Event event);
	   public abstract void updateEvent(Day day,Event event);
	   public abstract void deleteEvent(Day day,int EventId);
	   public abstract Collection<Day> getDays();
	   public abstract  ArrayList<Event> DisplayEvents(Day day);
	

}
