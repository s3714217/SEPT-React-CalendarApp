package com.sept.rest.webservices.restfulwebservices.Day;

import java.util.*;
import javax.persistence.*;

import com.sept.rest.webservices.restfulwebservices.Event.Event;

@Entity
@Table(name = "days")
public class Day {
    @Id
    @Column(nullable = false)
    private int dayNumber;
    @Column(nullable = false)
    private String month;
   
    @OneToMany
    @JoinColumn(name = "DayNumber")
    private ArrayList<Event> events = new ArrayList<Event>();
    
    

    public Day(int number, String month) {
        this.dayNumber = number;
        this.month = month;
      
    }

    public int getDayNumber() {
        return this.dayNumber;
    }

  

    public String getDayMonth() {
        return this.month;
    }

	public void setEvent(Event event) {
		for(Event event1 : events) {
			if(event1.getEventID() == event.getEventID()) {
				events.remove(event1);
				events.add(event);
				
			}
			else {
				events.add(event);
			}
			
		}
		
	}
	

	public void deleteEvent(int eventId) {
		for(Event event : events) {
			if(event.getEventID() == eventId) {
				events.remove(event);
				
				
			}
		}
	}

	public ArrayList<Event> getEvents() {
		
		return events;
	}

    
   


}
