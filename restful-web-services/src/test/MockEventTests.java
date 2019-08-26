package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MockClasses.MockEvent;

class MockEventTests {
	
	public static MockEvent event;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception 
	{
		event = new MockEvent("New Event", event.today, "Here");
	}

	@AfterEach
	void tearDown() throws Exception {}

	@Test
	void validDateTest() 
	{
		long tomorrow = event.date + event.dayMiliSec;
		assertTrue(event.validDate(tomorrow));
	}

}
