package backEndTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sept.rest.webservices.restfulwebservices.Event.Event;
import com.sept.rest.webservices.restfulwebservices.Event.EventService;
import com.sept.rest.webservices.restfulwebservices.user.User;
import com.sept.rest.webservices.restfulwebservices.user.UserService;

class EventTests {
	Event mockEvent;
	EventService es;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		Event mockEvent = new Event("title", "desc", "time", "location", null, "username");
		EventService es = new EventService();
		mockEvent.setEventID(1);
	}


	@Test
	void userExistenceTest() 
	{
		es.add(mockEvent);
		List<Event> list = es.getEvents();
		assertEquals(mockEvent, list.get(0));
	}
	
	@Test
	void userExistenceNegativeTest() 
	{
		List<Event> list = es.getEvents();
		assertEquals(mockEvent, list.get(0));
	}
	
	@Test
	void getEventByIdTest()
	{
		es.add(mockEvent);
		assertEquals(mockEvent, es.getEventById(1));
	}
	
	@Test
	void getEventByIdNegativeTest()
	{
		assertEquals(mockEvent, es.getEventById(1));
	}
	
	@Test
	void deleteEventTest()
	{
		es.add(mockEvent);
		es.delete(1, mockEvent);
		es.getEventById(1);
	}
}
