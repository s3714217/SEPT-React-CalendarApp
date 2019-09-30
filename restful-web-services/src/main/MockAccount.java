package MockClasses;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.function.BooleanSupplier;

public class MockAccount 
{
	public String username;
	public String password;
	
	public MockAccount(String u, String p)
	{
		username = u;
		password = p;
	}
	
	public boolean validUsername(String username)
	{
		boolean result = true;
		
		String[] specialChars = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};
		for (int i = 0; i < specialChars.length; ++i)
		{
			if(password.contains(specialChars[i]))
			{
				result = false;
			}
		}
		return result;
	}
	
	public boolean validPassword(String password)
	{
		boolean result = false;
		
		String[] specialChars = {"!", "@", "#", "$", "%", "^", "7", "*", "(", ")"};
		for (int i = 0; i < specialChars.length; ++i)
		{
			if(password.contains(specialChars[i]))
			{
				result  = true;
			}
		}
		return result;
	}

	public boolean capslock() 
	{
		boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
		return isOn;
	}
	
}
