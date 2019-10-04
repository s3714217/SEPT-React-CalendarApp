package frontEndTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import mockObjects.MockCalendar;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Calendar_Tests {

//Calendar Tests
	//Event Tests
	@Test
	void fullInputFieldsTest()
	{
		//Fill in all fields
		assertFalse(MockCalendar.getMockEvent().emptyInputField());
	}

	@Test
	void emptyInputFieldsTest()
	{
		//Leave some fields empty
		assertTrue(MockCalendar.getMockEvent().emptyInputField());
	}
	
	@Test
	void validLocationLengthTest()
	{
		//Set location field to length > 5
		assertTrue(MockCalendar.getMockEvent().checkLength(MockCalendar.getMockEvent().getLocation(), 5));
	}
	
	@Test
	void invalidLocationLengthTest()
	{
		//Set location field to length =< 5
		assertFalse(MockCalendar.getMockEvent().checkLength(MockCalendar.getMockEvent().getLocation(), 5));
	}
	
	@Test
	void validTitleLengthTest()
	{
		//Set location field to length > 3
		assertTrue(MockCalendar.getMockEvent().checkLength(MockCalendar.getMockEvent().getTitle(), 5));
	}
	
	@Test
	void invalidTitleLengthTest()
	{
		//Set location field to length =< 3
		assertFalse(MockCalendar.getMockEvent().checkLength(MockCalendar.getMockEvent().getTitle(), 5));
	}
	
	@Test
	void correctDateRegexTest()
	{
		//Set date input field to form yyyy-mm-dd
		assertTrue(MockCalendar.getMockEvent().correctDateRegex(MockCalendar.getMockEvent().getDate()));
	}
	
	@Test
	void incorrectDateRegexTest()
	{
		//Set date input field to form NOT yyyy-mm-dd
		assertFalse(MockCalendar.getMockEvent().correctDateRegex(MockCalendar.getMockEvent().getDate()));
	}
	
	@Test
	void validMonthTest()
	{
		//Set date's month, x, to 1 => x =< 12
		assertTrue(MockCalendar.getMockEvent().validMonth(MockCalendar.getMockEvent().getMonth()));
	}
	
	@Test
	void invalidMonthTest()
	{
		//Set date's month, x, to 1 < x > 12
		assertFalse(MockCalendar.getMockEvent().validMonth(MockCalendar.getMockEvent().getMonth()));
	}
	
	@Test
	void validDayTest()
	{
		//E.g. set day to =<28 if month = 2/February
		assertTrue(MockCalendar.getMockEvent().validDay(MockCalendar.getMockEvent().getDay(), MockCalendar.getMockEvent().getMonth()));
	}
	
	@Test
	void invalidDayTest()
	{
		//E.g. set day to >28 if month = 2/February
		assertFalse(MockCalendar.getMockEvent().validDay(MockCalendar.getMockEvent().getDay(), MockCalendar.getMockEvent().getMonth()));
	}
	
//Calendar Tests
	//Calendar Tests
}