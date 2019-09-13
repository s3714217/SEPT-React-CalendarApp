package MockClasses;

public class MockEvent 
{
	public String name;
	public long date;
	public String location;
	public long today;
	public long dayMiliSec = 86400000;


	public MockEvent(String name, long date, String location)
	{
		this.name = name;
		this.date = date;
		this.location = location;
		today = System.currentTimeMillis();
	}
	
	public boolean validDate(long date)
	{
		boolean result = false;
		if(date > today)
		{
			result = true;
		}
		return result;
	}
}
