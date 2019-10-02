package com.sept.rest.webservices.restfulwebservices;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//For User related tests
import com.sept.rest.webservices.restfulwebservices.user.User;
import com.sept.rest.webservices.restfulwebservices.user.UserController;
import com.sept.rest.webservices.restfulwebservices.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulWebServicesApplicationTests {

	@Autowired
	User user;
	User UserController;
	UserService userService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{

		String string = "string";
	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterAll
//	static void tearDownAfterClass() throws Exception 
//	{
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeEach
//	void setUp() throws Exception 
//	{
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterEach
//	void tearDown() throws Exception 
//	{
//	}
	
	@Test
	public void test()
	{
		
		//assertEquals("a", aVariable);
		assertEquals(2, 2);
	}

	
	//User Controller Tests
//	@Test
//	void test2() 
//	{
//		fail("Not yet implemented");
//	}
	
	//UserService Tests
//	@Test (expected=NullPointerException.class)
//	public void nullCreateUserTest()
//	{
//		userService.createUser(null);
//	}

}
