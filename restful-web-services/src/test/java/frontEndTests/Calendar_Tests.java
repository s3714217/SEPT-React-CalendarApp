package frontEndTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import mockObjects.MockCalendar;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Calendar_Tests {
	
	MockCalendar calendar = new MockCalendar();
	
//Calendar Tests
	//Event Tests
	@Test
	void fullInputFieldsTest()
	{
		//Fill in all fields
		assertFalse(calendar.getMockEvent().emptyInputField());
	}

	@Test
	void emptyInputFieldsTest()
	{
		//Leave some fields empty
		assertTrue(calendar.getMockEvent().emptyInputField());
	}
	
	@Test
	void validLocationLengthTest()
	{
		//Set location field to length > 5
		assertTrue(calendar.getMockEvent().checkLength(calendar.getMockEvent().getLocation(), 5));
	}
	
	@Test
	void invalidLocationLengthTest()
	{
		//Set location field to length =< 5
		assertFalse(calendar.getMockEvent().checkLength(calendar.getMockEvent().getLocation(), 5));
	}
	
	@Test
	void validTitleLengthTest()
	{
		//Set location field to length > 3
		assertTrue(calendar.getMockEvent().checkLength(calendar.getMockEvent().getTitle(), 5));
	}
	
	@Test
	void invalidTitleLengthTest()
	{
		//Set location field to length =< 3
		assertFalse(calendar.getMockEvent().checkLength(calendar.getMockEvent().getTitle(), 5));
	}
	
	@Test
	void correctDateRegexTest()
	{
		//Set date input field to form yyyy-mm-dd
		assertTrue(calendar.getMockEvent().correctDateRegex(calendar.getMockEvent().getDate()));
	}
	
	@Test
	void incorrectDateRegexTest()
	{
		//Set date input field to form NOT yyyy-mm-dd
		assertFalse(calendar.getMockEvent().correctDateRegex(calendar.getMockEvent().getDate()));
	}
	
	@Test
	void validMonthTest()
	{
		//Set date's month, x, to 1 => x =< 12
		assertTrue(calendar.getMockEvent().validMonth(calendar.getMockEvent().getMonth()));
	}
	
	@Test
	void invalidMonthTest()
	{
		//Set date's month, x, to 1 < x > 12
		assertFalse(calendar.getMockEvent().validMonth(calendar.getMockEvent().getMonth()));
	}
	
	@Test
	void validDayTest()
	{
		//E.g. set day to =<28 if month = 2/February
		assertTrue(calendar.getMockEvent().validDay(calendar.getMockEvent().getDay(), calendar.getMockEvent().getMonth()));
	}
	
	@Test
	void invalidDayTest()
	{
		//E.g. set day to >28 if month = 2/February
		assertFalse(calendar.getMockEvent().validDay(calendar.getMockEvent().getDay(), calendar.getMockEvent().getMonth()));
	}
	
//Calendar Tests
	//Calendar Tests
}
