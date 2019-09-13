package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MockClasses.MockCalendar;

class MockCalendarTests {
	
	public static MockCalendar calendar;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception 
	{
		calendar = new MockCalendar();
	}

	@AfterEach
	void tearDown() throws Exception {}

	@Test
	public void validEndDateTest() 
	{
		long tomorrow = calendar.today + calendar.dayMiliSec;
		assertTrue(calendar.validEventEnd(calendar.today, tomorrow));
	}

}
