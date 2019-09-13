package MockClasses;

public class MockCalendar 
{
	public long today;
	public long dayMiliSec = 86400000;
	
	public MockCalendar()
	{
		today = System.currentTimeMillis();
	}
	
	public boolean validEventEnd(long start, long end)
	{
		boolean result = false;
		if(end > start)
		{
			result = true;
		}
		return result;
	}
}
