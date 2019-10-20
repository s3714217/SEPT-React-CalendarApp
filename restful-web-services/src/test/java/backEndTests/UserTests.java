package backEndTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sept.rest.webservices.restfulwebservices.user.User;
import com.sept.rest.webservices.restfulwebservices.user.UserService;

class UserTests 
{
	User mockUser;
	UserService us;
	@BeforeEach
	void setUp() throws Exception 
	{
		mockUser = new User("Username", "Password");
		us = new UserService();
	}
	
	@Test
	void userExistenceTest() 
	{
		us.createUser(mockUser);
		List<User> list = us.getAllUsers();
		assertEquals(mockUser, list.get(0));
	}
	
	@Test
	void userExistenceNegativeTest() 
	{
		List<User> list = us.getAllUsers();
		assertEquals(mockUser, list.get(0));
	}

}